package com.tutorial.akash_youtube_devtiro_tutorial.mapper;

public interface CustomObjectMapper<A,B> {

    B mapTo(A a);
    A mapFrom(B b);
}
