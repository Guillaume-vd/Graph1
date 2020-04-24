package Algo;

import Autre.CompareDegree;
import Autre.CompareDegreeDecroissant;
import Type.*;
import java.util.*;

public class WelshPowell extends Graphe {
	private int CouleurMax;
	
    public WelshPowell(Graphe graphe, boolean croissant){
        List<Sommet> listSommets;
        
        listSommets = graphe.getSommetsClone();
        if(croissant) {
        	Collections.sort(listSommets, new CompareDegree());
        }
        else {
        	Collections.sort(listSommets, new CompareDegreeDecroissant());
        }
        int i;
        int couleur = 0;
        while(0 < listSommets.size()) {
        	couleur ++;
        	listSommets.get(0).setColor(couleur);
        	i = 0;
        	while(i < listSommets.size()) {
        		if(!listSommets.get(i).voisinColor(couleur)) {
        			listSommets.remove(i).setColor(couleur);
        		}
        		else {
        			i++;
        		}
        	}
        }
        
        this.CouleurMax = couleur;
    }
    
    public int getCouleurMax(){
        return this.CouleurMax;
    }

}
