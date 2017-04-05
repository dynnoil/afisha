package com.dynnoil.afisha;

import org.jooby.Jooby;
import org.jooby.Results;
import org.jooby.assets.Assets;
import org.jooby.hbs.Hbs;
import org.jooby.jdbc.Jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author jooby generator
 */
public class App extends Jooby {

    {
//        use(new Jdbc());

        use(new Hbs());

        use(new Assets());

        /*use(new Vk());

        use(new Auth().client(config -> {
            final String key = config.getString("vk.app_id");
            final String secret = config.getString("vk.client_secret");
            return new VkClient(key, secret);
        }));*/

        get("/", request -> Results.html("index"));
        get("/about", request -> Results.html("about"));
        get("/architecture", request -> Results.html("architecture"));

/*           // start transaction
        before("/api/*", (req, rsp) -> {
            DataSource ds = require(DataSource.class);
            Connection connection = ds.getConnection();
            connection.setAutoCommit(false);
            req.set("connection", connection);
        });

     // commit/rollback transaction
        complete("/api*//*", (req, rsp, cause) -> {
            // unbind connection from request
            try (Connection connection = (Connection) req.unset("connection").get()) {
                if (cause.isPresent()) {
                    connection.rollback();
                    System.out.println("Rollback");
                } else {
                    System.out.println("Committed");
                    connection.commit();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        // your transactional routes goes here
        get("/api/something", req -> {
            Connection connection = req.get("connection");

            ResultSet resultSet;
            try (Statement statement = connection.createStatement()) {
                resultSet = statement.executeQuery("SHOW DATABASES");
            }

            return Results.html("index").put("greeting", "Database usage!").put("data", resultSet);
        });*/
    }

    public static void main(final String[] args) {
        run(App::new, args);
    }

}
