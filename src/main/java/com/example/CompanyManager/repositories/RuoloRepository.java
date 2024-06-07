package com.example.CompanyManager.repositories;

import com.example.CompanyManager.entities.RuoloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuoloRepository extends JpaRepository<RuoloEntity, Long> {
}
