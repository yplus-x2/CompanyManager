package com.example.CompanyManager.repositories;

import com.example.CompanyManager.entities.ComuneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComuneRepository extends JpaRepository<ComuneEntity, Long> {


}
