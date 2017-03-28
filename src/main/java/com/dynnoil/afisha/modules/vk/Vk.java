package com.dynnoil.afisha.modules.vk;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Binder;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;
import com.vk.api.sdk.objects.groups.Group;
import com.vk.api.sdk.objects.groups.GroupType;
import com.vk.api.sdk.objects.groups.responses.SearchResponse;
import org.jooby.*;

import java.util.List;

/**
 * Vk module
 * <p>
 * Created by SBT-Krukov-LYu on 14.03.2017.
 */
public class Vk implements Jooby.Module {
    private UserActor actor;
    private VkApiClient vkApiClient;

    @Override
    public void configure(Env env, Config config, Binder binder) throws Throwable {

        /*env.onStart(() -> {
            TransportClient transportClient = HttpTransportClient.getInstance();
            vkApiClient = new VkApiClient(transportClient);
        });

        Router router = env.router();
        router.get("/auth", (Request rq, Response rs) -> {
            final String code = rq.param("code").to(String.class, MediaType.plain);
            initializeUserActor(config, code);
            rs.send("Done!");
        });
        router.get("/vk", (rq, rs) -> {
            SearchResponse searchResponse = vkApiClient.groups().search(actor, "")
                    .type(GroupType.EVENT.getValue())
                    .countryId(1)
                    .cityId(41)
                    .future(true)
                    .execute();
            List<Group> groups = searchResponse.getItems();
            String json = new ObjectMapper().writeValueAsString(groups);
            rs.send(Results.json(json));
        });*/

    }

    @Override
    public Config config() {
        return ConfigFactory.parseResources(Vk.class, "vk.conf");
    }

    /*private void initializeUserActor(Config config, String code) throws Throwable {
        final Integer appId = Integer.valueOf(config.getString("vk.app_id"));
        final String clientSecret = config.getString("vk.client_secret");
        final String redirectUri = config.getString("vk.redirect_uri");
        UserAuthResponse authResponse = vkApiClient.oauth()
                .userAuthorizationCodeFlow(appId, clientSecret, redirectUri, code)
                .execute();
        actor = new UserActor(authResponse.getUserId(), authResponse.getAccessToken());
    }*/
}
