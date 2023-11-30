package com.gestionfoyer.Services;

import com.gestionfoyer.Entites.Foyer;
import com.gestionfoyer.Entites.Universite;
import com.gestionfoyer.Repositories.FoyerRepository;
import com.gestionfoyer.Repositories.UniversiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UniversiteService implements IUniversiteService{

    @Autowired
    UniversiteRepository universiteRepository;
    FoyerRepository foyerRepository;

    @Override
    public List<Universite> getAllUniversities() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite getUniversiteById(long id) {
        return universiteRepository.findById(id).get();
    }

    @Override
    public void deleteUniversiteById(long id) {
      universiteRepository.deleteById(id);
    }

    @Override
    public Universite affecterFoyerAUniversite(long id, String nomUniversite) {

        Foyer foyer = foyerRepository.findById(id).orElse(null);

        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);

        universite.setFoyer(foyer);

        return universiteRepository.save(universite);
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long id) {


        Universite universite = universiteRepository.findById(id).orElse(null);

        universite.setFoyer(null);

        return universiteRepository.save(universite);
    }
}
