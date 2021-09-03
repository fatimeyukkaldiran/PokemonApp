package com.example.domain;

import java.util.List;

public class PokemonInfo {

    private int id;
    private String name;
    private String image;
    private List<Ability> abilities;

    public PokemonInfo(int id, String name, String image, List<Ability> abilities) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.abilities = abilities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }
}
