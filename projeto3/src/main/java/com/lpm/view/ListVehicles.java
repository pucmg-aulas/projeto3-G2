package com.lpm.view;

import com.lpm.controller.ListVehiclesController;
import com.lpm.model.Cliente;
import com.lpm.model.Estacionamento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListVehicles extends JFrame {
    private JLabel labelTituloJanela;
    private JLabel labelNomeCliente;
    private JTable tableVeiculosCliente;
    private JButton btnVoltar;
    private JPanel panel1;
    private final ListVehiclesController controller;

    public ListVehicles(Estacionamento estacionamentoAtual, String cpfCliente) {
        setTitle("Xulambs Parking");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.controller = new ListVehiclesController(this, estacionamentoAtual);

        // Cria o DefaultTableModel
        DefaultTableModel tableModel = new DefaultTableModel();

        // Adiciona as colunas à tabela
        tableModel.addColumn("Placa");
        tableModel.addColumn("Estacionado");

        // Adiciona os dados à tabela
        controller.popularTabela(tableModel, cpfCliente);

        tableVeiculosCliente = new JTable(tableModel);

        // Adiciona um JScrollPane para a tabela
        JScrollPane scrollPane = new JScrollPane(tableVeiculosCliente);
        panel1.setLayout(new BorderLayout());
        panel1.add(labelTituloJanela, BorderLayout.BEFORE_FIRST_LINE);
        panel1.add(btnVoltar, BorderLayout.AFTER_LAST_LINE);
        panel1.add(scrollPane, BorderLayout.CENTER);

        add(panel1);


        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); new ListClient(estacionamentoAtual).setVisible(true);
            }
        });
    }


}
