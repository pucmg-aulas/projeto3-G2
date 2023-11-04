package com.grupo2;

import java.util.ArrayList;

public class Estacionamento implements IRelatorio {
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

    public String getNome(){
        return this.nome;
    }

    public void setNome(String Nome){
        this.nome = nome;
    }
    public void addVeiculo(Veiculo veiculo, String idCl){

    }

    public void addCliente(Cliente cliente){

    }

    private void gerarVagas(){
        int quantVagas = 
        vagas = new ArrayList<Vaga>();  
    }
}
