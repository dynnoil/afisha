package com.dynnoil.afisha.model.pojo;

/**
 * Page Entity
 * <p>
 * Created by DynNoil on 05.04.2017.
 */
public class Page {
    private String name;
    private String title;
    private String description;
    private String content;

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }
}
