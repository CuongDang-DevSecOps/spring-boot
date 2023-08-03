package com.example.springboot.mappers;

import com.example.springboot.clients.JokeClient;
import com.example.springboot.dtos.JokeDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JokeMapper {

    JokeDTO toJoke(JokeClient.JokeResponse jokeResponse);
}
