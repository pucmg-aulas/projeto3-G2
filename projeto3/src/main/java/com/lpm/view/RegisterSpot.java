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
    private RegisterSpotController controller;

    public RegisterSpot(Estacionamento estacionamentoAtual, Vaga vaga) {
        controller = new RegisterSpotController(this, estacionamentoAtual);
        idVaga.setText(vaga.getId());

        setTitle("Xulambs Parking");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.registrar();
            }
        });
    }
}
