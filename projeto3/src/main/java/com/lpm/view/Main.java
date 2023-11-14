package com.lpm.view;

import com.lpm.model.Estacionamento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JPanel panel1;
    private JButton visaoGeralDoEstacionamentoButton;
    private JButton estatisticasButton;
    private JButton clientesButton;

    public Main() {
        setTitle("Xulambs Parking");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(panel1);

        clientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Client().setVisible(true);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
        Estacionamento estacionamento = new Estacionamento();
    }
}
