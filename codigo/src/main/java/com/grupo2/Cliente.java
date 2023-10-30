package com.grupo2;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String id;
    private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

    public Cliente(String nome, String id){
        this.nome = nome;
        this.id = id;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

    public void addVeiculo(Veiculo veiculo){
        veiculos.add(veiculo);
    }

    public Veiculo possuiVeiculo(String placa){

        for(int i = 0; i < veiculos.size(); i++){
            if(veiculos.get(i).getPlaca().equals(placa)){
                return veiculos.get(i);
            }
        }

        return null;
    }

    public int totalDeUsos(){
        int usos = 0;

        for(int i = 0; i < veiculos.size(); i++){
            usos = veiculos.get(i).getUsos().size(); 
        }

        return usos;
    }

    public double arrecadadoPorVeiculo(String placa){

        Veiculo veiculo = possuiVeiculo(placa);
        return veiculo.totalArrecadado();
    }

    public double arrecadadoTotal(){

        double valorArrecadado = 0;

        for(int i = 0; i < veiculos.size(); i++){
            valorArrecadado = veiculos.get(i).totalArrecadado();
        }

        return valorArrecadado;
    }

    public double arrecadadoNoMes(int mes){
        double valorArrecadado = 0;

        for(int i = 0; i < veiculos.size(); i++){
            valorArrecadado = veiculos.get(i).arrecadadoNoMes(mes);
        }

        return valorArrecadado;
    }
}
