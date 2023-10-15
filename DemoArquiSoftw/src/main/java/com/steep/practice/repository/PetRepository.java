package com.steep.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.steep.practice.model.Pet;

public interface PetRepository extends JpaRepository<Pet, String> {

}
