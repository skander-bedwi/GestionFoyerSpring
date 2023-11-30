package com.gestionfoyer.Repositories;

import com.gestionfoyer.Entites.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ReservationRepository extends JpaRepository<Reservation, String> {

    boolean existsByEtudiantsCinAndAnneeUniversitaireBetween(long cin, LocalDate startDate, LocalDate finDate);
}
