package com.example.kenguyen.codermovie.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by KeNguyen on 15/10/2016.
 */

public class Movie_trailer {
    @SerializedName("name")
    private String name;
    @SerializedName("size")
    private String size;
    @SerializedName("source")
    private String source;
    @SerializedName("type")
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
