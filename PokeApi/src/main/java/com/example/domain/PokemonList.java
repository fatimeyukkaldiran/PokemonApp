package com.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({
        "results"
})
public class PokemonList {
    @JsonProperty("results")
    private List<Pokemon> results = null;

    @JsonProperty("results")
    public List<Pokemon> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<Pokemon> results) {
        this.results = results;
    }
}
