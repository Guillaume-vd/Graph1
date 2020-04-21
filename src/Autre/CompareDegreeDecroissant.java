package Autre;

import Type.Sommet;

import java.util.Comparator;

public class CompareDegreeDecroissant implements Comparator<Sommet> {

    public int compare(Sommet s1, Sommet s2) {
		return s2.getDegre() - s1.getDegre();
    }
}
