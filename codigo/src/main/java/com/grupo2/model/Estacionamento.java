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

    } */
    
    public double valorMedioPorUso() {
        double valor = totalArrecadado();
        int usos = 0;

        for(Cliente cliente: id){
            usos += cliente.totalDeUsos();
        }

        return valor/usos;
    }
    

    public String top5Clientes(int mes){
        Cliente quinto = id.get(0);
        Cliente quarto = id.get(0);
        Cliente terceiro = id.get(0);
        Cliente segundo = id.get(0);
        Cliente primeiro = id.get(0);

        for(int i = 0; i < id.size(); i++){
            if(id.get(i).arrecadadoNoMes(mes) > quinto.arrecadadoNoMes(mes)){
                if(id.get(i).arrecadadoNoMes(mes) > quarto.arrecadadoNoMes(mes)){
                    if(id.get(i).arrecadadoNoMes(mes) > terceiro.arrecadadoNoMes(mes)){
                        if(id.get(i).arrecadadoNoMes(mes) > segundo.arrecadadoNoMes(mes)){
                            if(id.get(i).arrecadadoNoMes(mes) > primeiro.arrecadadoNoMes(mes) ){
                                primeiro = id.get(i);
                            }
                        }
                        else{
                            segundo = id.get(i);
                        }
                    }else{
                        terceiro = id.get(i);
                    }
                }else{
                    quinto = id.get(i); 
                }
            }

            }
            
            String top5 = "1- " + primeiro.getNome();

            return top5;
    }

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
