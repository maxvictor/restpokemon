package com.maxvictor.restpokemon.service;

import com.maxvictor.restpokemon.model.Pokemon;
import com.maxvictor.restpokemon.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PokemonService {

    @Autowired
    private PokemonRepository repository;

    public Pokemon savePokemon(Pokemon pokemon){
        return repository.save(pokemon);
    }

    public List<Pokemon> getPokemons() {
        return repository.getAllPokemons();
    }

    public Pokemon getPokemonById(int id) {
        return repository.findById(id);
    }

    public String deletePokemon(int id) {
        repository.delete(id);
        return "Pokemon with id:" + id + " removed.";
    }

    public Pokemon updatePokemon(Pokemon pokemon) {
        return repository.update(pokemon);
    }

}
