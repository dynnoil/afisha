package com.dynnoil.afisha.modules;

import com.google.inject.Binder;
import com.typesafe.config.Config;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.ServiceActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.ServiceClientCredentialsFlowResponse;
import com.vk.api.sdk.objects.groups.GroupFull;
import org.jooby.Env;
import org.jooby.Jooby;
import org.jooby.MediaType;
import org.jooby.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * VK module
 * <p>
 * Created by SBT-Krukov-LYu on 14.03.2017.
 */
public class VK implements Jooby.Module {
    private static final Logger LOGGER = LoggerFactory.getLogger(VK.class);
    private ServiceActor actor;
    private VkApiClient vk;

    @Override
    public void configure(Env env, Config config, Binder binder) throws Throwable {
        final Integer appId = Integer.valueOf(config.getString("vk.app_id"));
        final String clientSecret = config.getString("vk.client_secret");
        env.onStart(() -> {
            LOGGER.info("Initializing VK API");
            TransportClient transportClient = HttpTransportClient.getInstance();
            vk = new VkApiClient(transportClient);
            ServiceClientCredentialsFlowResponse authResponse = vk.oauth().serviceClientCredentialsFlow(appId, clientSecret).execute();
            actor = new ServiceActor(appId, clientSecret, authResponse.getAccessToken());
        });
        Router router = env.router();
        router.get("/vk", (rq, rs) -> {
            List<GroupFull> groups = vk.groups().getById().groupId("afisha").execute();
            rs.type(MediaType.json).send(groups);
        });
    }
}
