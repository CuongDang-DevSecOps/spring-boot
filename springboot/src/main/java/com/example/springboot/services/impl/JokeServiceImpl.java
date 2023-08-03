package com.example.springboot.services.impl;

import com.example.springboot.clients.JokeClient;
import com.example.springboot.dtos.JokeDTO;
import com.example.springboot.mappers.JokeMapper;
import com.example.springboot.services.JokeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JokeServiceImpl implements JokeService {

    private final JokeClient jokeClient;
    private final JokeMapper jokeMapper;

    @Override
    public JokeDTO fetchJoke() {
        return jokeMapper.toJoke(jokeClient.fetchJoke());
    }
}
