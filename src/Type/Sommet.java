package Type;

import java.util.ArrayList;
import java.util.List;

public class Sommet {
    private int id;
    private int degre;
    private List<Sommet> voisins;
    private int color;
    private int nbvoisinsColor;

    public Sommet(int id) {
        this.id = id;
        this.degre = 0;
        this.voisins = new ArrayList<Sommet>();
        this.color = -1;
        setDifferentColor();
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

    public void setColor(int color){ 
    	this.color = color;
    	}
    
    
    public int setColor() {
    	List<Sommet> s = this.getColorVoisins();
    	int c = 0;
    	int i = 0;
    	boolean find = false;
    	boolean continuer = true; 
    	while(continuer) {
    		find = false;
    		i = 0;
    		c++;
    		while(!find && i < s.size()) {
    			if(s.get(i).getColor() == c) {
    				find = true;
    				s.remove(i);
    			}
    			i++;
    		}
    		if(!find) {
    			continuer = false;
    		}
    	}
    	this.color = c;
    	return c;
    }
    
    
    public int getColor(){ return color; }
    
    
    public boolean voisinColor(int couleur) {
    	boolean find = false;
    	int i = 0;
    	List<Sommet> voisins = this.getVoisins();
    	while(!find & i < voisins.size()) {
    		if(voisins.get(i).getColor() == couleur) {
    			find = true;
    		}
    		else {
    			i++;
    		}
    	}
    	return find;
    }
    
    
    public int getDifferentColor() {
    	return this.nbvoisinsColor;
    }
    
    
    public void setDifferentColor() {
    	int i;
    	List<Integer> l = new ArrayList<Integer>();
    	for(i = 0; i < this.voisins.size(); i++) {
    		if(this.voisins.get(i).getColor() != 0) {
    			if(!l.contains((this.voisins.get(i).getColor()))) {
    				l.add(this.voisins.get(i).getColor());
    			}
    		}
    	}
    	this.nbvoisinsColor = l.size();
    }

}
