package com.lpm.view;

import com.lpm.controller.ListVehiclesController;
import com.lpm.model.Estacionamento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ListVehicles extends JFrame {
    private JLabel labelTituloJanela;
    private JLabel labelNomeCliente;
    private JTable tableVeiculosCliente;
    private JButton btnVoltar;
    private final ListVehiclesController controller;

    public ListVehicles(Estacionamento estacionamentoAtual) {
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
        controller.popularTabela(tableModel);
    }
}
