package com.lpm.controller;

import com.lpm.model.Estacionamento;
import com.lpm.view.LoadParking;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoadParkingController {
    private final LoadParking view;

    public LoadParkingController(LoadParking view) {
        this.view = view;
    }

    public Estacionamento carregarEstacionamento() {
        String nome = view.getComboBoxEstacionamentos().getSelectedItem().toString();

        if(nome != null) {
            Estacionamento estacionamentoAtual = new Estacionamento(nome);

            estacionamentoAtual.ler();

            view.exibeMensagem(nome + " lido com sucesso!\n");

            return estacionamentoAtual;
        } else {
            throw new Error("Erro: selecao invalida!");
        }
    }

    public void carregarComboBox() {
        String line;
        String[] data;
        JComboBox aux = view.getComboBoxEstacionamentos();

        try {
            BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\projeto3\\db\\estacionamentos.csv"));

            while((line = br.readLine()) != null) {
                data = line.split(",");
                aux.addItem(data[0]);
            }

            view.setComboBoxEstacionamentos(aux);

        } catch (IOException e) {
            throw new Error("Erro: impossivel carregar opcoes de estacionamento");
        }
    }
}
