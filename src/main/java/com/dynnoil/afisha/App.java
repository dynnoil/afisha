package com.dynnoil.afisha;

import com.dynnoil.afisha.modules.vk.VK;
import org.jooby.Jooby;
import org.jooby.Results;
import org.jooby.assets.Assets;
import org.jooby.hbs.Hbs;
import org.jooby.pac4j.Auth;
import org.pac4j.oauth.client.VkClient;

/**
 * @author jooby generator
 */
public class App extends Jooby {

    {
        use(new Hbs());

        use(new Assets());

        /*use(new VK());

        use(new Auth().client(config -> {
            final String key = config.getString("vk.app_id");
            final String secret = config.getString("vk.client_secret");
            return new VkClient(key, secret);
        }));*/

        get("/", request -> Results.html("index").put("greeting", "Hello, World!"));
    }

    public static void main(final String[] args) {
        run(App::new, args);
    }

}
