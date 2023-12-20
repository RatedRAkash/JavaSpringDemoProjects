package com.tutorial.akash_youtube_devtiro_tutorial.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDto {

    //TODO: Controller Only "AuthorDto" Response hisave Dibe & Request hisave Nibe...
    // Controller(Presentaion Layer) Should have No Idea about AuthorEntity... ei karon DTO(Data Transfer Object) use kora huise AuthorEntity theke AuthorDto te nite
    // Persistence Layer(Repository) & Service Layer should access AuthorEntity

    private Long id;

    private String name;

    private Integer age;
}