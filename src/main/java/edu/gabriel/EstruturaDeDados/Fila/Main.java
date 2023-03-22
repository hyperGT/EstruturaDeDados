package edu.gabriel.EstruturaDeDados.Fila;

public class Main {

    public static void main(String[] args) {

        Fila<String> minhaFila = new Fila<>();


        minhaFila.enqueue("A");
        minhaFila.enqueue("B");
        minhaFila.enqueue("C");
        minhaFila.enqueue("D");

        System.out.println(minhaFila);

        System.out.println(minhaFila.dequeue());
        System.out.println(minhaFila);

        minhaFila.enqueue("Zero");
        System.out.println(minhaFila);

        System.out.println(minhaFila.first());


    }
}
