package Autre;

import Type.Sommet;

import java.util.Comparator;

public class CompareNbVoisinColorDegree implements Comparator<Sommet> {

    public int compare(Sommet s1, Sommet s2) {
        if (s1.getDifferentColor() > s2.getDifferentColor()){ return -1; }
        else if (s1.getDifferentColor() < s2.getDifferentColor()){ return 1; }
        else {
        	return s2.getDegre() - s1.getDegre();
        }
    }

}
