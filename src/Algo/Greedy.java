package Algo;

import Type.Graphe;
import Type.Sommet;

import java.util.Collections;
import java.util.List;

import Autre.CompareDegree;

public class Greedy {
	private int CouleurMax;

    public Greedy(Graphe graphe){
    	List<Sommet> listSommets = graphe.getSommetsClone();
        Collections.sort(listSommets, new CompareDegree());
        int couleurmax = 0;
        //On parcours tous les sommets dans l'ordre.
        while (!listSommets.isEmpty()) {
            //On recherche la couleur possible
            if(listSommets.remove(0).setColor() > couleurmax) {
            	couleurmax ++;
            }
        }
        this.CouleurMax = couleurmax;
    }
    
    public int getCouleurMax(){
        return this.CouleurMax;
    }
}
