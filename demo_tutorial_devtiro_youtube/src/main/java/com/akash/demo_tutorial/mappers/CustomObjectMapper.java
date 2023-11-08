package com.akash.demo_tutorial.mappers;

public interface CustomObjectMapper<A,B> {

    B mapTo(A a);
    A mapFrom(B b);
}
