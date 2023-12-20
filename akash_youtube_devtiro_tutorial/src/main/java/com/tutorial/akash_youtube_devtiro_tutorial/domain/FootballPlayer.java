package com.tutorial.akash_youtube_devtiro_tutorial.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//TODO: this Model is for Theory Purpose of Testing Json to Jackson Conversion
// Jackson library Spring
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true) // eita mane JSON object ee EXTRA Unknow Field takle sheita Parse kore FootballPlayer Object korar somoy Ignore korbe
public class FootballPlayer {

    private Long id;

    private String name;

    private Integer age;

    @JsonProperty("jersey_no") //Json format ee jerseyNumber takbe "jersey_no" hisave
    private Integer jerseyNumber;
}
