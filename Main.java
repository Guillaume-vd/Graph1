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

        //Pour chosir son fichier parmis les fichiers contenu dans graph
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le nom du fichier avec l'extention:");
        String NomFichier = sc.nextLine();
        sc.close();

        //Création du graph
        debut = System.currentTimeMillis();
        Graphe graphe;
        FabriquerGraph FG = new FabriquerGraph(NomFichier);
        graphe = FG.getGrape();
        InitCouleur IC = new InitCouleur(graphe);
        fin = System.currentTimeMillis() - debut;
        System.out.println("Le graphe à été générer en " + fin+"ms");

        //Algo Greedy avec tri par ordre croissant
        debut = System.currentTimeMillis();
        Greedy greedy = new Greedy(graphe, true);
        nbCouleur = greedy.getCouleurMax();
        fin = System.currentTimeMillis() - debut;
        System.out.println("Le cacul algo Greedy par tri croissant à pris "+ fin +"ms avec " + nbCouleur+ " couleurs");

        IC.resetColor();
        
        //Algo Greedy avec tri par ordre decroissant
        debut = System.currentTimeMillis();
        greedy = new Greedy(graphe, false);
        nbCouleur = greedy.getCouleurMax();
        fin = System.currentTimeMillis() - debut;
        System.out.println("Le cacul algo Greedy par tri de décroissant à pris "+ fin +"ms avec " + nbCouleur+ " couleurs");

        IC.resetColor();

        //Algo WelshPowell avec tri par ordre croissant
        debut = System.currentTimeMillis();
        WelshPowell WP = new WelshPowell(graphe, true);
        nbCouleur = WP.getCouleurMax();
        fin = System.currentTimeMillis() - debut;
        System.out.println("Le cacul algo WelshPowell par tri croissant à pris "+ fin +"ms avec " + nbCouleur+ " couleurs");
        
        IC.resetColor();
        
        //Algo WelshPowell avec tri par ordre decroissant
        debut = System.currentTimeMillis();
        WP = new WelshPowell(graphe, false);
        nbCouleur = WP.getCouleurMax();
        fin = System.currentTimeMillis() - debut;
        System.out.println("Le cacul algo WelshPowell par tri decroissant à pris "+ fin +"ms avec " + nbCouleur+ " couleurs");
        
        IC.resetColor();

        //Algo Dsatur
        debut = System.currentTimeMillis();
        Dsatur Ds = new Dsatur(graphe);
        nbCouleur = Ds.getCouleurMax();
        fin = System.currentTimeMillis() - debut;
        System.out.println("Le cacul algo Dsatur à pris "+ fin +"ms avec " + nbCouleur+ " couleurs");
        
    }
}
