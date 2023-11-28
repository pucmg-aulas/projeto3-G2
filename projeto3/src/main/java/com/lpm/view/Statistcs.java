package com.lpm.view;

import com.lpm.controller.StatistcsController;
import com.lpm.model.Estacionamento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Statistcs extends JFrame {

    private StatistcsController controller;
    private JPanel panel1;
    private JLabel labelEstatisticasEstacionamento;
    private JComboBox comboBoxMes;
    private JLabel labelMes;
    private JTextArea textAreaEstatisticas;
    private JButton btnVoltar;

    public JTextArea getTextAreaEstatisticas() {
        return textAreaEstatisticas;
    }

    public Statistcs(Estacionamento estacionamentoAtual) {
        this.controller = new StatistcsController(this, estacionamentoAtual);

        setTitle("Xulambs Parking");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        labelEstatisticasEstacionamento.setText("Estatísticas " + estacionamentoAtual.getNome());

        add(panel1);

        setVisible(true);

        controller.recuperarEstatisticas("Todos");

        textAreaEstatisticas.setEditable(false);
        comboBoxMes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaEstatisticas.setText("");
                controller.recuperarEstatisticas(comboBoxMes.getSelectedItem().toString());
            }
        });
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); new HomeScreen(estacionamentoAtual).setVisible(true);
            }
        });
    }

}
