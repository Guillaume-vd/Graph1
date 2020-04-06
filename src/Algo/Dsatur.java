package Algo;

import java.util.Collections;
import java.util.List;

import Autre.CompareDegree;
import Autre.CompareNbVoisinColorDegree;
import Type.*;

public class Dsatur {
	private int CouleurMax;
	
	public Dsatur(Graphe graphe){
        List<Sommet> listSommets;
        listSommets = graphe.getSommets();
        Collections.sort(listSommets, new CompareDegree());
        int couleurmax = 0;
        //Sommet sommet = listSommets.get(0);
        //sommet.setColor(0);


        //On parcours tous les sommets dans l'ordre.
        while (!listSommets.isEmpty()) {
            Sommet s = listSommets.get(0);
            //On recherche la couleur possible
            s.setColor();
            if(s.getColor() > couleurmax) {
            	couleurmax = s.getColor();
            }
            listSommets.remove(s);
            Collections.sort(listSommets, new CompareNbVoisinColorDegree());
        }
        this.CouleurMax = couleurmax;
    }

    public int getCouleurMax(){
        return this.CouleurMax;
    }
}
