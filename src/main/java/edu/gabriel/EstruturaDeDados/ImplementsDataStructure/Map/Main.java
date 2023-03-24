package edu.gabriel.EstruturaDeDados.ImplementsDataStructure.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, String> aluno = new HashMap<>();

        aluno.put("Nome", "Joao Pedro");
        aluno.put("Idade", "18");
        aluno.put("Sexo", "masculino");
        aluno.put("Turma", "3a");

        // System.out.println(aluno);
        // System.out.println("\n");
        // System.out.println(aluno.keySet());
        // System.out.println(aluno.values());
        List<Map<String,String>> listaAluno = new ArrayList<>();    // Para guardar todos os nossos Map. Em uma lista

        listaAluno.add(aluno);

        Map<String,String> aluno2 = new HashMap<>();

        aluno2.put("Nome", "Maria");
        aluno2.put("Idade", "17");
        aluno2.put("Sexo", "feminino");
        aluno2.put("Turma", "3b");

        listaAluno.add(aluno2);

        //listaAluno.remove(aluno); //funciona mas não que expulsar o Joao Pedro da escola n

        System.out.println(listaAluno);

        System.out.println(aluno2.containsKey("Nome"));

    }
}
