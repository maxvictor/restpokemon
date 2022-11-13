# PokeAPI
A REST API consuming **PokeAPI** - [pokeapi.co](https://pokeapi.co)

## About
<p align="justify">This project implements HTTP communication to get data from PokeAPI and implements data management using static memory for dynamic storage.</p>


## Routes
| URL                       | Returns          | Features                                       |
|---------------------------|------------------|------------------------------------------------|
| GET **/pokemons**         | All pokemons     | Returns all pokemons and get data if its empty |
| GET **/pokemons/{id}**    | Specific pokemon | Return one pokemon with the given ID           |
| POST **/pokemons**        | Added pokemon    | Store new pokemon                              |
| PUT **/pokemons**         | Update pokemon   | Update pokemon data with given ID on body      |
| DELETE **/pokemons/{id}** | Delete pokemon   | Delete pokemon with the given                  |

## Technology

- [Spring](https://spring.io/)