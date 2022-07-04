package com.project.projectwebapp.service;

import java.util.Optional;

import com.project.projectwebapp.model.Projekt;
import com.project.projectwebapp.model.Zadanie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ZadanieService {
    Optional<Zadanie> getZadanie(Integer zadanieId);
    Zadanie setZadanie(Zadanie zadanie, Integer projektId);
    void deleteZadanie(Integer zadanieId);
    Page<Zadanie> getZadania(Pageable pageable);
}
