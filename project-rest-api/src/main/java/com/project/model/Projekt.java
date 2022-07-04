package com.project.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name="projekt")
public class Projekt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="projekt_id")
    private Integer projektId;

    @NotBlank(message = "Pole nazwa nie może być puste!")
    @Size(min = 3, max = 50, message = "Nazwa musi zawierać od {min} do {max} znaków!")
    @Column(nullable = false, length = 50)
    private String nazwa;
    @Column(nullable = true, length = 1000)
    private String opis;

    @CreationTimestamp
    @Column(name = "dataczas_utworzenia", nullable = false, updatable = false)
    private LocalDateTime dataCzasUtworzenia;

    @Column(name = "dataOddania")
    private LocalDate dataOddania;

    @OneToMany(mappedBy = "projekt")
    @JsonIgnoreProperties({"projekt"})
    private List<Zadanie> zadania;

    @ManyToMany
    @JoinTable(name = "projekt_student",
            joinColumns = {@JoinColumn(name="projekt_id")},
            inverseJoinColumns = {@JoinColumn(name="student_id")})
    private Set<Student> studenci;

    public Projekt() {

    }

    public Projekt(Integer projektId, String nazwa, String opis, LocalDateTime dataCzasUtworzenia, LocalDate dataOddania) {
        super();
        this.projektId = projektId;
        this.nazwa = nazwa;
        this.opis = opis;
        this.dataCzasUtworzenia = dataCzasUtworzenia;
        this.dataOddania = dataOddania;
    }

    public Projekt(String nazwa, String opis, LocalDate dataOddania) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.dataOddania = dataOddania;
    }

    public Projekt(Integer projektId, String nazwa, String opis, LocalDateTime dataCzasUtworzenia, LocalDate dataOddania,
                   Set<Student> studenci) {
        super();
        this.projektId = projektId;
        this.nazwa = nazwa;
        this.opis = opis;
        this.dataCzasUtworzenia = dataCzasUtworzenia;
        this.dataOddania = dataOddania;
    }

    public Integer getProjektId() {
        return projektId;
    }


    public void setProjektId(Integer projektId) {
        this.projektId = projektId;
    }


    public String getNazwa() {
        return nazwa;
    }


    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }


    public String getOpis() {
        return opis;
    }


    public void setOpis(String opis) {
        this.opis = opis;
    }


    public LocalDateTime getDataCzasUtworzenia() {
        return dataCzasUtworzenia;
    }


    public void setDataCzasUtworzenia(LocalDateTime dataCzasUtworzenia) {
        this.dataCzasUtworzenia = dataCzasUtworzenia;
    }


    public LocalDate getDataOddania() {
        return dataOddania;
    }


    public void setDataOddania(LocalDate dataOddania) {
        this.dataOddania = dataOddania;
    }


    public Set<Student> getStudenci() {
        return studenci;
    }


    public void setStudenci(Set<Student> studenci) {
        this.studenci = studenci;
    }
}
