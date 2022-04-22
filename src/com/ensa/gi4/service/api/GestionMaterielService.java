package com.ensa.gi4.service.api;

import com.ensa.gi4.modele.Materiel;

public interface GestionMaterielService {
    void init();
    void listerMateriel();
    void ajouterNouveauMateriel(Materiel materiel);
    void supprimerMateriel(int id );
    void modifierMateriel(int id ,String name);
    void rechercheMateriel(String name);
}
