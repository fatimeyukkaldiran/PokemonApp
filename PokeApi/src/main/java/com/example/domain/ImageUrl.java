package com.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "back_default"
})
public class ImageUrl {

    @JsonProperty("back_default")
    private String url;

    @JsonProperty("back_default")
    public String getUrl() {
        return url;
    }

    @JsonProperty("back_default")
    public void setUrl(String url) {
        this.url = url;
    }
}
