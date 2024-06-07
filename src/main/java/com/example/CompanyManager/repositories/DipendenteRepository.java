package com.example.CompanyManager.repositories;

import com.example.CompanyManager.entities.DipendenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DipendenteRepository extends JpaRepository<DipendenteEntity, Long> {

}
