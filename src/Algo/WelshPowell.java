package Algo;

import Autre.CompareDegree;

import Type.*;
import java.io.IOException;
import java.util.*;

public class WelshPowell extends Graphe {

    public WelshPowell(){

    }

    public static int WelshPowell(Graphe graphe)  throws IOException {
        int ActualColor = 0;
        List<Sommet> listSommets = new ArrayList<Sommet>();
        List<Sommet> listVosin = new ArrayList<Sommet>();
        boolean degreok = false;
        int min = 0;
        int couleurmax = 0;

        listSommets = graphe.getSommets();
        Collections.sort(listSommets, new CompareDegree());

        //On parcours tous les sommets dans l'ordre.
        for (Sommet s : listSommets) {
            //Si la couleur n'a pas été encore initialisé
            if (s.getColor() == -1) {
                listVosin = s.getVoisins();
                int nbSv = listVosin.size();
                boolean couleurtrouver = false;
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
                        if(couleurmax<ActualColor){ couleurmax = ActualColor; }
                        ActualColor = 0;
                    }
                    // Sinon on passe à la couleur suivante
                    else {
                        nbSv = listVosin.size();
                        ActualColor++;
                    }
                }
            }
            else break;
        }

        return couleurmax;
    }

}
