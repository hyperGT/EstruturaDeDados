package edu.gabriel.EstruturaDeDados.ImplementsDataStructure.Set;

import edu.gabriel.EstruturaDeDados.ImplementsDataStructure.ClasseCarro.Carro;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        Set<Carro> carrosHashSetList = new HashSet<>();

        carrosHashSetList.add(new Carro("Ford"));
        carrosHashSetList.add(new Carro("Jeep"));
        carrosHashSetList.add(new Carro("Renault"));
        carrosHashSetList.add(new Carro("BMW"));
        carrosHashSetList.add(new Carro("Mercedez"));
        carrosHashSetList.add(new Carro("Tesla"));
        carrosHashSetList.add(new Carro("Fiat"));

        System.out.println(carrosHashSetList);

        Set<Carro> treeSetCarros = new TreeSet<>();

        treeSetCarros.add(new Carro("Ford"));
        treeSetCarros.add(new Carro("Jeep"));
        treeSetCarros.add(new Carro("Renault"));
        treeSetCarros.add(new Carro("BMW"));
        treeSetCarros.add(new Carro("Mercedez"));
        treeSetCarros.add(new Carro("Tesla"));
        treeSetCarros.add(new Carro("Fiat"));

        System.out.println(treeSetCarros); //deu erro porque não implementamos a 'interface' Comparable


    }
}
