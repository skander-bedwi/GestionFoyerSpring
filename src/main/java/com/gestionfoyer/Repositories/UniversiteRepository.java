package com.gestionfoyer.Repositories;

import com.gestionfoyer.Entites.Universite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversiteRepository extends JpaRepository<Universite, Long > {

    public Universite findByNomUniversite(String nomUniversite);
}
