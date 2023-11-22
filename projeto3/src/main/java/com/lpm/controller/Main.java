package com.lpm.controller;

import java.util.ArrayList;

import com.lpm.model.*;

public class Main {

    public static void main(String[] args) {
        // pegar nome do estacionamento da tela

        String nomeLido = "xulambs1";

        Estacionamento estacionamentoAtual = new Estacionamento(nomeLido);

        estacionamentoAtual.printClientes();

        ArrayList<Veiculo> veiculosJohn = new ArrayList<Veiculo>();
        veiculosJohn.add(new Veiculo("NER-9416"));

        estacionamentoAtual.addCliente(new Cliente("03", "John Doe", veiculosJohn));

        estacionamentoAtual.gerar();
    }
}
