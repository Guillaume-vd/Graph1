package Algo;

import java.util.Collections;
import java.util.List;

import Autre.CompareDegreeDecroissant;
import Autre.CompareNbVoisinColorDegree;
import Type.*;

public class Dsatur {
	private int CouleurMax;
	
	public Dsatur(Graphe graphe){
        List<Sommet> listSommets = graphe.getSommetsClone();
        Collections.sort(listSommets, new CompareDegreeDecroissant());
        int couleurmax = 0;
        //On parcours tous les sommets dans l'ordre.
        while (!listSommets.isEmpty()) {
            //On recherche la couleur possible
            if(listSommets.remove(0).setColor() > couleurmax) {
            	couleurmax ++;
            }
            for(int i = 0; i < listSommets.size(); i++) {
            	listSommets.get(i).setDifferentColor();
            }
            Collections.sort(listSommets, new CompareNbVoisinColorDegree());
        }
        this.CouleurMax = couleurmax;
    }

    public int getCouleurMax(){
        return this.CouleurMax;
    }
}
