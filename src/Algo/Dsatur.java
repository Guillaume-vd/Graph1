package Algo;

import java.util.Collections;
import java.util.List;

import Autre.CompareDegree;
import Autre.CompareNbVoisinColorDegree;
import Type.*;

public class Dsatur {
	private int CouleurMax;
	
	public Dsatur(Graphe graphe){
        List<Sommet> listSommets = graphe.getSommetsClone();
        Collections.sort(listSommets, new CompareDegree());
        int couleurmax = 0;
        //On parcours tous les sommets dans l'ordre.
        while (!listSommets.isEmpty()) {
            //On recherche la couleur possible
            if(listSommets.remove(0).setColor() > couleurmax) {
            	couleurmax ++;
            }
            Collections.sort(listSommets, new CompareNbVoisinColorDegree());
        }
        this.CouleurMax = couleurmax;
    }

    public int getCouleurMax(){
        return this.CouleurMax;
    }
}
