package com.grupo2;

import java.time.LocalDateTime;

public class UsoDeVaga {
    private static double FRACAO_USO = 0.25;
    private static double VALOR_FRACAO = 4.0;
    private static double VALOR_MAXIMO = 50.0;
    private Vaga vaga;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private double valorPago;

    public LocalDateTime getEntrada(){
        return this.entrada;
    }

    public void setEntrada(LocalDateTime entrada){
        this.entrada = entrada;
    }

    public LocalDateTime getSaida(){
        return this.saida;
    }

    public void setSaida(LocalDateTime saida){
        this.saida = saida;
    }
    
    public double getValorPago(){
        return this.valorPago;
    }

    public void setValorPago(double valorPago){
        this.valorPago = valorPago;
    }
}
