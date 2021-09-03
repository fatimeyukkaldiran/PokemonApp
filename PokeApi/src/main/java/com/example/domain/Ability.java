package com.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(
        "ability"
)
public class Ability {

    @JsonProperty("ability")
    private AbilityInfo abilityInfo;


    @JsonProperty("ability")
    public AbilityInfo getAbilityInfo() {
        return abilityInfo;
    }

    @JsonProperty("ability")
    public void setAbilityInfo(AbilityInfo abilityInfo) {
        this.abilityInfo = abilityInfo;
    }
}
