package io.wakelesstuna.movie.controllers;

import io.wakelesstuna.movie.entites.response.Pokemon;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/v1/pokemon")
@RequiredArgsConstructor
@Log4j2
public class PokemonController {

    private final WebClient webClient;

    @GetMapping("{id}")
    public ResponseEntity<Pokemon> getPokemon(@PathVariable final String id) {
        Pokemon pokemon = webClient.get()
                .uri("https://pokeapi.co/api/v2/pokemon/%s".formatted(id))
                .retrieve()
                .bodyToMono(Pokemon.class)
                .block();
        return ResponseEntity.ok(pokemon);
    }
}
