package com.truedialog.client.model.internal;

import java.util.ArrayList;

/**
* Details for updating or creating content groups
*/
    public class CreateUpdateContent
{

    /**
    * The name of the content
    */
    private String name;

    /**
    * Addtional description data
    */
    private String description;

    /**
    * List of templates to create or update along with the content item.
    */
    private Iterable<CreateUpdateContentTemplate> templates = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Iterable<CreateUpdateContentTemplate> getTemplates() {
        return templates;
    }

    public void setTemplates(Iterable<CreateUpdateContentTemplate> templates) {
        this.templates = templates;
    }
}