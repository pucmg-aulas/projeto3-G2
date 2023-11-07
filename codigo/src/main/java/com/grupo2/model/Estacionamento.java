package com.grupo2.model;

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
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String Nome){
        this.nome = nome;
    }

    public int getQuantFileiras(){
        return this.quantFileiras;
    }

    public void setQuantFileiras(int quantFileiras){
        this.quantFileiras = quantFileiras;
    }

    public int getVagasPorFileira(){
        return this.vagasPorFileira;
    }

    public void setVagasPorFileira(int vagasPorFileira){
        this.vagasPorFileira = vagasPorFileira;
    }

    public void addVeiculo(Veiculo veiculo, String idCl){

    }

    public void addCliente(Cliente cliente){

    }

    /**
     * Gera vagas para o estacionamento com base na quantidade de fileiras e vagas por fileira.
     * Esta função cria e inicializa uma lista de vagas com base nos parâmetros do estacionamento.
     */
    private void gerarVagas(){
        int quantVagas = getQuantFileiras()*getVagasPorFileira();
        ArrayList<Vaga> vagas = new ArrayList<Vaga>(quantVagas);  
    }

    public void estacionar(String placa){

    }

    /*
    public double sair(String placa){

    } 
    
    public double valorMedioPorUso(){

    }

    public String top5Clientes(int mes){
        
    }
    
    */

    @Override
    public double arrecadadoNoMes(int mes){

    }

    @Override
    public double totalArrecadado(){
        
    }
    
}
