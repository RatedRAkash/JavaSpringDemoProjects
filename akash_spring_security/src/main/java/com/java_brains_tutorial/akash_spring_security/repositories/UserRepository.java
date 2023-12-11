package com.java_brains_tutorial.akash_spring_security.repositories;

import com.java_brains_tutorial.akash_spring_security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
}
