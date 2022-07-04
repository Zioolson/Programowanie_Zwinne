package com.project.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.sun.istack.NotNull;

@Entity //Indeksujemy kolumny, które są najczęściej wykorzystywane do wyszukiwania studentów
@Table(name = "student",
        indexes = { @Index(name = "idx_nazwisko", columnList = "nazwisko", unique = false),
                @Index(name = "idx_nr_indeksu", columnList = "nr_indeksu", unique = true) })

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_id")
    private Integer studentId;


    @Column(nullable = false, length = 50)
    private String imie;

    @Column(nullable = false, length = 100)
    private String nazwisko;

    @NotNull
    @Column(name="nr_indeksu", nullable = false, length = 50)
    private String nrIndeksu;

    @Column(nullable = false, length = 50)
    private String email;

    @Column( nullable = false)
    private Boolean stacjonarny;

    @ManyToMany(mappedBy = "studenci")
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
