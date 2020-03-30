package Algo;

import Type.Graphe;
import Type.Sommet;

import java.util.ArrayList;
import java.util.List;

public class Greedy {

    public Greedy(){

    }

    public int Greedy(Graphe graphe){
        int ActualColor = 0;
        List<Sommet> listSommets = new ArrayList<Sommet>();
        List<Sommet> listVosin = new ArrayList<Sommet>();
        ArrayList<Integer> CouleurOk = new ArrayList<>();
        listSommets = graphe.getSommets();
        int couleurmax = 0;

        for (Sommet s : listSommets) {
            if (!CouleurOk.contains(s.getId())) {
                if (s.getColor() == -1) {
                    listVosin = s.getVoisins();
                    int nbSv = listVosin.size();
                    //System.out.println(nbSv);
                    boolean couleurtrouver = false;
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
        return couleurmax;
    }
}
