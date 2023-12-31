package com.tutorial.akash_youtube_devtiro_tutorial.repository;

import com.tutorial.akash_youtube_devtiro_tutorial.domain.entity.AuthorEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {

    Iterable<AuthorEntity> ageLessThan(int age);

    @Query("SELECT a from AuthorEntity a where a.age > ?1") //eikane ?1 --> mane hocche 1st Parameter sheita ei QUESTION ee boshbe
    Iterable<AuthorEntity> findAuthorsWithAgeGreaterThan(int age);
}
