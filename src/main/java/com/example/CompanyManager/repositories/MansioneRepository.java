package com.example.CompanyManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MansioneRepository extends JpaRepository<MansioneRepository, Long> {
}
