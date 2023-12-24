package com.tutorial.akash_retrofit_client_spring_boot.FutureStudioTutorial.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.io.Serializable;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL) //eita mane kono Field jodi NULL takhe taile sheita ignore korbe... like Interceptor ee "club" pass nah korle, "club" null takbe, so tokon ignore korbe
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorResponseDto implements Serializable {

    //TODO: "AuthorDto" 3rd Party Api te jey Call dibi taar Response hisave Accept korbo...

    private Long id;

    private String name;

    private Integer age;

    @JsonIgnoreProperties
    private String club;

    public AuthorResponseDto() {

    }

    public AuthorResponseDto(Long id, String name, Integer age, String club) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.club = club;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }


    @Override
    public String toString() {
        return "AuthorResponseDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", club='" + club + '\'' +
                '}';
    }
}