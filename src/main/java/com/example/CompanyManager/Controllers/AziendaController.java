package com.example.CompanyManager.Controllers;

import com.example.CompanyManager.Components.AziendaComponent;
import com.example.CompanyManager.dtos.AziendaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/azienda")
@CrossOrigin("http://localhost:4200")
public class AziendaController {

    @Autowired
    private AziendaComponent aziendaComponent;

    @GetMapping("/getAzienda")
    public ResponseEntity<?> getAzienda() {
        AziendaDto azienda = aziendaComponent.getInformation();
        return new ResponseEntity<>(azienda, HttpStatus.OK);
    }
}

