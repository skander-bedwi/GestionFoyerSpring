package com.gestionfoyer.Services;

import com.gestionfoyer.Entites.Etudiant;

import java.util.List;

public interface IEtudiantService {

    public List<Etudiant> getAllEtudiants();
    public Etudiant  addEtudiant (Etudiant etudiant);
    public Etudiant updateEtudiant (Etudiant etudiant);
    public Etudiant getEtudiantById(long  id);
    public  void removeEtudiant(long id);
}
