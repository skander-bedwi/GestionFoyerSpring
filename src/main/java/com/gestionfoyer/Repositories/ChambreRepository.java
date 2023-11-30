package com.gestionfoyer.Repositories;

import com.gestionfoyer.Entites.Bloc;
import com.gestionfoyer.Entites.Chambre;
import com.gestionfoyer.Entites.Enums.TypeChambre;
import com.gestionfoyer.Entites.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {

     Chambre findByNumeroChambre(Long  numeroChambre);

     public List<Chambre> findChambreByBlocFoyerUniversiteNomUniversite(String bloc_foyer_universite_nomUniversite);

//     public List<Chambre> findChambreByBlocAndTypeChambreOrBloc(Bloc bloc, TypeChambre typeChambre, Bloc bloc2);

     //public List<Chambre> findChambreByBloc_IdBlocAndTypeChambre(long bloc_idBloc, TypeChambre typeChambre);

     @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc AND c.typeChambre = :typeChambre")
     List<Chambre> getChambresParBlocEtType(Long idBloc, TypeChambre typeChambre);

     Chambre findByReservationListContains(Reservation reservation);
}
