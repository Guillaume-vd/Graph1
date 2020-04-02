package Type;

import java.util.ArrayList;
import java.util.List;

public class Sommet {
    private int id;
    private int degre;
    private List<Sommet> voisins;
    private int color;
    private int NbVoisinColore;

    public Sommet(int id) {
        this.id = id;
        this.degre = 0;
        this.voisins = new ArrayList<Sommet>();
        this.color = -1;
        this.NbVoisinColore = 0;
    }

    public boolean equals(Sommet autreSommet){
        return super.equals(autreSommet);
    }

    public List<Sommet> getVoisins() {
        return this.voisins;
    }

    public void incrementerDegre() {
        this.degre++;
    }

    public void ajouterVoisin(Sommet sommet) {
        incrementerDegre();
        this.voisins.add(sommet);
    }

    public int getDegre() {
        return this.degre;
    }

    public int getId(){
        return id;
    }

    public void setColor(int color){ this.color = color; }

    public int getColor(){ return color; }

    public void incrementerColorVoisin(){
        this.NbVoisinColore++;
    }

    public int getNbVoisinColor(){
        return NbVoisinColore;
    }

}
