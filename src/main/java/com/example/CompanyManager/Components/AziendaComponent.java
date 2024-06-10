package com.example.CompanyManager.Components;

import com.example.CompanyManager.dtos.AziendaDto;
import com.example.CompanyManager.entities.AziendaEntity;
import com.example.CompanyManager.services.AziendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AziendaComponent {

    @Autowired
    private AziendaService aziendaService;

    public AziendaDto getInformation(){
        AziendaDto azienda;
        AziendaEntity e = aziendaService.getAzienda();
        azienda = new AziendaDto(e.getId(), e.getDenominazione(),e.getResidenza());
        return azienda;
    }
}
