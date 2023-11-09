package com.grupo2.model;

import java.util.ArrayList;

public class Veiculo implements IRelatorio, IEstaciona {
    private String placa;
    private ArrayList<UsoDeVaga> usos = new ArrayList<UsoDeVaga>();

    public Veiculo(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public ArrayList<UsoDeVaga> getUsos() {
        return usos;
    }

    public void setUsos(ArrayList<UsoDeVaga> usos) {
        this.usos = usos;
    }

    /**
     * Obtém o número total de usos registrados para cada veículo no vetor de usos.
     *
     * @return O número total de usos registrados para a vaga.
     */
    public int totalDeUsos() {
        return getUsos().size();
    }

    @Override
    public void estacionar() {

    }

    @Override
    public double sair() {

    }

    @Override
    public double totalArrecadado() {
        
    }

    @Override
    public double arrecadadoNoMes(int mes) {

    }

    
}
