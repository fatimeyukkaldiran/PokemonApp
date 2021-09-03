package com.example.controller;

import com.example.domain.Ability;
import com.example.domain.Pokemon;
import com.example.domain.PokemonInfo;
import com.example.service.WorkUtils;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ResponseEntity<List<Pokemon>> getAll(){
        return new ResponseEntity<>(WorkUtils.pokemonStore,HttpStatus.OK);
    }

    @GetMapping("/images")
    public ResponseEntity<List<String>> getAllImage(){
        return  new ResponseEntity<>(WorkUtils.pokemonImgStore,HttpStatus.OK);
    }

    @GetMapping("/ability")
    public ResponseEntity<List<List<Ability>>> getAllAbility(){
        return  new ResponseEntity<>(WorkUtils.pokemonAbilityStore,HttpStatus.OK);
    }

    @GetMapping("/pokemonInfo")
    public ResponseEntity<?> getAllPokemonInfo(){
        if(WorkUtils.pokemonInfoList.size() == 0){
            return new ResponseEntity<>("Please wait...", HttpStatus.OK);
        }
        return new ResponseEntity<>(WorkUtils.getPokemonList(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokemonInfo> getPokemonInfo(@PathVariable int id){
        return new ResponseEntity<>(WorkUtils.getPokemon(id),HttpStatus.OK);
    }

}
