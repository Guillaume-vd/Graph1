package Autre;

import Type.Sommet;

import java.util.Comparator;

public class CompareDegree implements Comparator<Sommet> {

    public int compare(Sommet s1, Sommet s2) {
		return s1.getDegre() - s2.getDegre();
    }
}
