package com.lpm.controller;

import com.lpm.model.Estacionamento;
import com.lpm.model.Vaga;
import com.lpm.view.RegisterSpot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RegisterSpotController {
    private RegisterSpot view;
    private Estacionamento estacionamentoAtual;

    public RegisterSpotController(RegisterSpot view, Estacionamento estacionamentoAtual) {
        this.view = view;
        this.estacionamentoAtual = estacionamentoAtual;
    }

    public boolean registrar(String placa, String idVaga) {
        if(!estaEstacionado(placa)) {
            estacionamentoAtual.estacionar(placa, idVaga);
            estacionamentoAtual.gerar();
            return true;
        } else {
            view.exibeMensagem("Erro: Veículo já se encontra estacionado. Tente novamente!");
            view.getTextFieldPlaca().setText("");
            return false;
        }

    }

    private boolean estaEstacionado(String placa) {
        String line;
        String[] data;
        try {
            BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\projeto3\\db\\usoDeVagas.csv"));

            while((line = br.readLine()) != null) {
                data = line.split(",");
                if(data[2].equalsIgnoreCase(placa)) {
                    return true;
                }
            }
        } catch(IOException e) {
            throw new Error("Erro: nao foi possivel verificar se o veiculo ja esta estacionado. Tente novamente!");
        }
        return false;
    }
}
