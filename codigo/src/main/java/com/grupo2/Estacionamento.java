package com.grupo2;

import java.util.ArrayList;

public class Estacionamento {
    private String nome;
    private ArrayList<Cliente> id;
    private ArrayList<Vaga> vagas;
    private int quantFileiras;
    private int vagasPorFileira;

    public Estacionamento(String nome, int quantFileiras, int vagasPorFileira) {
        this.nome = nome;
        this.quantFileiras = quantFileiras;
        this.vagasPorFileira = vagasPorFileira;

        id = new ArrayList<Cliente>();
        vagas = new ArrayList<Vaga>();
    }

    public void addVeiculo(Veiculo veiculo, String idCli) throws Exception {
        if()
    }

    public void addCliente(Cliente cliente) {}

    private void gerarVagas() {}

    public void estacionar(String placa) {}

    public void sair(String placa) {}

    public double totalArrecadado() {}

    public double arrecadacaoNoMes() {}

    public double valorMedioPorUso() {}

    public String top5Clientes(int mes) {}
}
