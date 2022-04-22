package com.ensa.gi4.dao;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ensa.gi4.modele.Materiel;


@Component
public class MaterielDAOImpl implements MaterielDAO{
	@Autowired
	 MaterielListe mylist;
	 
	 private MaterielDAOImpl materielDAOImp = null;
	 
	    public MaterielDAOImpl(MaterielListe mylist) {
	     this.mylist = mylist;
	    }


	@Override
	public void lister() {
		System.out.println("**************************Liste des materiels***********************");
        if(mylist.getList().isEmpty())
            System.out.println("La liste est vide");
        else{
            for (int i = 0; i < mylist.getList().size(); i++) {
                System.out.println(mylist.getList().get(i).getId() + " : " + mylist.getList().get(i).getName());
            }
        }
        System.out.println("===================================================================");
    }
		
		
	
	@Override
	public void ajouter(Materiel materiel) {
		
		
		   ArrayList<Materiel> list = mylist.getList();

           for (int i = 0; i <list.size() ; i++){
           if(list.get(i).getId() == materiel.getId()){
               System.out.println("Id deja existant");
   
               Scanner scanner = new Scanner(System.in);
               int newId = scanner.nextInt();
               materiel.setId(newId);
               break;
           }
	}
           
           list.add(materiel);
           System.out.println("Materiel est ajouté");
	}

	@Override
	public void supprimer(int id) {
		
		for (int i = 0; i < mylist.getList().size(); i++) {
            if (mylist.getList().get(i).getId() == id) {
                mylist.getList().remove(i);
            }
        }
	}

	@Override
	public void modifier(int id, String newname) {
		 for (int i = 0; i <mylist.getList().size(); i++) {
	            if (mylist.getList().get(i).getId() == id) {
	                mylist.getList().get(i).setName(newname);
	            }
	        }
		
		
	}

	@Override
	public void rechercher(String name) {
		 boolean resultat = false;
	        for (int i = 0; i < mylist.getList().size(); i++) {
	            if(mylist.getList().get(i).getName().equals(name)){
	            	resultat = true;
	            }

	        }
	        if(resultat){
	            System.out.println(name+" est sur la liste");
	        }
	        else{
	            System.out.println(name+" n'existe pas");
	        }
	
		
	}

}
