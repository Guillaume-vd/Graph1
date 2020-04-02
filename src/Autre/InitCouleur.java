package Autre;

import Type.Graphe;
import Type.Sommet;

import java.util.ArrayList;
import java.util.List;

public class InitCouleur {

    public void InitCouleur(){

    }

    public void InitCouleur(Graphe graphe){
        List<Sommet> listSommets = new ArrayList<Sommet>();
        listSommets = graphe.getSommets();

        for (Sommet s: listSommets) {
            s.setColor(-1);
        }

    }
}
