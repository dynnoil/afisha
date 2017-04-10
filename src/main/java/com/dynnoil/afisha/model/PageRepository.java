package com.dynnoil.afisha.model;

import com.dynnoil.afisha.model.pojo.Page;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.helpers.MapResultAsBean;

import java.io.Closeable;

/**
 * Page Repository
 * <p>
 * Created by DynNoil on 05.04.2017.
 */
public interface PageRepository extends Closeable {

    /**
     * Method finds a page in the database by page's name
     *
     * @return Page
     */
    @SqlQuery("SELECT * FROM pages WHERE name = :name")
    @MapResultAsBean
    Page findByName(@Bind("name") String name);
}
