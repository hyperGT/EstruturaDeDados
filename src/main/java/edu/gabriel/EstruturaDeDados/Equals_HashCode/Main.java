package edu.gabriel.EstruturaDeDados.Equals_HashCode;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Carro> listaCarros = new ArrayList<>();

        listaCarros.add(new Carro("Ford"));
        listaCarros.add(new Carro("Chevrolet"));
        listaCarros.add(new Carro("Peugeot"));

        System.out.println(listaCarros.contains(new Carro("Ford")));

        System.out.println(new Carro("Peugeot").hashCode());
        System.out.println(new Carro("Peugeot12").hashCode());

        Carro carro1 = new Carro("lamborghini");
        Carro carro2 = new Carro("Mercedez");

        System.out.println(carro1.equals(carro2));

    }
}
