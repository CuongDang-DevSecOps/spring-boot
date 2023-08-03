package com.example.springboot.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "jokeClient", url = "https://joke.deno.dev/")
public interface JokeClient {

    @GetMapping
    JokeResponse fetchJoke();

    record JokeResponse(int id, String general, String setup, String punchline) {
    }
}
