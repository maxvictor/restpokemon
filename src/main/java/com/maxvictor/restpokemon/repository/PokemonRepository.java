package com.maxvictor.restpokemon.repository;

import com.maxvictor.restpokemon.model.Pokemon;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PokemonRepository {
    private List<Pokemon> list = new ArrayList<Pokemon>();

    public List<Pokemon> getAllPokemons(){
        return list;
    }

    public Pokemon findById(int id){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (id)) {
                return list.get(i);
            }
        }
        return null;
    }

    public List<Pokemon> search(String name) {
        return list.stream().filter(x -> x.getName().startsWith(name)).collect(Collectors.toList());
    }

    public Pokemon save(Pokemon p) {
        Pokemon pokemon = new Pokemon();
        pokemon.setId(p.getId());
        pokemon.setHeight(p.getHeight());
        pokemon.setWeight(p.getWeight());
        pokemon.setName(p.getName());
        list.add(pokemon);
        return pokemon;
    }

    public String delete(Integer id) {
        list.removeIf(x -> x.getId() == (id));
        return null;
    }

    public Pokemon update(Pokemon pokemon) {
        int idx = 0;
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (pokemon.getId())) {
                id = pokemon.getId();
                idx = i;
                break;
            }
        }
        Pokemon pokemon1 = new Pokemon();
        pokemon.setId(pokemon.getId());
        pokemon.setHeight(pokemon.getHeight());
        pokemon.setWeight(pokemon.getWeight());
        pokemon.setName(pokemon.getName());
        list.add(pokemon);

        list.set(idx, pokemon);
        return pokemon1;
    }

}
