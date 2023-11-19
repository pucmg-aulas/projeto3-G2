package com.lpm.view;

import com.lpm.model.Estacionamento;

import javax.swing.*;
import java.awt.*;

public class ClientsList extends JFrame {
    private JPanel panel1;
    private JTable tabelaClientes;

    public ClientsList(Estacionamento estacionamentoAtual) {
        setTitle("Xulambs Parking");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Adiciona um JScrollPane para a tabela
        JScrollPane scrollPane = new JScrollPane(tabelaClientes);
        panel1.setLayout(new BorderLayout());
        panel1.add(scrollPane, BorderLayout.CENTER);

        add(panel1);

        setVisible(true);
    }
}
