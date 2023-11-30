package com.gestionfoyer.Services;

import com.gestionfoyer.Entites.Bloc;
import com.gestionfoyer.Entites.Foyer;
import com.gestionfoyer.Entites.Universite;
import com.gestionfoyer.Repositories.BlocRepository;
import com.gestionfoyer.Repositories.FoyerRepository;
import com.gestionfoyer.Repositories.UniversiteRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

@AllArgsConstructor
public class FoyerService implements IFoyerService{

   private final  FoyerRepository foyerRepository;
   private final   UniversiteRepository universiteRepository;
   private  final BlocRepository blocRepository;

    @Override
    public List<Foyer> geteAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer getFoyerById(long idFoyer) {
        return foyerRepository.findById(idFoyer).get();
    }

    @Override
    public void removeFoyer(long idFoyer) {

        foyerRepository.deleteById(idFoyer);

    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long id) {

        Universite universite = universiteRepository.findById(id).orElse(null);

        universite.setFoyer(foyer);

        for(Bloc bloc :foyer.getBlocs()){

            bloc.setFoyer(foyer);
            blocRepository.save(bloc);
        }

        return foyerRepository.save(foyer);


    }
}
