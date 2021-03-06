package com.project.projectwebapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {

    private Integer studentId;

    private String imie;

    private String nazwisko;

    private String nrIndeksu;

    private String email;

    private Boolean stacjonarny;

    private Set<Projekt> projekty;

    public Student() {

    }

    public Student(Integer studentId, String imie, String nazwisko, String nrIndeksu, String email,
                   Boolean stacjonarny) {
        super();
        this.studentId = studentId;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrIndeksu = nrIndeksu;
        this.email = email;
        this.stacjonarny = stacjonarny;
    }

    public Student(String imie, String nazwisko, String nrIndeksu, String email, Boolean stacjonarny) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrIndeksu = nrIndeksu;
        this.email = email;
        this.stacjonarny = stacjonarny;
    }

    public Student(Integer studentId, String imie, String nazwisko, String nrIndeksu, String email,
                   Boolean stacjonarny, Set<Projekt> projekty) {
        this.studentId = studentId;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrIndeksu = nrIndeksu;
        this.email = email;
        this.stacjonarny = stacjonarny;
        this.projekty = projekty;
    }



    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentid(Integer studentId) {
        this.studentId = studentId;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNrIndeksu() {
        return nrIndeksu;
    }

    public void setNrIndeksu(String nrIndeksu) {
        this.nrIndeksu = nrIndeksu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getStacjonarny() {
        return stacjonarny;
    }

    public void setStacjonarny(Boolean stacjonarny) {
        this.stacjonarny = stacjonarny;
    }
}
