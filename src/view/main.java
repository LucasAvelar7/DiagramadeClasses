package view;

import controller.Controlador;

public class main {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        new TurmaFrame(controlador).setVisible(true);
    }
}
