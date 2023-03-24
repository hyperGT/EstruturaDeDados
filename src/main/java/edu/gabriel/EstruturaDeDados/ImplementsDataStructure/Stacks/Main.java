package edu.gabriel.EstruturaDeDados.ImplementsDataStructure.Stacks;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Stack<Carro> stackCarro = new Stack<>();

        stackCarro.push(new Carro("Fiat"));
        stackCarro.push(new Carro("Chevrolet"));
        stackCarro.push(new Carro("BMW"));

        System.out.println(stackCarro);

        System.out.println(stackCarro.pop()); //remove o primeiro item da pilha

        System.out.println(stackCarro.peek()); //pega um item especifico da pilha e o exibe

        System.out.println(stackCarro.empty()); //verifica se a pilha esta vazia

        System.out.println(stackCarro);
    }
}
