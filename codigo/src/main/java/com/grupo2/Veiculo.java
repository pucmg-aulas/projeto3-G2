package com.grupo2;

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

    public void estacionar() {

    }

    public double sair() {

    }

    public double totalArrecadado() {

    }

    public double arrecadadoNoMes(int mes) {

    }

    public int totalDeUsos() {

    }
}
