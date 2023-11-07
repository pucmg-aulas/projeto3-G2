package com.grupo2.model;

public class Vaga implements IEstaciona{
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

    /**
     * Estaciona o veículo, tornando-o indisponível.
     *
     * @return true se o veículo foi estacionado com sucesso e agora está indisponível, false caso contrário.
     */
    @Override
    public boolean estacionar(){
        return setDisponivel(false);
    }

    /**
     * Faz o veículo sair do estacionamento, tornando-o disponível.
     *
     * @return true se o veículo saiu com sucesso do estacionamento e agora está disponível, false caso contrário.
     */
    @Override
    public boolean sair(){
        return setDisponivel(true);
    }

    /**
     * Verifica se o veículo está disponível.
     *
     * @return true se o veículo está disponível, false caso contrário.
     */
    public boolean disponivel(){
        return this.disponivel;
    }
}
