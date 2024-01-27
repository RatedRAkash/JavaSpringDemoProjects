package com.tutorial.akash_youtube_devtiro_tutorial.mapper.impl;

import com.tutorial.akash_youtube_devtiro_tutorial.domain.dto.AuthorDto;
import com.tutorial.akash_youtube_devtiro_tutorial.domain.entity.AuthorEntity;
import com.tutorial.akash_youtube_devtiro_tutorial.mapper.CustomObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapperImpl implements CustomObjectMapper<AuthorEntity, AuthorDto> {

//    AutoWired hobe ---> "ModelMapperConfig" class ee @Bean hisave Declare kora ase "ModelMapper" ke
    private ModelMapper modelMapper;

    @Autowired
    public AuthorMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AuthorDto mapTo(AuthorEntity authorEntity) {
        return modelMapper.map(authorEntity, AuthorDto.class);
    }

    @Override
    public AuthorEntity mapFrom(AuthorDto authorDto) {
        return modelMapper.map(authorDto, AuthorEntity.class);
    }
}
