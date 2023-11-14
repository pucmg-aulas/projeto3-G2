package com.lpm.view;

import javax.swing.*;

public class loadParking extends JFrame {
    private JPanel panel1;
    private JButton button1;
    private JTextField textField1;
    private JTextArea casoOEstacionamentoNãoTextArea;

    public loadParking() {
        setTitle("Xulambs Parking");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        button1.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Estacionamento carregado com sucesso!");
            dispose();
            new Main().setVisible(true);
        });

        add(panel1);

        setVisible(true);
    }

    public static void main(String[] args) {
        new loadParking();
    }
}
