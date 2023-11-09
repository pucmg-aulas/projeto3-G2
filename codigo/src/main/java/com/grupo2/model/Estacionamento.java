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

    public void setNome(String nome){
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

        for(Cliente cliente: id){
            if(cliente.getId().equals(idCl)){
                cliente.addVeiculo(veiculo);
            }
        }
    }

    public void addCliente(Cliente cliente){
        id.add(cliente);
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
    */

    // public String top5Clientes(int mes){
    //     Cliente[] top5 = new Cliente[5];
    //     Cliente quinto, quarto, terceiro, segundo, primeiro;
    //     quinto = id.get(0);
    //     quarto = id.get(0);
    //     terceiro = id.get(0);
    //     segundo = id.get(0);
    //     primeiro = id.get(0);

    //     for(int i = 0; i < id.size(); i++){
    //         if(id.get(i).arrecadadoNoMes(mes) > quinto.arrecadadoNoMes(mes)){
    //             if(id.get(i).arrecadadoNoMes(mes) > quarto.arrecadadoNoMes(mes)){

    //             }else{
    //                 quinto = id.get(i); 
    //             }
    //         }

    //         }

    //     }
    // }

    @Override
    public double arrecadadoNoMes(int mes){
        
        double valorArrecadado = 0;
        for(Cliente cliente: id){
            valorArrecadado += cliente.arrecadadoNoMes(mes);
        }

        return valorArrecadado;
    }

    @Override
    public double totalArrecadado(){
       double valorArrecadado = 0;
        for(Cliente cliente: id){
            valorArrecadado += cliente.totalArrecadado();
        }

        return valorArrecadado;
    }
    
}
