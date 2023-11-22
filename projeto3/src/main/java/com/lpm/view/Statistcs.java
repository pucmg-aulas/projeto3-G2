package com.lpm.view;

import com.lpm.controller.StatistcsController;

import javax.swing.*;
import java.awt.*;

public class Statistcs extends JFrame {

    private StatistcsController controller;
    private JPanel panel1;
    private JTextField textField1;
    private JComboBox<Integer> comboBoxMeses;

    public Statistcs() {
        setTitle("Xulambs Parking");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        comboBoxMeses = new JComboBox<>(new DefaultComboBoxModel<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}));
        panel1.add(comboBoxMeses, BorderLayout.NORTH);

        add(panel1);

        setVisible(true);
    }

    public void showStatistcs(){
        
    }






}
