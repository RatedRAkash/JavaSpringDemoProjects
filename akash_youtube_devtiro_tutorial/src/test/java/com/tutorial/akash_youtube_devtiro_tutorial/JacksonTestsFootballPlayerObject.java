package com.tutorial.akash_youtube_devtiro_tutorial;

import com.tutorial.akash_youtube_devtiro_tutorial.domain.entity.FootballPlayer;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

public class JacksonTestsFootballPlayerObject {

    @Test
    public void testThatObjectMapperCanCreateJsonFromJavaObject() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        FootballPlayer player =
                FootballPlayer.builder()
                        .id(1L)
                        .name("Sergio Ramos")
                        .age(22)
                        .jerseyNumber(4) //json ee convert hoye "jersey_no" hoye jabe
                        .build();

        String result = objectMapper.writeValueAsString(player);
        assertThat(result)
                .isEqualTo(
                        "{\"id\":1,\"name\":\"Sergio Ramos\",\"age\":22,\"jersey_no\":4}");
    }
}
