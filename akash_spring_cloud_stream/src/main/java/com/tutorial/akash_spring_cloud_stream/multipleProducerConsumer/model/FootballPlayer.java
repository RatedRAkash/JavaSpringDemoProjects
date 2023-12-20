package com.tutorial.akash_spring_cloud_stream.multipleProducerConsumer.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FootballPlayer {
    private Integer jersey_no;
}
