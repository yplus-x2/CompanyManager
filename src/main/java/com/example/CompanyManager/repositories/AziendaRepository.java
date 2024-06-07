package com.example.CompanyManager.repositories;

import com.example.CompanyManager.entities.AziendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AziendaRepository extends JpaRepository<AziendaEntity, Long> {


}
