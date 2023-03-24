package edu.gabriel.EstruturaDeDados.ImplementsDataStructure.List;

import edu.gabriel.EstruturaDeDados.ImplementsDataStructure.ClasseCarro.Carro;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Carro> carroList = new ArrayList<>();

        carroList.add(new Carro("Fiat"));
        carroList.add(new Carro("Chevrolet"));
        carroList.add(new Carro("BMW"));
        carroList.add(new Carro("Mercedez"));

        System.out.println(carroList.contains(new Carro("Lamborghini")));

        System.out.println(carroList.get(2));

        System.out.println(carroList.indexOf(new Carro("Chevrolet")));

        System.out.println(carroList.remove(3));
        System.out.println(carroList);

        System.out.println(carroList.size());




    }

}
