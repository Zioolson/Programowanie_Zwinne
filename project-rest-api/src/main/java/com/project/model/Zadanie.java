    package com.project.model;
    import java.time.LocalDateTime;
    import java.util.List;
    import javax.persistence.Column;
    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;
    import javax.persistence.JoinColumn;
    import javax.persistence.ManyToOne;
    import javax.persistence.OneToMany;
    import javax.persistence.Table;


    import org.hibernate.annotations.UpdateTimestamp;


    @Entity
    @Table(name="zadanie")
    public class Zadanie {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="zadanie_id")
        private Integer zadanieId;

        @Column(nullable = false, length = 50)
        private String nazwa;

        private Integer kolejnosc;

        @Column(nullable = true, length = 1000)
        private String opis;

        @UpdateTimestamp
        @Column(name = "dataczas_dodania", nullable = false, updatable = false)
        private LocalDateTime dataCzasDodania;

        @ManyToOne
        @JoinColumn(name = "projekt_id")
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
