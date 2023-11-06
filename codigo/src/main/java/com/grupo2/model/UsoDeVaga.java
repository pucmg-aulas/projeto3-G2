package com.grupo2.model;

import java.time.LocalDateTime;

public class UsoDeVaga implements IEstaciona{
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

    public double sair(){
        Duration diferenca = Duration.between(this.entrada, this.saida);
        long diferencaSegundos = diferenca.getSeconds(); 
        double diferencaMinutos = (double) segundos / 60.0;
        return diferencaMinutos;
    }

    public double valorPago() {
        double tempo = sair();
        double valorPago = (tempo / 15) * 4;
        setValorPago(valorPago);
        return valorPago;
    }
}

