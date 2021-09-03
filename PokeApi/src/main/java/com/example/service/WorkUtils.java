package com.example.service;

import com.example.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkUtils {
    public static final int limit= 20;

    private static RestTemplate restTemplate;

    public static List<Pokemon> pokemonStore = new ArrayList<>();

    public static List<String> pokemonImgStore = new ArrayList<>();

    public static List<List<Ability>> pokemonAbilityStore = new ArrayList<>();

    public static List<PokemonInfo> pokemonInfoList = new ArrayList<>();

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * That method gets all pokemon.
     */
    public static void getAllPokemon(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "poke api");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        try{
            pokemonStore = restTemplate.exchange("https://pokeapi.co/api/v2/pokemon?limit=" + limit, HttpMethod.GET,entity, PokemonList.class).getBody().getResults();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * That method gets image by id for pokemon
     */
    public static void getPokemonImage(){
        for (int i = 1; i <= limit; i++){
            HttpHeaders headers = new HttpHeaders();
            headers.set("User-Agent", "poke api");
            HttpEntity<String> entity = new HttpEntity<>(headers);
            try{
                String k = restTemplate.exchange("https://pokeapi.co/api/v2/pokemon/" + i, HttpMethod.GET, entity, Sprites.class).getBody().getImageUrl().getUrl();
                pokemonImgStore.add(i - 1,k);
            }catch (Exception e){

            }
        }

    }

    /**
     * That method gets abilities list by id for pokemon
     */
    public static void getPokemonAbility(){
        for(int i = 1; i <= limit; i++){
            HttpHeaders headers = new HttpHeaders();
            headers.set("User-Agent", "poke api");
            HttpEntity<String> entity = new HttpEntity<>(headers);
            try{
                List<Ability> myList = restTemplate.exchange("https://pokeapi.co/api/v2/pokemon/" + i, HttpMethod.GET, entity, AbilityList.class).getBody().getAbilities();
                pokemonAbilityStore.add(i - 1,myList);
            }catch (Exception e){

            }
        }

        setPokemonInfo();
    }

    /**
     * This method adds the incoming data to the pokemonInfoList
     */
    public static void setPokemonInfo(){
        if(pokemonAbilityStore.size() == limit){
            for (int i = 0; i < limit; i++){
                pokemonInfoList.add(new PokemonInfo(i,pokemonStore.get(i).getName(), pokemonImgStore.get(i),pokemonAbilityStore.get(i)));
            }
        }
    }


    public static void getStartData(){
        getAllPokemon();
        getPokemonImage();
        getPokemonAbility();
    }

    public static List<PokemonInfo> getPokemonList(){
        if(pokemonAbilityStore.size() == limit)
            return pokemonInfoList;

        return  null;
    }

    public static PokemonInfo getPokemon(int id){
        return pokemonInfoList.get(id - 1);
    }
}
