package com.maxvictor.restpokemon.controller;

import com.maxvictor.restpokemon.model.Pokemon;
import com.maxvictor.restpokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    @Autowired
    private PokemonService service;

    @PostMapping
    public Pokemon addPokemon(@Valid @RequestBody Pokemon Pokemon) {
        return service.savePokemon(Pokemon);
    }

    @GetMapping
    public List<Pokemon> findAllPokemons() {
        if(service.getPokemons().isEmpty()){
            populate();
        }
        return service.getPokemons();
    }

    @GetMapping("/{id}")
    public Pokemon findPokemonById(@PathVariable int id) {
        return service.getPokemonById(id);
    }

    @PutMapping
    public Pokemon updatePokemon(@RequestBody Pokemon Pokemon) {
        return service.updatePokemon(Pokemon);
    }

    @DeleteMapping("/{id}")
    public String deletePokemon(@PathVariable int id) {
        return service.deletePokemon(id);
    }

    private String populate(){
        for(int i = 1; i <= 10; i++){
            String uri = "https://pokeapi.co/api/v2/pokemon/" + i;
            RestTemplate restTemplate = new RestTemplate();

            Pokemon result = restTemplate.getForObject(uri, Pokemon.class);

            service.savePokemon(result);
        }

        return "Static Memory Populated";
    }
}