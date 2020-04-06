package Algo;

import Autre.CompareDegree;

import Type.*;
import java.util.*;

public class WelshPowell extends Graphe {
	private int CouleurMax;
	
    public WelshPowell(Graphe graphe){
        List<Sommet> listSommets;
        
        listSommets = graphe.getSommetsClone();
        Collections.sort(listSommets, new CompareDegree());
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
