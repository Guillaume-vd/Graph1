import java.io.IOException;
import java.util.Scanner;

import Autre.FabriquerGraph;
import Autre.InitCouleur;
import Type.*;
import Algo.*;


public class Main {
    //https://mat.gsia.cmu.edu/COLOR/instances.html
    //Voir claroline col.b

    public static void main(String[] args) throws IOException {
        long debut = 0;
        long fin = 0;
        int nbCouleur = 0;

        InitCouleur IC = new InitCouleur();

        //Pour chosir son fichier parmis les fichiers contenu dans graph
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le nom du fichier avec l'extention:");
        String NomFichier = sc.nextLine();

        Graphe gaphe = new Graphe();
        FabriquerGraph FG = new FabriquerGraph();

        debut = System.currentTimeMillis();
        gaphe = FG.FabriquerGraph(NomFichier);
        fin = System.currentTimeMillis() - debut;
        System.out.println("Le graphe à été générer en " + fin+"ms");

        Greedy greedy = new Greedy();
        debut = System.currentTimeMillis();
        nbCouleur = greedy.Greedy(gaphe);
        fin = System.currentTimeMillis() - debut;
        System.out.println("Le cacul algo Greedy à pris "+ fin +"ms avec " + nbCouleur+ " couleurs");

        IC.InitCouleur(gaphe);

        WelshPowell WP = new WelshPowell();
        debut = System.currentTimeMillis();
        nbCouleur = WP.WelshPowell(gaphe);
        fin = System.currentTimeMillis() - debut;
        System.out.println("Le cacul algo WelshPowell à pris "+ fin +"ms avec " + nbCouleur+ " couleurs");

    }
}
