package Autre;

import Type.Arc;
import Type.Graphe;
import Type.Sommet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FabriquerGraph {

    public FabriquerGraph(){

    }

    public Graphe FabriquerGraph() throws IOException {
        Graphe gaphe = new Graphe();
        List<Sommet> listSommetOk = new ArrayList<Sommet>();

        BufferedReader in = new BufferedReader(new FileReader("src/flat1000_60_0.col"));
        String line = "";
        String[] Sommet;
        String[] nbSommet;
        int nbS = 0;
        int Sommettrouver = 0;
        boolean firstp = false;
        Sommet[] tabSommet = new Sommet[1001];

        while ((line = in.readLine()) != null) {
            //initialise tous les commets
            if(line.contains("p ") && !firstp){
                nbSommet = line.split(" ");
                //Voir si conservé avec autre fichier
                nbSommet = nbSommet[2].split(" ");
                nbS = Integer.parseInt(nbSommet[0]);
                //System.out.println(nbSommet[0]);
                for(int i=1; i<=nbS; i++){
                    Sommet sommet = new Sommet(i);
                    gaphe.ajoutSommet(sommet);
                    listSommetOk.add(sommet);
                    tabSommet[i] = sommet;
                }
            }
            if(line.contains("e")){
                Sommet = line.split(" ");
                //if pour si du  text contient la lettre e avant
                if(Sommet[0].contains("e")){
                    for (int i=1; i<tabSommet.length; i++) {
                        if(Integer.parseInt(Sommet[1]) == tabSommet[i].getId()){Sommettrouver = i; break;}
                    }
                    for(int k=1; k<tabSommet.length; k++){
                        if(Integer.parseInt(Sommet[2]) == tabSommet[k].getId()){
                            tabSommet[Sommettrouver].ajouterVoisin(tabSommet[k]);
                            tabSommet[k].ajouterVoisin(tabSommet[Sommettrouver]);
                            Arc arc = new Arc(tabSommet[Sommettrouver],tabSommet[k]);
                            gaphe.ajoutArc(arc);
                            //System.out.println(arc.getArrivee().getId()+" " + arc.getOrigine().getId());
                            break;
                        }
                    }
                }
            }
        }
        in.close();
        return gaphe;
    }
}
