package com.lpm.view;

import com.lpm.model.Estacionamento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ClientsList extends JFrame {
    private JPanel panel1;
    private JTable tabelaClientes;

    public ClientsList(Estacionamento estacionamentoAtual) {
        setTitle("Xulambs Parking");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Cria o DefaultTableModel
        DefaultTableModel tableModel = new DefaultTableModel();
        // Adiciona as colunas à tabela
        tableModel.addColumn("Nome");
        tableModel.addColumn("CPF");

        // Adiciona os dados à tabela (substitua isto com os dados reais do Estacionamento)
        tableModel.addRow(new Object[]{"Cliente1", "123.456.789-01"});
        tableModel.addRow(new Object[]{"Cliente2", "987.654.321-09"});

        // Cria a JTable com o DefaultTableModel
        tabelaClientes = new JTable(tableModel);

        // Adiciona um JScrollPane para a tabela
        JScrollPane scrollPane = new JScrollPane(tabelaClientes);
        panel1.setLayout(new BorderLayout());
        panel1.add(scrollPane, BorderLayout.CENTER);

        add(panel1);

        setVisible(true);
    }
}

