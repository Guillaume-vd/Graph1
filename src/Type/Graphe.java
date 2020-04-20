package Type;

import java.util.ArrayList;
import java.util.List;

public class Graphe {
    protected List<Sommet> sommets;

    public Graphe(){
        this.sommets = new ArrayList<Sommet>();
    }

    public String toString() {
        String retour = "";
        retour += "Nombre de sommets : " + this.sommets.size() + "\n";
        return retour;
    }

    public void ajoutSommet(Sommet s) {
        this.sommets.add(s);
    }

    public List<Sommet> getSommets() {
        return this.sommets;
    }
    
    public List<Sommet> getSommetsClone() {
    	List<Sommet> s = this.getSommets();
        List<Sommet> s2 = new ArrayList<>();
        for (Sommet sommet : s) {
			s2.add(sommet);
		}
        return s2;
    }

}
