package com.example.CompanyManager.Controllers;

import com.example.CompanyManager.entities.AziendaEntity;
import com.example.CompanyManager.services.AziendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/azienda")
public class AziendaController {

    @Autowired
    private AziendaService aziendaService;

    @GetMapping("/getAzienda")
    public ResponseEntity<AziendaEntity> getAzienda() {
        AziendaEntity azienda = aziendaService.getAzienda();
        return new ResponseEntity<>(azienda, HttpStatus.OK);
    }
}

