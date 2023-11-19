package com.lpm.view;

import com.lpm.controller.ViewParkingController;
import com.lpm.model.Estacionamento;
import com.lpm.model.Vaga;

import javax.swing.*;
import java.awt.*;

public class ViewParking extends JFrame {
    private JLabel nomeEstacionamento;
    private JPanel painelPrincipal;
    private ViewParkingController controller;

    public ViewParking(Estacionamento estacionamento) {
        int counter = 0;
        controller = new ViewParkingController(this, estacionamento);
        nomeEstacionamento.setText(estacionamento.getNome());

        setTitle(estacionamento.getNome());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null);

        JPanel painelVagas = new JPanel(new GridLayout(estacionamento.getQuantFileiras(), estacionamento.getVagasPorFileira()));

        for(int i = 0; i < estacionamento.getQuantFileiras(); i++) {
            for(int j = 0; j < estacionamento.getVagasPorFileira(); j++) {
                painelVagas.add(criarVaga(controller.getVagas().get(counter)));
                counter++;
            }
        }
        add(painelVagas);
    }

    private JPanel criarVaga(Vaga vaga) {
        JPanel result = new JPanel();
        result.setPreferredSize(new Dimension(50, 50)); // Tamanho da vaga

        if(vaga.disponivel()) {
            result.setBackground(Color.GREEN); // Caso disponivel, vaga setada para green
        } else {
            result.setBackground(Color.RED); // Caso contrario, vaga setada para red
        }

        result.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Borda preta para destacar as vagas

        result.add(new JLabel(vaga.getId()), SwingConstants.CENTER);

        return result;
    }
}
