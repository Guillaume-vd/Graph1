package Algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Autre.CompareDegree;
import Autre.CompareNbVoisinColorDegree;
import Type.*;

public class Dsatur {
	private int CouleurMax;
	
	public Dsatur(Graphe graphe){
		int ActualColor = 0;
        List<Sommet> listSommets;
        List<Sommet> listVosin;
        ArrayList<Integer> CouleurOk = new ArrayList<>();
        listSommets = graphe.getSommets();
        Collections.sort(listSommets, new CompareDegree());
        int couleurmax = 0;
        int nbSv;
        boolean couleurtrouver;
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
