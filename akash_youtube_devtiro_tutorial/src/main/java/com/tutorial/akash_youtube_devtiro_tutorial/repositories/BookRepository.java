package com.tutorial.akash_youtube_devtiro_tutorial.repositories;

import com.tutorial.akash_youtube_devtiro_tutorial.domain.entities.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {

}
