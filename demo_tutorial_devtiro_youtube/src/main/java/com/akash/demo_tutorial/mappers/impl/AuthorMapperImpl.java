package com.akash.demo_tutorial.mappers.impl;

import com.akash.demo_tutorial.domain.dto.AuthorDto;
import com.akash.demo_tutorial.domain.entities.AuthorEntity;
import com.akash.demo_tutorial.mappers.CustomObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapperImpl implements CustomObjectMapper<AuthorEntity, AuthorDto> {

//    AutoWired hobe ---> "MapperConfig" class ee @Bean hisave Declare kora ase "ModelMapper" ke
    private ModelMapper modelMapper;

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
