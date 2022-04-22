package com.ensa.gi4.service.impl;


import com.ensa.gi4.dao.MaterielDAOImpl;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;

public class GestionMaterielServiceImpl implements GestionMaterielService {
	
	public MaterielDAOImpl materielDAOImp;
	
	public GestionMaterielServiceImpl(MaterielDAOImpl materielDAOImp) {
        this.materielDAOImp = materielDAOImp;
}
    @Override
    public void init() {
        System.out.println("inititialisation du service");
    }

    @Override
    public void listerMateriel() {
    	
    	materielDAOImp.lister();
        
    }

    @Override
    public void ajouterNouveauMateriel(Materiel materiel) {
    	
        materielDAOImp.ajouter(materiel);
    }
	@Override
	public void supprimerMateriel(int id) {
		materielDAOImp.supprimer(id);
		
	}
	@Override
	public void modifierMateriel(int id, String name) {
		materielDAOImp.modifier(id, name);
		
	}
	@Override
	public void rechercheMateriel(String name) {
		
		materielDAOImp.rechercher(name);
		
	}
}
