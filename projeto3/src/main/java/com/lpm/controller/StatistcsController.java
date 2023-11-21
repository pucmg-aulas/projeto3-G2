package com.lpm.controller;

import com.lpm.model.Estacionamento;
import com.lpm.view.LoadParking;
import com.lpm.view.Statistcs;

public class StatistcsController {
    private final Statistcs view;

    public StatistcsController(Statistcs view) {
        this.view = view;
    }


    public String getStatistcs(Estacionamento estacionamento, int mes){
        return estacionamento.top5Clientes(mes);
    }


}