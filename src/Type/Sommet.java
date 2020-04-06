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
    
    public List<Sommet> getColorVoisins() {
    	int i;
    	List<Sommet> sommets = new ArrayList<Sommet>();
    	List<Sommet> v = this.getVoisins();
    	for(i = 0; i < v.size(); i++) {
    		if(v.get(i).getColor() != -1) {
    			sommets.add(v.get(i));
    		}
    	}
    	return sommets;
    }

    public void setColor(int color){ this.color = color; }
    
    public void setColor() {
    	List<Sommet> s = this.getColorVoisins();
    	int c = 1;
    	int i;
    	boolean find = false;
    	boolean continuer = true; 
    	while(continuer) {
    		for(i = 0; i < s.size(); i++) {
    			if(s.get(i).getColor() == c) {
    				find = true;
    			}
    		}
    		if(find) {
    			find = false;
    			c++;
    		}
    		else {
    			continuer = false;
    		}
    	}
    	this.color = c;
    }
    
    public int getColor(){ return color; }

    public void incrementerColorVoisin(){
        this.NbVoisinColore++;
    }

    public int getNbVoisinColor(){
        return NbVoisinColore;
    }

}
