package com.athiththan.soap.devservice.repository;

import java.util.Optional;

import com.athiththan.soap.devservice.model.Developer;

import org.springframework.data.jpa.repository.JpaRepository;

// @Component
public interface DeveloperRepository extends JpaRepository<Developer, String> {

    Optional<Developer> findByUsername(String username);
}
