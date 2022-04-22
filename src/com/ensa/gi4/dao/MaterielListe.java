package com.ensa.gi4.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;


@Component
public class MaterielListe {
	 public ArrayList<Materiel> list = new ArrayList<>();
	    public MaterielListe(){
	    list.add(new Livre(1,"Livre1"));
        list.add(new Chaise(2,"Chaise1"));
	    }


	    public ArrayList<Materiel> getList() {
	        return list;
	    }

	    public void setList(ArrayList<Materiel> list) {
	        this.list = list;
	    }

}
