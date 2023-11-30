package com.gestionfoyer.Services;

import com.gestionfoyer.Entites.Etudiant;
import com.gestionfoyer.Repositories.EtudiantRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantService implements IEtudiantService{

    @Autowired
    EtudiantRepository etudiantRepository;
    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }


    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant getEtudiantById(long id) {
        return etudiantRepository.findById(id).get();
    }

    @Override
    public void removeEtudiant(long id) {
        etudiantRepository.deleteById(id);
    }
}
