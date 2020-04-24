package Autre;

import Type.Sommet;

import java.util.Comparator;

public class CompareNbVoisinColorDegree implements Comparator<Sommet> {

    public int compare(Sommet s1, Sommet s2) {
        return s1.getNbVoisinColor() - s2.getNbVoisinColor();
    }

}
