package com.lpm.controller;

import com.lpm.model.Estacionamento;

public class Main {

    public static void main(String[] args) {
        // pegar nome do estacionamento da tela

        String nomeLido = "NomeLido";

        Estacionamento estacionamentoAtual = new Estacionamento(nomeLido);

        estacionamentoAtual.ler();
    }
}
