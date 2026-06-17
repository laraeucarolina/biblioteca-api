package com.biblioteca.biblioteca_api.repository;

import com.biblioteca.biblioteca_api.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
