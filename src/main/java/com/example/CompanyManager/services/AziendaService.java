package com.example.CompanyManager.services;

import com.example.CompanyManager.entities.AziendaEntity;
import com.example.CompanyManager.entities.DipendenteEntity;
import com.example.CompanyManager.entities.SedeEntity;
import com.example.CompanyManager.entities.UserEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AziendaService {

    private Date createDate(int year, int month, int day) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = String.format("%d-%02d-%02d", year, month, day);
        try {
            return sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public AziendaEntity getAzienda() {
        AziendaEntity azienda = new AziendaEntity();
        azienda.setId(1L);
        azienda.setDenominazione("TechnoPulse");
        azienda.setResidenza("Via Firenze 66, Roma, Italia");
        azienda.setPIva("IT12345678901");
        azienda.setSettore("Tecnologia");

        List<UserEntity> users = new ArrayList<>();
        UserEntity user1 = new UserEntity();
        user1.setId(1L);
        user1.setNome("Mario");
        user1.setCognome("Rossi");
        user1.setUsername("mario.rossi");
        user1.setPassword("password");
        user1.setAzienda(azienda);
        users.add(user1);
        azienda.setUsers(users);

        List<DipendenteEntity> dipendenti = new ArrayList<>();
        DipendenteEntity dipendente1 = new DipendenteEntity();
        dipendente1.setId(1L);
        dipendente1.setNome("Francesco");
        dipendente1.setCognome("Bianchi");
        dipendente1.setDataNascita(createDate(1980, 1, 15));
        dipendente1.setAzienda(azienda);
        dipendenti.add(dipendente1);

        DipendenteEntity dipendente2 = new DipendenteEntity();
        dipendente2.setId(2L);
        dipendente2.setNome("Luigi");
        dipendente2.setCognome("Verdi");
        dipendente2.setDataNascita(createDate(1985, 5, 20));
        dipendente2.setAzienda(azienda);
        dipendenti.add(dipendente2);

        DipendenteEntity dipendente3 = new DipendenteEntity();
        dipendente3.setId(3L);
        dipendente3.setNome("Anna");
        dipendente3.setCognome("Neri");
        dipendente3.setDataNascita(createDate(1990, 9, 25));
        dipendente3.setAzienda(azienda);
        dipendenti.add(dipendente3);

        azienda.setDipendenti(dipendenti);

        List<SedeEntity> sedi = new ArrayList<>();
        SedeEntity sede1 = new SedeEntity();
        sede1.setId(1L);
        sede1.setDenominazione("Sede Principale");
        sede1.setIndirizzo("Via Roma 10, Milano, Italia");
        sede1.setAzienda(azienda);
        sedi.add(sede1);

        SedeEntity sede2 = new SedeEntity();
        sede2.setId(2L);
        sede2.setDenominazione("Sede Secondaria");
        sede2.setIndirizzo("Via Napoli 20, Roma, Italia");
        sede2.setAzienda(azienda);
        sedi.add(sede2);

        azienda.setSedi(sedi);

        dipendente1.setSedi(List.of(sede1));
        dipendente2.setSedi(List.of(sede2));
        dipendente3.setSedi(List.of(sede2));

        sede1.setDipendenti(List.of(dipendente1));
        sede2.setDipendenti(List.of(dipendente2, dipendente3));

        return azienda;
    }
}
