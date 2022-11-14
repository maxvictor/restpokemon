package com.maxvictor.restpokemon.service;

import com.maxvictor.restpokemon.ApplicationConfigTest;
import com.maxvictor.restpokemon.model.Pokemon;
import com.maxvictor.restpokemon.repository.PokemonRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

@DisplayName("PokemonServiceTest")
public class PokemonServiceTest extends ApplicationConfigTest {

    @MockBean
    private PokemonRepository repository;

    @Autowired
    private PokemonService pokemonService;

    @Test
    @DisplayName("should remove pokemon")
    public void shouldRemovePokemon(){
        int pokemonId = 1;

        Pokemon pokemonMock = Mockito.mock(Pokemon.class);
        Mockito.when(pokemonMock.getId()).thenReturn(1);

        Pokemon pokemon = createPokemon();
        Mockito.when(repository.findById(ArgumentMatchers.eq(pokemonId))).thenReturn(pokemon);

        pokemonService.deletePokemon(pokemonId);
        Mockito.verify(repository, Mockito.times(1)).delete(ArgumentMatchers.any(Integer.class));
    }

    private Pokemon createPokemon(){
        Pokemon pokemon = Mockito.mock(Pokemon.class);
        Mockito.when(pokemon.getId()).thenReturn(1);
        return pokemon;
    }

}
