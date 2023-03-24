package edu.gabriel.EstruturaDeDados.ArvoreBinaria.model;

public abstract class ObjArvore<T> implements Comparable<T> {

    //pensei que não poderia piorar...mas piorou
    public abstract boolean equals(Object o);
    public abstract int hashCode();
    public abstract int compareTo(T outro);
    public abstract String toString();
}
