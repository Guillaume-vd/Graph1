package Autre;

import Type.Graphe;
import Type.Sommet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FabriquerGraph {
	private Graphe graphe;

    public FabriquerGraph(String NomFichier) throws IOException{
    	Graphe graphe = new Graphe();

        BufferedReader in = new BufferedReader(new FileReader("src/Graphe/" + NomFichier));
        String line;
        String[] Sommet;
        int nbS = 0;
        int a;
        int b;

        //Connaitre le nombre total de sommet
        line = in.readLine();
        while((line != null) && (line.charAt(0) != 'p')){
        	line = in.readLine();
        }
        nbS = Integer.parseInt(line.split(" ")[2]);
        in.close();

        //Initialisation de tous les sommets
        Sommet[] tabSommet = new Sommet[nbS+1];
        for(int i=1; i<=nbS; i++){
            Sommet sommet = new Sommet(i);
            graphe.ajoutSommet(tabSommet[i] = sommet);
        }

        //Ajout des sommets au graph
        BufferedReader file = new BufferedReader(new FileReader("src/Graphe/" + NomFichier));
        while ((line = file.readLine()) != null){
            //Si la ligne contient un arc
            Sommet = line.split(" ");
            if(Sommet[0].contains("e")){
            	a = Integer.parseInt(Sommet[1]);
            	b = Integer.parseInt(Sommet[2]);
                //Création de arc et ajout voisins
                tabSommet[a].ajouterVoisin(tabSommet[b]);
                tabSommet[b].ajouterVoisin(tabSommet[a]);
            }
        }
        file.close();
        this.graphe = graphe;
    }

    public Graphe getGrape() throws IOException {
        return this.graphe;
    }
}
