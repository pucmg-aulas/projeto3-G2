package com.lpm.controller;

import com.lpm.model.Estacionamento;
import com.lpm.view.LoadParking;

public class LoadParkingController {
    private final LoadParking view;

    public LoadParkingController(LoadParking view) {
        this.view = view;
    }

    public Estacionamento carregarEstacionamento() {
        String nome = view.getTextField1().getText();

        Estacionamento estacionamentoAtual = new Estacionamento(nome);

        estacionamentoAtual.ler();

        view.exibeMensagem(nome + " lido com sucesso!\n");

        return estacionamentoAtual;
    }


}
