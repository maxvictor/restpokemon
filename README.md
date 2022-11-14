# PokeAPI
A REST API consuming **PokeAPI** - [pokeapi.co](https://pokeapi.co)

## About
<p align="justify">This project implements HTTP communication to get data from PokeAPI and implements data management using static memory for dynamic storage.</p>
<p>The API is running on default port 8080</p>


## Routes
|  Type  | URL                   | Returns          | Comment                                                          |
|:------:|-----------------------|------------------|------------------------------------------------------------------|
|  GET   | **/pokemons**         | All pokemons     | Returns all pokemons and get data from PokeAPI if local is empty |
|  GET   | **/pokemons/{id}**    | Specific pokemon | Return one pokemon with the given ID                             |
|  POST  | **/pokemons**         | Added pokemon    | Store new pokemon                                                |
|  PUT   | **/pokemons**         | Update pokemon   | Update pokemon data with given ID on body                        |
| DELETE | **/pokemons/{id}**    | Delete pokemon   | Delete pokemon with the given                                    |

## Payload
```
{
"id": 1,
"height": 1,
"weight": 1,
"name": "name"
}
```

| Param  | Type   |
|--------|--------|
| id     | int    |
| height | int    |
| weight | int    |
| name   | String |

## How to Run

First you need to clone the repository
```
git clone https://github.com/maxvictor/restpokemon.git
```
Then you can move into the new folder
```
cd restpokemon
```
Once you're there you need to build
```
mvn clean package
```
Then you can run it
```
java -jar target/restpokemon-0.0.1-SNAPSHOT.jar
```

## Technology

- [Spring](https://spring.io/)