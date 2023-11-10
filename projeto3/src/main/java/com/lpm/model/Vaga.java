package com.lpm.model;

public class Vaga {
    private String id;
    private boolean disponivel;

    public Vaga(char fila, int numero) {
        if (('A' <= fila && fila <= 'Z') && ('a' <= fila && fila <= 'z') && (numero > 0)) {
            id = String.valueOf(fila) + String.valueOf(numero);
        } else {
            throw new Error("Erro: posicoes incorretas");
        }
    }

    public String getId() {
        return id;
    }

    public boolean estacionar() {
        if (disponivel) {
            disponivel = false;
            return true;
        } else {
            return false;
        }
    }

    public boolean sair() {
        disponivel = true;
        return true;
    }

    public boolean disponivel() {
        return disponivel;
    }
}