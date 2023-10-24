import java.util.ArrayList;

public class Cliente {

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(ArrayList<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    private String nome;
    private String id;
    private ArrayList<Veiculo> veiculos;

    public Cliente(String nome, String id){
        this.nome = nome;
        this.id = id; 
    }

    public void addVeiculo(){

    }

    public Veiculo possuiVeiculo(String placa){
        
    }

    public int TotalDeUsos(){

    }

    public double arrecadadoPorVeiculo(String placa){

    }

    public double arrecadadoTotal(){

    }

    public double arrecadadoNoMes(int mes){

    }
}
