package Algo;

import Type.*;

import java.io.IOException;
import java.util.*;


public class WelshPowell extends Graphe {

    public WelshPowell(){

    }

    public int WelshPowell(Graphe graphe)  throws IOException {
        int ActualColor = 0;
        List<Sommet> listSommets = new ArrayList<Sommet>();
        Map<Sommet, Integer> listSommetsTrier = new LinkedHashMap<>();

        ArrayList<Sommet> listVosin = new ArrayList<Sommet>();
        ArrayList<Integer> CouleurOk = new ArrayList<>();
        boolean degreok = false;
        int min = 0;
        listSommets = graphe.getSommets();

        System.out.println(listSommets);
        int couleurmax = 0;
        int i = 0;
        for (Sommet s : listSommets) {
            listSommetsTrier.put(s, s.getDegre());
        }


        return couleurmax;
    }
}
