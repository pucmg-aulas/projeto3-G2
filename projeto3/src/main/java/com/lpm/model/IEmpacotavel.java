package com.lpm.model;

import java.util.ArrayList;

public interface IEmpacotavel<T> {
    
    public void gerar(ArrayList<T> leituraAtual);

    public ArrayList<T> ler();
}
