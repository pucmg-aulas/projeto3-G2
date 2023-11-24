package com.lpm.view;

import com.lpm.controller.ListClientController;
import com.lpm.model.Estacionamento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListClient extends JFrame {
    private JPanel panel1;
    private JTable tableClientes;
    private JLabel labelListaEstacionamento;
    private JButton btnVoltar;
    private final ListClientController controller;

    public ListClient(Estacionamento estacionamentoAtual) {
        setTitle("Xulambs Parking");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.controller = new ListClientController(this, estacionamentoAtual);

        // Cria o DefaultTableModel
        DefaultTableModel tableModel = new DefaultTableModel();
        // Adiciona as colunas à tabela
        tableModel.addColumn("Nome");
        tableModel.addColumn("CPF");
        tableModel.addColumn("Veículos");

        // Adiciona os dados à tabela

        controller.popularTabela(tableModel);

        // Cria a JTable com o DefaultTableModel
        tableClientes = new JTable(tableModel);

        // Adiciona um JScrollPane para a tabela
        JScrollPane scrollPane = new JScrollPane(tableClientes);
        panel1.setLayout(new BorderLayout());
        panel1.add(scrollPane, BorderLayout.CENTER);

        add(panel1);
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); new Client(estacionamentoAtual).setVisible(true);
            }
        });
    }
}

