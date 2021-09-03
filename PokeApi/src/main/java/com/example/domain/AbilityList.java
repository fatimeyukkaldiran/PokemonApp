package com.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder(
        "abilities"
)
public class AbilityList {

    @JsonProperty("abilities")
    List<Ability> abilities;

    @JsonProperty("abilities")
    public List<Ability> getAbilities() {
        return abilities;
    }

    @JsonProperty("abilities")
    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }
}
