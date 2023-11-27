package com.lpm.view;

import com.lpm.controller.StatistcsController;
import com.lpm.model.Estacionamento;

import javax.swing.*;

public class Statistcs extends JFrame {

    private StatistcsController controller;
    private JPanel panel1;
    private JLabel labelEstatisticasEstacionamento;
    private JComboBox comboBoxMes;
    private JLabel labelMes;
    private JTextArea textAreaEstatisticas;

    public Statistcs(Estacionamento estacionamentoAtual) {
        setTitle("Xulambs Parking");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(panel1);

        setVisible(true);
    }

    public void showStatistcs(){
        
    }






}
