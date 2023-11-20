package com.lpm.controller;

import com.lpm.model.Estacionamento;
import com.lpm.model.Vaga;
import com.lpm.view.RegisterSpot;

public class RegisterSpotController {
    private RegisterSpot view;
    private Estacionamento estacionamentoAtual;

    public RegisterSpotController(RegisterSpot view, Estacionamento estacionamentoAtual) {
        this.view = view;
        this.estacionamentoAtual = estacionamentoAtual;
    }

    public void registrar(Vaga vaga, String placa) {
        vaga.estacionar();
        estacionamentoAtual.estacionar(placa);


    }
}
