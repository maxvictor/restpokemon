package com.maxvictor.restpokemon.controller;

import com.maxvictor.restpokemon.model.Pokemon;
import com.maxvictor.restpokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("pokemons")
public class PokemonController {

    @Autowired
    private PokemonService service;

    @PostMapping
    public Pokemon addPokemon(@RequestBody Pokemon Pokemon) {
        return service.savePokemon(Pokemon);
    }

    @GetMapping
    public List<Pokemon> findAllPokemons() {
        return service.getPokemons();
    }

    @GetMapping("{id}")
    public Pokemon findPokemonById(@PathVariable int id) {
        return service.getPokemonById(id);
    }

    @PutMapping
    public Pokemon updatePokemon(@RequestBody Pokemon Pokemon) {
        return service.updatePokemon(Pokemon);
    }

    @DeleteMapping("{id}")
    public String deletePokemon(@PathVariable int id) {
        return service.deletePokemon(id);
    }

    @GetMapping("populate")
    private Object populate(){
        String uri = "https://pokeapi.co/api/v2/pokemon";
        RestTemplate restTemplate = new RestTemplate();

        Object result = restTemplate.getForObject(uri, Object.class);

        return result;
    }
}
