package Algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Autre.CompareDegree;
import Autre.CompareNbVoisinColor;
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
            listVosin = s.getVoisins();
            nbSv = listVosin.size();
            couleurtrouver = false;
            //On recherche la couleur possible
            while (!couleurtrouver) {
                //On reguarde la couleur de tous les voisins
                for (Sommet sv : listVosin) {
                    if (sv.getColor() != ActualColor) {
                        nbSv--;
                    }
                }
                //Si tous les voisins on la même couleur
                if (nbSv == 0) {
                    couleurtrouver = true;
                    s.setColor(ActualColor);
                    //On met a jour le nombre de couleur
                    if (couleurmax < ActualColor) {
                        couleurmax = ActualColor;
                    }
                    for (Sommet sc: listVosin) {
                        sc.incrementerColorVoisin();
                    }
                    ActualColor = 0;
                }
                // Sinon on passe à la couleur suivante
                else {
                    nbSv = listVosin.size();
                    ActualColor++;
                }
            }
            listSommets.remove(s);
            Collections.sort(listSommets, new CompareNbVoisinColor());
        }
        this.CouleurMax = couleurmax;
    }

    public int getCouleurMax(){
        return this.CouleurMax;
    }
}
