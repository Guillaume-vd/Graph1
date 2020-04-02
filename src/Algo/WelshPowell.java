package Algo;

import Autre.CompareDegree;

import Type.*;
import java.io.IOException;
import java.util.*;

public class WelshPowell extends Graphe {

    public WelshPowell(){

    }

    public int WelshPowell(Graphe graphe)  throws IOException {
        int ActualColor = 0;
        List<Sommet> listSommets = new ArrayList<Sommet>();
        ArrayList<Sommet> listVosin = new ArrayList<Sommet>();
        boolean degreok = false;
        int min = 0;
        int couleurmax = 0;

        listSommets = graphe.getSommets();
        Collections.sort(listSommets, new CompareDegree());

        for (Sommet s: listSommets) {
            System.out.println(s);
        }


        return couleurmax;
    }

    public int compare(Sommet s1, Sommet s2) {
        if (s1.getDegre() > s2.getDegre()) { return -1; }
        else if (s1.getDegre() < s2.getDegre()){ return 1; }
        return 0;
    }
}
