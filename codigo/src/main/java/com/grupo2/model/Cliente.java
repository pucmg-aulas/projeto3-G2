package com.grupo2.model;

import java.util.ArrayList;

public class Cliente implements IRelatorio{
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

    public ArrayList<Veiculo> getVeiculos(){
        return veiculos;
    }

    public void addVeiculo(Veiculo veiculo){
        veiculos.add(veiculo); 
    }

    /**
     * Verifica se o sistema possui um veículo com a placa especificada.
     *
     * @param placa A placa do veículo a ser verificado.
     * @return O objeto Veiculo correspondente à placa especificada, se encontrado, ou null caso contrário.
     */
    public Veiculo possuiVeiculo(String placa){
        for(int i = 0; i < veiculos.size(); i++){
            if(veiculos.get(i).getPlaca().equals(placa)){
                return veiculos.get(i);
            }
        }
        return null;
    }

    /**
     * Calcula o total de usos de todos os veículos no sistema.
     *
     * @return O número total de usos de todos os veículos.
     */
    public int totalDeUsos() {
        int usos = 0;
        for (Veiculo veiculo : this.veiculos) {
            usos += veiculo.totalDeUsos();
        }
        return usos;
    }

    public double arrecadadoPorVeiculo(String placa){
        // avaliar
        Veiculo veiculo = possuiVeiculo(placa);
        return veiculo.totalArrecadado();
    }

    @Override
    public double totalArrecadado(){
        // avaliar
        double valorArrecadado = 0;

        for(int i = 0; i < veiculos.size(); i++){
            valorArrecadado = veiculos.get(i).totalArrecadado();
        }

        return valorArrecadado;
    }

    @Override
    public double arrecadadoNoMes(int mes){
        //avaliar
        double valorArrecadado = 0;
        for(int i = 0; i < veiculos.size(); i++){
            valorArrecadado = veiculos.get(i).arrecadadoNoMes(mes);
        }

        return valorArrecadado;
    }

}
