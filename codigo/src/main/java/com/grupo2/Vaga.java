package com.grupo2;

public class Vaga {
    public String id;
    public boolean disponivel;

    public Vaga(int fila, int num){
        if (num < 10){
            this.id = String.valueOf(fila) + "0" + String.valueOf(num);
        }else{
            this.id = String.valueOf(fila) + String.valueOf(num);
        }

        this.disponivel = true;
    }
    
    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

    public boolean getDisponivel(){
        return this.disponivel;
    }

    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }
}
