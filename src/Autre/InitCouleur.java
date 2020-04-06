package Autre;

import Type.Graphe;
import Type.Sommet;
import java.util.List;

public class InitCouleur {
	private List<Sommet> listSommets;

    public InitCouleur(Graphe graphe){
        this.listSommets = graphe.getSommets();
    }
    
    public void resetColor() {
    	for (Sommet s: this.getSommets()) {
            s.setColor(-1);
        }
    }
    
    public List<Sommet> getSommets(){
    	return this.listSommets;
    }
}
