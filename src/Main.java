import java.io.IOException;
import java.util.Scanner;

import Autre.FabriquerGraph;
import Autre.InitCouleur;
import Type.*;
import Algo.*;


public class Main {
    //Tous les graphs da,s le fichier Graphe

    public static void main(String[] args) throws IOException {
        long debut;
        long fin;
        int nbCouleur;

        InitCouleur IC = new InitCouleur();

        //Pour chosir son fichier parmis les fichiers contenu dans graph
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le nom du fichier avec l'extention:");
        String NomFichier = sc.nextLine();

        Graphe graphe = new Graphe();
        FabriquerGraph FG = new FabriquerGraph();

        debut = System.currentTimeMillis();
        graphe = FG.FabriquerGraph(NomFichier);
        fin = System.currentTimeMillis() - debut;
        System.out.println("Le graphe à été générer en " + fin+"ms");

        debut = System.currentTimeMillis();
        Greedy greedy = new Greedy(graphe);
        nbCouleur = greedy.getCouleurMax();
        fin = System.currentTimeMillis() - debut;
        System.out.println("Le cacul algo Greedy à pris "+ fin +"ms avec " + nbCouleur+ " couleurs");

        IC.InitCouleur(graphe);

        debut = System.currentTimeMillis();
        WelshPowell WP = new WelshPowell(graphe);
        nbCouleur = WP.getCouleurMax();
        fin = System.currentTimeMillis() - debut;
        System.out.println("Le cacul algo WelshPowell à pris "+ fin +"ms avec " + nbCouleur+ " couleurs");
        
        IC.InitCouleur(graphe);

        debut = System.currentTimeMillis();
        Dsatur Ds = new Dsatur(graphe);
        nbCouleur = Ds.getCouleurMax();
        fin = System.currentTimeMillis() - debut;
        System.out.println("Le cacul algo Dsatur à pris "+ fin +"ms avec " + nbCouleur+ " couleurs");

    }
}
