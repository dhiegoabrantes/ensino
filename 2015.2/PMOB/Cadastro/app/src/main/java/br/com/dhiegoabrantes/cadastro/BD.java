package br.com.dhiegoabrantes.cadastro;

import java.util.ArrayList;
import java.util.List;

import br.com.dhiegoabrantes.cadastro.domain.Aluno;

/**
 * Created by dhiego on 15/08/15.
 */
public class BD {

    private static List<Aluno> alunos = new ArrayList<Aluno>();

    static class Alunos {

        static void add(Aluno a){
            alunos.add(a);
        }

        static Aluno get(String nome){
            for(Aluno a : alunos){
                if(a.getNome().equals(nome))
                    return a;
            }
            return null;
        }

        static List<Aluno> getAll(){
            return alunos;
        }

    }


}
