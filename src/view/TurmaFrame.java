package view;

import controller.Controlador;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TurmaFrame extends JFrame {
    private JButton listarAlunosButton;
    private JButton novoAlunoButton;
    private JButton resultadosButton;
    private Controlador controlador;

    public TurmaFrame(Controlador controlador) {
        this.controlador = controlador;

        setTitle("Gerenciamento de Turma");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        listarAlunosButton = new JButton("Listar Alunos");
        novoAlunoButton = new JButton("Novo Aluno");
        resultadosButton = new JButton("Resultados");

        listarAlunosButton.setBounds(50, 30, 200, 30);
        novoAlunoButton.setBounds(50, 70, 200, 30);
        resultadosButton.setBounds(50, 110, 200, 30);

        add(listarAlunosButton);
        add(novoAlunoButton);
        add(resultadosButton);

        listarAlunosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AlunosCadastradosFrame(controlador).setVisible(true);
            }
        });

        novoAlunoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AlunoFrame(controlador, null, false).setVisible(true);
            }
        });

        resultadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double media = controlador.calcularMedia();
                JOptionPane.showMessageDialog(null, "Média da turma: " + media);
            }
        });
    }
}
