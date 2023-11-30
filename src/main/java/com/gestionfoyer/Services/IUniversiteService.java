package com.gestionfoyer.Services;

import com.gestionfoyer.Entites.Universite;

import java.util.List;

public interface IUniversiteService {


    List<Universite> getAllUniversities();
    Universite addUniversite (Universite universite);
    Universite updateUniversite (Universite universite);
    Universite getUniversiteById (long id);

    void deleteUniversiteById (long id);

    public Universite affecterFoyerAUniversite (long id, String
            nomUniversite) ;

    public Universite desaffecterFoyerAUniversite(long id);

}
