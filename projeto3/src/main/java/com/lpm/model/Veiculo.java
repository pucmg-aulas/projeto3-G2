package com.lpm.model;

import java.time.Month;
import java.util.ArrayList;
import java.util.Iterator;

public class Veiculo {
    private String placa;
    private ArrayList<UsoDeVaga> usos;

    public String getPlaca() {
        return placa;
    }

    public ArrayList<UsoDeVaga> getUsos() {
        return usos;
    }

    public Veiculo(String placa) {
        this.placa = placa;
        usos = new ArrayList<UsoDeVaga>();
    }

    public void estacionar(Vaga vaga) {
        try {
            UsoDeVaga registroUso = new UsoDeVaga(vaga);
            usos.add(registroUso);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double sair() {
        UsoDeVaga registroUso = usos.get(usos.size()-1);

        registroUso.sair();

        return registroUso.valorPago();
    }

    public double totalArrecadado() {
        Iterator<UsoDeVaga> iterator = usos.iterator();
        double result = 0.0;

        while(iterator.hasNext()) {
            result = result + iterator.next().valorPago();
        }

        return result;
    }

    public double arrecadadoNoMes(int mes) {
        Iterator<UsoDeVaga> iterator = usos.iterator();
        double result = 0.0;
        UsoDeVaga aux;

        while(iterator.hasNext()) {
            aux = iterator.next();
            if(Month.from(aux.getEntrada()).getValue() == mes) {
                result = result + aux.valorPago();
            }
        }

        return result;
    }

    public int totalDeUsos() {
        return usos.size();
    }
}