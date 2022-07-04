package com.project.projectwebapp.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Zadanie {

    private Integer zadanieId;

    private String nazwa;

    private Integer kolejnosc;

    private String opis;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataCzasDodania;

    private Projekt projekt;

    public Zadanie() {
    }

    public Zadanie(Integer zadanieId, String nazwa, Integer kolejnosc, String opis, LocalDateTime dataCzasDodania,
                   Projekt projekt) {
        super();
        this.zadanieId = zadanieId;
        this.nazwa = nazwa;
        this.kolejnosc = kolejnosc;
        this.opis = opis;
        this.dataCzasDodania = dataCzasDodania;
        this.projekt = projekt;
    }

    public Zadanie(Projekt projekt, String nazwa, Integer kolejnosc, String opis) {
        this.projekt = projekt;
        this.nazwa = nazwa;
        this.kolejnosc = kolejnosc;
        this.opis = opis;
    }

    public Integer getZadanieId() {
        return zadanieId;
    }

    public void setZadanieid(Integer zadanieId) {
        this.zadanieId = zadanieId;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Integer getKolejnosc() {
        return kolejnosc;
    }

    public void setKolejnosc(Integer kolejnosc) {
        this.kolejnosc = kolejnosc;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public LocalDateTime getDataCzasDodania() {
        return dataCzasDodania;
    }

    public void setDataCzasDodania(LocalDateTime dataCzasDodania) {
        this.dataCzasDodania = dataCzasDodania;
    }

    public Projekt getProjekt() {
        return projekt;
    }

    public void setProjekt(Projekt projekt) {
        this.projekt = projekt;
    }
}
