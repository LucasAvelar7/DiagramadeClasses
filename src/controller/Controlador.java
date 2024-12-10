package controller;

import model.Aluno;
import java.util.ArrayList;
import java.util.List;

public class Controlador {
    private List<Aluno> alunos;
    private int pos;

    public Controlador() {
        alunos = new ArrayList<>();
        pos = 0;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void cadastrarAluno(String nome, double nota) {
        alunos.add(new Aluno(nome, nota));
    }

    public boolean salvarAluno(int index, String nome, double nota) {
        if (index >= 0 && index < alunos.size()) {
            Aluno aluno = alunos.get(index);
            aluno.setNome(nome);
            aluno.setNota(nota);
            return true;
        }
        return false;
    }

    public double calcularMedia() {
        if (alunos.isEmpty()) return 0.0;
        double soma = 0;
        for (Aluno aluno : alunos) {
            soma += aluno.getNota();
        }
        return soma / alunos.size();
    }
}
