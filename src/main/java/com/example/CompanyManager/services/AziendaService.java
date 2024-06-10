package com.example.CompanyManager.services;

import com.example.CompanyManager.dtos.AziendaDto;
import com.example.CompanyManager.entities.*;
import com.example.CompanyManager.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AziendaService {

    @Autowired
    private AziendaRepository aziendaRepository;

    @Autowired
    private ComuneRepository comuneRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SedeRepository sedeRepository;

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private RuoloRepository ruoloRepository;

    @Autowired
    private MansioneRepository mansioneRepository;

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

    @Transactional
    public AziendaEntity getAzienda() {

        AziendaEntity azienda = new AziendaEntity();
        azienda.setDenominazione("TechnoPulse");
        azienda.setResidenza("Via Firenze 66, Roma, Italia");
        azienda.setPIva("IT12345678901");
        azienda.setSettore("Tecnologia");

        ComuneEntity comune = new ComuneEntity();
        comune.setDenominazione("Milano");
        comune.setSiglaProv("MI");
        comune.setProvincia("Milano");
        comune.setSiglaReg("LOM");
        comune.setRegione("Lombardia");
        comune.setCodCatastale("F205");

        comuneRepository.save(comune);

        List<UserEntity> users = new ArrayList<>();
        UserEntity user1 = new UserEntity();
        user1.setNome("Mario");
        user1.setCognome("Rossi");
        user1.setUsername("mario.rossi");
        user1.setPassword("password");
        user1.setAzienda(azienda);
        users.add(user1);
        azienda.setUsers(users);

        RuoloEntity ruoloSenior = new RuoloEntity();
        ruoloSenior.setDescrizione("Senior");
        ruoloRepository.save(ruoloSenior);

        RuoloEntity ruoloJunior = new RuoloEntity();
        ruoloJunior.setDescrizione("Junior");
        ruoloRepository.save(ruoloJunior);

        RuoloEntity ruoloMiddle = new RuoloEntity();
        ruoloMiddle.setDescrizione("Middle");
        ruoloRepository.save(ruoloMiddle);

        MansioneEntity mansioneSviluppatore = new MansioneEntity();
        mansioneSviluppatore.setDenominazione("Sviluppatore");
        mansioneRepository.save(mansioneSviluppatore);

        MansioneEntity mansioneAnalista = new MansioneEntity();
        mansioneAnalista.setDenominazione("Analista");
        mansioneRepository.save(mansioneAnalista);

        MansioneEntity mansioneManager = new MansioneEntity();
        mansioneManager.setDenominazione("Manager");
        mansioneRepository.save(mansioneManager);

        List<DipendenteEntity> dipendenti = new ArrayList<>();
        DipendenteEntity dipendente1 = new DipendenteEntity();
        dipendente1.setNome("Francesco");
        dipendente1.setCognome("Bianchi");
        dipendente1.setDataNascita(createDate(1980, 1, 15));
        dipendente1.setAzienda(azienda);
        dipendente1.setRuolo(ruoloSenior);
        dipendente1.setMansione(mansioneSviluppatore);
        dipendenti.add(dipendente1);

        DipendenteEntity dipendente2 = new DipendenteEntity();
        dipendente2.setNome("Luigi");
        dipendente2.setCognome("Verdi");
        dipendente2.setDataNascita(createDate(1985, 5, 20));
        dipendente2.setAzienda(azienda);
        dipendente2.setRuolo(ruoloJunior);
        dipendente2.setMansione(mansioneAnalista);
        dipendenti.add(dipendente2);

        DipendenteEntity dipendente3 = new DipendenteEntity();
        dipendente3.setNome("Anna");
        dipendente3.setCognome("Neri");
        dipendente3.setDataNascita(createDate(1990, 9, 25));
        dipendente3.setAzienda(azienda);
        dipendente3.setRuolo(ruoloMiddle);
        dipendente3.setMansione(mansioneManager);
        dipendenti.add(dipendente3);

        azienda.setDipendenti(dipendenti);

        aziendaRepository.save(azienda);

        List<SedeEntity> sedi = new ArrayList<>();
        SedeEntity sede1 = new SedeEntity();
        sede1.setDenominazione("Sede Principale");
        sede1.setIndirizzo("Via Roma 10, Milano, Italia");
        sede1.setAzienda(azienda);
        sede1.setComune(comune);
        sedi.add(sede1);

        SedeEntity sede2 = new SedeEntity();
        sede2.setDenominazione("Sede Secondaria");
        sede2.setIndirizzo("Via Napoli 20, Roma, Italia");
        sede2.setAzienda(azienda);
        sede2.setComune(comune);
        sedi.add(sede2);

        azienda.setSedi(sedi);

        sedeRepository.saveAll(sedi);

        dipendente1.setSedi(new ArrayList<>(List.of(sede1)));
        dipendente2.setSedi(new ArrayList<>(List.of(sede2)));
        dipendente3.setSedi(new ArrayList<>(List.of(sede2)));

        sede1.setDipendenti(new ArrayList<>(List.of(dipendente1)));
        sede2.setDipendenti(new ArrayList<>(List.of(dipendente2, dipendente3)));

        dipendenteRepository.saveAll(dipendenti);

        userRepository.saveAll(users);

        return azienda;
    }
}
