package com.gestionfoyer.Services;

import com.gestionfoyer.Entites.Foyer;

import java.util.List;

public interface IFoyerService {


    public List<Foyer> geteAllFoyers();
   public    Foyer addFoyer (Foyer foyer);
    public Foyer updateFoyer (Foyer foyer);
    public Foyer getFoyerById (long idFoyer);
    public void removeFoyer (long idFoyer);

    public Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long id);


}
