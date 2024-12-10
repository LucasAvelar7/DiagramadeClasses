package view;

import controller.Controlador;
import model.Aluno;

import javax.swing.*;

public class AlunosCadastradosFrame extends JFrame {
    private JList<String> alunosList;
    private Controlador controlador;

    public AlunosCadastradosFrame(Controlador controlador) {
        this.controlador = controlador;

        setTitle("Alunos Cadastrados");
        setSize(300, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        alunosList = new JList<>();
        carregarDados();

        add(new JScrollPane(alunosList));
    }

    public void carregarDados() {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Aluno aluno : controlador.getAlunos()) {
            model.addElement(aluno.toString());
        }
        alunosList.setModel(model);
    }
}
