package com.example.springboot.controllers;

import com.example.springboot.dtos.JokeDTO;
import com.example.springboot.services.JokeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/jokes")
@RequiredArgsConstructor
public class JokeController {

    private final JokeService jokeService;

    @GetMapping
    public JokeDTO fetchJoke() {
        return jokeService.fetchJoke();
    }
}
