package edu.gabriel.EstruturaDeDados.ImplementsDataStructure.Queue;

import edu.gabriel.EstruturaDeDados.ImplementsDataStructure.Stacks.Carro;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        Queue<Carro> queueCarros = new LinkedList<>();

        queueCarros.add(new Carro("Fiat"));
        queueCarros.add(new Carro("BMW"));
        queueCarros.add(new Carro("Mercedez"));
        queueCarros.add(new Carro("Chevrolet"));


        System.out.println(queueCarros.add(new Carro("Tesla"))); //se nao conseguir adicionar vai retornar um erro
        System.out.println(queueCarros); //printa a lista
        System.out.println(queueCarros.offer(new Carro("Peugeot"))); // o metodo offer vai verificar se é foi possivel adicionar ou não o item, caso não, vai retornar false
        System.out.println(queueCarros);
        System.out.println(queueCarros.peek()); // vai tirar o primeiro item da lista sem remove-lo e vai exibi-lo
        System.out.println(queueCarros);
        System.out.println(queueCarros.poll()); // o metodo pull por sua vez exclui o item da memoria
        System.out.println(queueCarros);

        System.out.println(queueCarros.isEmpty()); // verifica se a fila está vazia

        System.out.println(queueCarros.size()); // retorna o tamanho da lista





    }


}
