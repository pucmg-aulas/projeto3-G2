package com.lpm.controller;

import com.lpm.model.Cliente;
import com.lpm.model.Estacionamento;
import com.lpm.view.ListClient;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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

        while(iteratorClientes.hasNext()) {
            auxCliente = iteratorClientes.next();

            tableModel.addRow(new Object[]{auxCliente.getNome(), auxCliente.getId(), "botao veiuclos"});
        }
    }
}
