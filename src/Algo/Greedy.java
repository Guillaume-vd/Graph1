package Algo;

import Type.Graphe;
import Type.Sommet;

import java.util.ArrayList;
import java.util.List;

public class Greedy {

    public Greedy(){

    }

    public static int Greedy(Graphe graphe){
        int ActualColor = 0;
        List<Sommet> listSommets;
        List<Sommet> listVosin;
        listSommets = graphe.getSommets();
        int couleurmax = 0;

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
