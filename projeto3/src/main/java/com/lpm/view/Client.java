package com.lpm.view;


import com.lpm.model.Estacionamento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client extends JFrame {

    private JButton cadastrarButton;
    private JPanel panel1;
    private JButton removerButton;
    private JButton listagemButton;

    public Client() {
        setTitle("Xulambs Parking");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(panel1);

        setVisible(true);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterClient(new Estacionamento()).setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new Client();
    }

}
