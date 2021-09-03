package com.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "sprites"
})
public class Sprites {

    @JsonProperty("sprites")
    private ImageUrl imageUrl;

    @JsonProperty("sprites")
    public ImageUrl getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("sprites")
    public void setImageUrl(ImageUrl imageUrl) {
        this.imageUrl = imageUrl;
    }
}
