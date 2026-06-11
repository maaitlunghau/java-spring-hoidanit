package com.practice.__spring_security_practice.repositories;

import com.practice.__spring_security_practice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByName(String name);

    Optional<User> findByEmail(String email);

    Optional<User> findByNameAndEmail(String name, String email);

    boolean existsByEmail(String email);
}
