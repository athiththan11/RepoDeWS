package com.athiththan.soap.devservice.repository;

import java.util.List;

import com.athiththan.soap.devservice.model.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoRepository extends JpaRepository<Repo, String> {

    List<Repo> findByUsername(String username);
}