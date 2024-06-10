package com.example.CompanyManager.repositories;

import com.example.CompanyManager.entities.MansioneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MansioneRepository extends JpaRepository<MansioneEntity, Long> {
}
