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

    public Graphe FabriquerGraph(String NomFichier) throws IOException {
        Graphe gaphe = new Graphe();
        List<Sommet> listSommet = new ArrayList<Sommet>();

        BufferedReader in = new BufferedReader(new FileReader("src/Graphe/" + NomFichier));
        String line;
        String[] Sommet;
        String[] nbSommet;
        int nbS = 0;
        int Sommettrouver = 0;
        boolean nbSommetTrouver = false;

        //Connaitre le nombre total de sommet
        while ((line = in.readLine()) != null) {
            if(line.contains("p ")){
                nbSommet = line.split(" ");
                nbSommet = nbSommet[2].split(" ");
                nbS = Integer.parseInt(nbSommet[0]);
                break;
            }
        }
        in.close();

        //Initialisation de tous les sommets
        Sommet[] tabSommet = new Sommet[nbS+1];
        for(int i=1; i<=nbS; i++){
            Sommet sommet = new Sommet(i);
            gaphe.ajoutSommet(sommet);
            listSommet.add(sommet);
            tabSommet[i] = sommet;
        }

        //Ajout des sommets au graph
        BufferedReader file = new BufferedReader(new FileReader("src/Graphe/" + NomFichier));
        while ((line = file.readLine()) != null){
            //Si la ligne contient un arc
            if(line.contains("e")){
                Sommet = line.split(" ");
                //Si la premiière lettre est bien un e
                if(Sommet[0].contains("e")){
                    for (int i=1; i<=tabSommet.length; i++) {
                        if(Integer.parseInt(Sommet[1]) == tabSommet[i].getId()){Sommettrouver = i; break;}
                    }
                    //Création de arc et ajout voisins
                    for(int k=1; k<=tabSommet.length; k++){
                        //Recherche dans le tableau de sommet la coreespondace
                        if(Integer.parseInt(Sommet[2]) == tabSommet[k].getId()){
                            tabSommet[Sommettrouver].ajouterVoisin(tabSommet[k]);
                            tabSommet[k].ajouterVoisin(tabSommet[Sommettrouver]);
                            Arc arc = new Arc(tabSommet[Sommettrouver],tabSommet[k]);
                            gaphe.ajoutArc(arc);
                            break;
                        }
                    }
                }
            }
        }
        file.close();

        return gaphe;
    }
}
