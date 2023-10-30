package com.grupo2;

public class Cliente {
    private String nome;
    private String id;
    private Veiculo veiculos[];

    public Cliente(String nome, String id, Veiculo veiculos[]){
        this.nome = nome;
        this.id = id;
        this.veiculos = veiculos;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

}
