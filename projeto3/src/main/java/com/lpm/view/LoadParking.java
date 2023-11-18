package com.lpm.view;

import javax.swing.*;
import com.lpm.controller.LoadParkingController;

public class LoadParking extends JFrame {
    private JPanel panel1;
    private JButton button1;
    private JTextField textField1;
    private JTextArea casoOEstacionamentoNãoTextArea;
    private final LoadParkingController controller;

    public LoadParking() {
        setTitle("Xulambs Parking");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(panel1);

        setVisible(true);

        controller = new LoadParkingController(this);

        button1.addActionListener(e -> {
            dispose();
            new Main(controller.carregarEstacionamento());
        });
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public void exibeMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public static void main(String[] args) {
        new LoadParking();
    }

}
