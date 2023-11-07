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

    public UsoDeVaga(Vaga vaga, LocalDateTime entrada) {
        this.vaga = vaga;
        this.entrada = entrada;
        this.saida = null; 
        this.valorPago = 0.0; 
    }

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

    /**
     * Calcula o tempo, em minutos, decorrido desde a entrada até a saída do veículo.
     *
     * @return O tempo, em minutos, decorrido desde a entrada até a saída do veículo.
     */
    @Override
    public double sair(){
        Duration diferenca = Duration.between(this.entrada, this.saida);
        long diferencaSegundos = diferenca.getSeconds(); 
        double diferencaMinutos = (double) segundos / 60.0;
        return diferencaMinutos;
    }

    /**
     * Calcula o valor a ser pago com base no tempo decorrido e na taxa de estacionamento.
     *
     * @return O valor a ser pago pelo estacionamento do veículo.
     */
    @Override
    public double valorPago() {
        double tempo = sair();
        double valorPago = (tempo / 15) * 4;
        setValorPago(valorPago);
        return valorPago;
    }
}

