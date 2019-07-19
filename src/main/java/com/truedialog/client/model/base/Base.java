package com.truedialog.client.model.base;


import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class Base {

    @JsonProperty("Id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
