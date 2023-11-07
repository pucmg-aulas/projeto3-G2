package com.grupo2.model;

/**
 * A interface IRelatorio define métodos para gerar relatórios de arrecadação.
 */
public interface IRelatorio {
    double arrecadadoNoMes(int mes);
    double totalArrecadado();
}
