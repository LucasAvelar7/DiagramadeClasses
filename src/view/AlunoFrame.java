package view;

import controller.Controlador;
import model.Aluno;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlunoFrame extends JFrame {
    private JTextField nomeTextField;
    private JTextField notaTextField;
    private JButton okButton;
    private JButton cancelarButton;
    private Controlador controlador;
    private Aluno aluno;
    private boolean editando;

    public AlunoFrame(Controlador controlador, Aluno aluno, boolean editando) {
        this.controlador = controlador;
        this.aluno = aluno;
        this.editando = editando;

        setTitle(editando ? "Editar Aluno" : "Cadastrar Aluno");
        setSize(300, 200);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel nomeLabel = new JLabel("Nome:");
        JLabel notaLabel = new JLabel("Nota:");

        nomeTextField = new JTextField();
        notaTextField = new JTextField();

        nomeLabel.setBounds(20, 20, 100, 25);
        notaLabel.setBounds(20, 60, 100, 25);

        nomeTextField.setBounds(120, 20, 150, 25);
        notaTextField.setBounds(120, 60, 150, 25);

        okButton = new JButton("OK");
        cancelarButton = new JButton("Cancelar");

        okButton.setBounds(50, 120, 80, 30);
        cancelarButton.setBounds(150, 120, 100, 30);

        add(nomeLabel);
        add(nomeTextField);
        add(notaLabel);
        add(notaTextField);
        add(okButton);
        add(cancelarButton);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeTextField.getText();
                double nota = Double.parseDouble(notaTextField.getText());
                controlador.cadastrarAluno(nome, nota);
                dispose();
            }
        });

        cancelarButton.addActionListener(e -> dispose());
    }
}
