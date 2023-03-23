package edu.gabriel.EstruturaDeDados.ListaEncadeada;

public class Main {

    public static void main(String[] args) {

        ListaEncadeada<String> minhaListaEncadeada = new ListaEncadeada<>();

        minhaListaEncadeada.add("teste1"); //indice 0
        minhaListaEncadeada.add("teste2"); //indice 1
        minhaListaEncadeada.add("teste3"); //indice 2
        minhaListaEncadeada.add("teste4"); //indice 3

        //System.out.println(minhaListaEncadeada.get(0));

        System.out.println(minhaListaEncadeada);

        System.out.println(minhaListaEncadeada.remove(3));
        System.out.println(minhaListaEncadeada);
    }
}
