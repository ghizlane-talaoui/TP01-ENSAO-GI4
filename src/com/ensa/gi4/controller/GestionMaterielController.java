package com.ensa.gi4.controller;

import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class GestionMaterielController {
	 @Autowired
    private GestionMaterielService gestionMaterielService;

    public void listerMateriel() {
        gestionMaterielService.listerMateriel();
    }
    public void ajouterMateriel(Materiel materiel) {
    	gestionMaterielService.ajouterNouveauMateriel(materiel);
    }
    public void supprimerMateriel(int id) {
    	gestionMaterielService.supprimerMateriel(id);
		
	}
    public void modifierMateriel(int id , String name) {
    	gestionMaterielService.modifierMateriel(id, name);
		
	}
    public void rechercherMateriel(String name) {
    	
    	gestionMaterielService.rechercheMateriel(name);
    }

    public void afficherMenu() {
        System.out.println("1- pour lister le matÃ©riel, entrer 1");
        System.out.println("2- pour ajouter un nouveau matÃ©riel, entrer 2");
        System.out.println("3- pour supprimer un  matÃ©riel, entrer 3");
        System.out.println("4- pour modifier un  matÃ©riel, entrer 4");
        System.out.println("5- pour recherchee un  matÃ©riel, entrer 5");
        System.out.println("0- pour sortir de l'application, entrer 0");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if ("0".equals(next)) {
            sortirDeLApplication();
        } else if ("1".equals(next)) {
            listerMateriel();
        } else if ("2".equals(next)) {
        	
        	System.out.println("Tapez 1 pour Livre et 2 pour Chaise: ");
            Scanner scannerA = new Scanner(System.in);
            String num = scannerA.next();
            switch (num) {
                case "1" -> {
                    Livre livre = new Livre();
                    System.out.println("Entrez le nom de votre  livre:");
                    Scanner sc1 = new Scanner(System.in);
                    String nameLivre = sc1.nextLine();
                    livre.setName(nameLivre);
                    System.out.println("Entrez son id :");
                    Scanner sc3 = new Scanner(System.in);
                    int idLivre = sc3.nextInt();
                    livre.setId(idLivre);
                    ajouterMateriel(livre);
                }
                case "2" -> {
                    Chaise chaise = new Chaise();
                    System.out.println("Enter le nom de votre chaise:");
                    Scanner sc2 = new Scanner(System.in);
                    String nameChaise = sc2.next();
                    chaise.setName(nameChaise);
                    System.out.println("Entrez son id :");
                    Scanner sc4 = new Scanner(System.in);
                    int idChaise = sc4.nextInt();
                    chaise.setId(idChaise);
                    ajouterMateriel(chaise);
                    System.out.println("Chaise bien ajoutée!");
                }
            }
        }else if("3".equals(next)){
        	 System.out.println("Entrez l'id du materiel à  supprimer:");
             Scanner sc = new Scanner(System.in);
             int idsupp = sc.nextInt();
             supprimerMateriel(idsupp);
             System.out.println("Materiel est Supprimé!");
        	
        }else if ("4".equals(next)) {
        	System.out.println("Entrez l'id du materiel à  modifier: ");
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            System.out.println("Entrez le nouveau nom souhaité: ");
            Scanner newscanner = new Scanner(System.in);
            String newname = newscanner.next();
            modifierMateriel(i,newname);
            System.out.println("Le nom est modifié");
        	
        }else if("5".equals(next)) {
        	System.out.println("Entrez le nom du materiel à  recherché: ");
            Scanner sc = new Scanner(System.in);
            String name = sc.next();
            rechercherMateriel(name);
        }
          
         else {
            System.out.println("choix invalide");
        }
    }

    private void sortirDeLApplication() {
        System.exit(0);
    }
    @Autowired
    public void setGestionMaterielService(GestionMaterielService gestionMaterielService) {
        // injection par accesseur
        this.gestionMaterielService = gestionMaterielService;
    }
}
