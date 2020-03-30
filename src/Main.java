import java.io.IOException;

import Type.*;
import Algo.*;


public class Main {
    //https://mat.gsia.cmu.edu/COLOR/instances.html
    //Voir claroline col.b

    public static void main(String[] args) throws IOException {
        long debut = 0;
        long fin = 0;


        Graphe gaphe = new Graphe();
        FabriquerGraph FG = new FabriquerGraph();
        debut = System.currentTimeMillis();
        gaphe = FG.FabriquerGraph();
        fin = System.currentTimeMillis() - debut;
        System.out.println("Le graphe à été générer en " + fin+"ms");

        Greedy greedy = new Greedy();
        debut = System.currentTimeMillis();
        int nbCouleurGD = greedy.Greedy(gaphe);
        fin = System.currentTimeMillis() - debut;
        System.out.println("Le cacul algo Greedy à pris "+ fin +"ms avec " + nbCouleurGD+ " couleurs");


        WelshPowell WP = new WelshPowell();
        int nbCouleurWp = WP.WelshPowell(gaphe);
        System.out.println(nbCouleurWp);

    }
}
