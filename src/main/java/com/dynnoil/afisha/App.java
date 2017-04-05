package com.dynnoil.afisha;

import com.dynnoil.afisha.model.PageRepository;
import com.dynnoil.afisha.model.pojo.Page;
import com.typesafe.config.Config;
import org.jooby.Err;
import org.jooby.Jooby;
import org.jooby.Results;
import org.jooby.Status;
import org.jooby.assets.Assets;
import org.jooby.hbs.Hbs;
import org.jooby.jdbi.Jdbi;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

/**
 * @author jooby generator
 */
public class App extends Jooby {

    {
        use(new Jdbi().doWith((DBI dbi, Config conf) -> {
            try (Handle handle = dbi.open()) {
                handle.execute(conf.getString("schema"));
            }
        }));
        use(new Hbs("/", ".hbs"));
        use(new Assets());

        get("/", request -> Results.html("index")
                .put("page", getPage("index")).put("main", true));

        get("/about", request -> Results.html("index")
                .put("page", getPage("about")));

        get("/architecture", request -> Results.html("index")
                .put("page", getPage("architecture")));

        get("/development", request -> Results.html("index")
                .put("page", getPage("development")));

        get("/testing", request -> Results.html("index")
                .put("page", getPage("testing")));

        get("/references", request -> Results.html("index")
                .put("page", getPage("references")));
    }

    private Page getPage(String name) {
        return require(DBI.class).inTransaction((handle, status) -> {
            PageRepository repo = handle.attach(PageRepository.class);
            Page page = repo.findByName(name);
            if (page == null) {
                throw new Err(Status.NOT_FOUND);
            }
            return page;
        });
    }

    public static void main(final String[] args) {
        run(App::new, args);
    }

}
