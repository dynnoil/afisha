package com.dynnoil.afisha;

import org.jooby.Jooby;
import org.jooby.Results;
import org.jooby.assets.Assets;
import org.jooby.hbs.Hbs;

/**
 * @author jooby generator
 */
public class App extends Jooby {

    {
        use(new Hbs());
        use(new Assets());

        get("/", request -> Results.html("index"));
        get("/about", request -> Results.html("about"));
        get("/architecture", request -> Results.html("architecture"));

    }

    public static void main(final String[] args) {
        run(App::new, args);
    }

}
