package com.grupo2.model;

public class Vaga implements IEstaciona{
    private String id;
    private boolean disponivel;

    /**
     * Construtor da classe Vaga que inicializa uma vaga com base na fila e no número fornecidos e os 
     * formata de acordo com os parametros indicados para formar o id.
     * 
     * @param fila O número da fila da vaga.
     * @param num O número da vaga.
     */
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


    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }

    /**
     * Tenta estacionar um veículo na vaga, tornando-a indisponível.
     *
     * @return true se o veículo foi estacionado com sucesso (a vaga estava disponível), false caso contrário.
     */

    @Override
    public boolean estacionar(){
        if (disponivel() == true){
            setDisponivel(false);
            return true;
        }else{
            return false;
        }
        
    }

    /**
     * Faz o veículo sair do estacionamento, tornando-o disponível.
     *
     * @return true se o veículo saiu com sucesso do estacionamento e agora está disponível, false caso contrário.
     */
    @Override
    public boolean sair(){
        //retorna se a operação foi realizada ou não e muda o disponivel
        return true;
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
