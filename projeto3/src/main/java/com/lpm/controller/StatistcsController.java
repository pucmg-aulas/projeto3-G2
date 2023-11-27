package com.lpm.controller;

import com.lpm.model.Estacionamento;
import com.lpm.view.LoadParking;
import com.lpm.view.Statistcs;

public class StatistcsController {
    private final Statistcs view;
    private Estacionamento estacionamentoAtual;

    public StatistcsController(Statistcs view, Estacionamento estacionamentoAtual) {
        this.view = view; this.estacionamentoAtual = estacionamentoAtual;
    }

    public void recuperarEstatisticas(String mes) {
        switch (mes) {
            case "Tudo": view.getTextAreaEstatisticas().setText(""); break;
            case "Janeiro": view.getTextAreaEstatisticas().setText(getArrecadacaoMes(1) + "\n\n" + getTop5Mes(1));
            case "Fevereiro": view.getTextAreaEstatisticas().setText(getArrecadacaoMes(2) + "\n\n" + getTop5Mes(2));
            case "Março": view.getTextAreaEstatisticas().setText(getArrecadacaoMes(3) + "\n\n" + getTop5Mes(3));
            case "Abril": view.getTextAreaEstatisticas().setText(getArrecadacaoMes(4) + "\n\n" + getTop5Mes(4));
            case "Maio": view.getTextAreaEstatisticas().setText(getArrecadacaoMes(5) + "\n\n" + getTop5Mes(5));
            case "Junho": view.getTextAreaEstatisticas().setText(getArrecadacaoMes(6) + "\n\n" + getTop5Mes(6));
            case "Julho": view.getTextAreaEstatisticas().setText(getArrecadacaoMes(7) + "\n\n" + getTop5Mes(7));
            case "Agosto": view.getTextAreaEstatisticas().setText(getArrecadacaoMes(8) + "\n\n" + getTop5Mes(8));
            case "Setembro": view.getTextAreaEstatisticas().setText(getArrecadacaoMes(9) + "\n\n" + getTop5Mes(9));
            case "Outubro": view.getTextAreaEstatisticas().setText(getArrecadacaoMes(10) + "\n\n" + getTop5Mes(10));
            case "Novembro": view.getTextAreaEstatisticas().setText(getArrecadacaoMes(11) + "\n\n" + getTop5Mes(11));
            case "Dezembro": view.getTextAreaEstatisticas().setText(getArrecadacaoMes(12) + "\n\n" + getTop5Mes(12));
        }
    }

    private String getArrecadacaoMes(int mes) {
        return "Total arrecadado: " + estacionamentoAtual.arrecadacaoNoMes(mes);
    }

    private String getTop5Mes(int mes) {
        return "Top 5 Clientes:\n" + estacionamentoAtual.top5Clientes(mes);
    }
}