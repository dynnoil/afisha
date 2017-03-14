package com.dynnoil.afisha;

import com.dynnoil.afisha.modules.VK;
import org.jooby.Jooby;

/**
 * @author jooby generator
 */
public class App extends Jooby {

    {
        get("/", () -> "Hello World!");
        use(new VK());
    }

    public static void main(final String[] args) {
        run(App::new, args);
    }

}
