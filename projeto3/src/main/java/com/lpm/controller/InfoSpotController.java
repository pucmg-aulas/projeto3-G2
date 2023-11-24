package com.lpm.controller;

import com.lpm.model.Estacionamento;
import com.lpm.view.InfoSpot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InfoSpotController {
    InfoSpot view;
    Estacionamento estacionamentoAtual;
    String idVeiculo;
    String entrada;
    String idVaga;

    public String getIdVeiculo() {
        return idVeiculo;
    }

    public String getEntrada() {
        return entrada;
    }

    public InfoSpotController(InfoSpot view, Estacionamento estacionamentoAtual, String idVaga) {
        this.view = view; this.estacionamentoAtual = estacionamentoAtual; this.idVaga = idVaga;
    }

    public void buscarDadosUsoAtual() {
        String line;
        String[] data;
        try {
            BufferedReader  br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\projeto3\\db\\usoDeVagas.csv"));

            while((line = br.readLine()) != null) {
                data = line.split(",");
                if(data[0].equalsIgnoreCase(this.estacionamentoAtual.getNome()) && data[1].equalsIgnoreCase(this.idVaga) && data[4].equalsIgnoreCase("null")) {
                    this.idVeiculo = data[2];
                    this.entrada = data[3];
                    br.close();
                    break;
                }
            }
        } catch(IOException e) {
            throw new Error("Erro: nao foi possivel encontrar os dados do uso da vaga!");
        }
    }

    public void registrarSaida() {
        double aPagar;
        aPagar = estacionamentoAtual.procurarVeiculo(idVeiculo).sair();

        view.exibeMensagem("Vaga liberada! Faça a cobrança de R$" + aPagar + " ao cliente");

        estacionamentoAtual.gerar();
    }
}
