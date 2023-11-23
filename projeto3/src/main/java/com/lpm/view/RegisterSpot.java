package com.lpm.view;

import com.lpm.controller.RegisterSpotController;
import com.lpm.model.Estacionamento;
import com.lpm.model.Vaga;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterSpot extends JFrame{
    private JLabel tituloJanela;
    private JTextField textFieldPlaca;
    private JButton btnConfirmar;
    private JButton btnCancelar;
    private JLabel labelTextPlaca;
    private JLabel idVaga;
    private JPanel panel1;
    private RegisterSpotController controller;

    public RegisterSpot(Estacionamento estacionamentoAtual, Vaga vaga) {
        controller = new RegisterSpotController(this, estacionamentoAtual);
        idVaga.setText(vaga.getId());

        setTitle("Xulambs Parking");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(panel1);


        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(vaga.disponivel()) {
                    controller.registrar(textFieldPlaca.getText(), vaga.getId());
                    dispose();
                    new HomeScreen(estacionamentoAtual).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Vaga indisponível!");
                }
            }
        });
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewParking(estacionamentoAtual).setVisible(true);
            }
        });
    }
}
