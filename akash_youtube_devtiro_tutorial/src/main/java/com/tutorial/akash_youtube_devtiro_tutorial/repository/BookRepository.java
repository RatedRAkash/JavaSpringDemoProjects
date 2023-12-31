package com.tutorial.akash_youtube_devtiro_tutorial.repository;

import com.tutorial.akash_youtube_devtiro_tutorial.domain.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {

}
