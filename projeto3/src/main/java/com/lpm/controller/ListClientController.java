package com.lpm.controller;

import com.lpm.model.Cliente;
import com.lpm.model.Estacionamento;
import com.lpm.view.ListClient;
import com.lpm.view.ListVehicles;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class ListClientController {
    private ListClient view;
    private Estacionamento estacionamentoAtual;

    public ListClientController(ListClient view, Estacionamento estacionamentoAtual) {
        this.view = view; this.estacionamentoAtual = estacionamentoAtual;
    }

    public void popularTabela(DefaultTableModel tableModel) {
        Iterator<Cliente> iteratorClientes = estacionamentoAtual.getClientes().iterator();
        Cliente auxCliente;
        int counterRow = 0;

        while(iteratorClientes.hasNext()) {
            auxCliente = iteratorClientes.next();

            tableModel.addRow(new Object[]{auxCliente.getNome(), auxCliente.getId()});
            tableModel.setValueAt(construirBotaoVeiculos(auxCliente), counterRow, 2);
            counterRow++;
        }
    }

    private JButton construirBotaoVeiculos(Cliente cliente) {
        JButton btnVeiculos = new JButton("Acessar");
        btnVeiculos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                new ListVehicles(estacionamentoAtual, cliente).setVisible(true);
            }
        });

        return btnVeiculos;
    }
}
