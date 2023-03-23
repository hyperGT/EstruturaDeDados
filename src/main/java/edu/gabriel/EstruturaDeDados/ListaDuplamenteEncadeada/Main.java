package edu.gabriel.EstruturaDeDados.ListaDuplamenteEncadeada;

public class Main {

    public static void main(String[] args) {

        ListaDuplamenteEncadeada<String> minhaListaEncadeada = new ListaDuplamenteEncadeada<>();

        minhaListaEncadeada.add("c1");
        minhaListaEncadeada.add("c2");
        minhaListaEncadeada.add("c3");
        minhaListaEncadeada.add("c4");
        minhaListaEncadeada.add("c5");
        minhaListaEncadeada.add("c6");
        minhaListaEncadeada.add("c7");


        minhaListaEncadeada.add(0, "c0");
        minhaListaEncadeada.remove(6);

        System.out.println(minhaListaEncadeada);

    }
}
