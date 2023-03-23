package edu.gabriel.EstruturaDeDados.ListaCircular;

public class Main {

    public static void main(String[] args) {

        ListaCircular<String> minhaLista = new ListaCircular<>();

        minhaLista.add("c0");


        minhaLista.remove(0);
        //System.out.println(minhaLista);

        minhaLista.add("c3");
        minhaLista.add("c4");

        System.out.println(minhaLista.get(0));

    }
}
