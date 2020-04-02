package Algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Autre.CompareDegree;
import Type.*;

public class Dsatur {
	private int CouleurMax;
	
	public Dsatur(Graphe graphe){
		int ActualColor = 0;
        List<Sommet> listSommets = new ArrayList<Sommet>();
        List<Sommet> listVosin = new ArrayList<Sommet>();
        ArrayList<Integer> CouleurOk = new ArrayList<>();
        listSommets = graphe.getSommets();
        Collections.sort(listSommets, new CompareDegree());
        int couleurmax = 0;
        int nbSv;
        boolean couleurtrouver;
        
        for (Sommet s : listSommets) {
            if (!CouleurOk.contains(s.getId())) {
                if (s.getColor() == -1) {
                    listVosin = s.getVoisins();
                    nbSv = listVosin.size();
                    //System.out.println(nbSv);
                    couleurtrouver = false;
                    while (!couleurtrouver) {
                        for (Sommet sv : listVosin) {
                            if (sv.getColor() != ActualColor) {
                                nbSv--;
                            }
                        }
                        if (nbSv == 0) {
                            couleurtrouver = true;
                            s.setColor(ActualColor);
                            //System.out.println(s.getId() + " est colorier en " + s.getColor());
                            CouleurOk.add(s.getId());
                            if(couleurmax<ActualColor){ couleurmax = ActualColor; }
                            ActualColor = 0;
                        } else {
                            nbSv = listVosin.size();
                        }
                        ActualColor++;
                    }
                }
            }
            else break;
        }
        this.CouleurMax = couleurmax;
    }

    public int getCouleurMax(){
        return this.CouleurMax;
    }
}
