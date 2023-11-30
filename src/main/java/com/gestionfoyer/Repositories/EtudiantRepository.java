package com.gestionfoyer.Repositories;

import com.gestionfoyer.Entites.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    Etudiant findByCin(Long cin);
}

