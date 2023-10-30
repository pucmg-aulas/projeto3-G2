import java.util.ArrayList;

public class Veiculo {
    private String placa;
    private ArrayList<UsoDeVaga> usos = new ArrayList<UsoDeVaga>();

    public Veiculo(String placa){
        this.placa = placa;
    }

    

    public String getPlaca() {
        return placa;
    }



    public void setPlaca(String placa) {
        this.placa = placa;
    }



    public ArrayList<UsoDeVaga> getUsos() {
        return usos;
    }



    public void setUsos(ArrayList<UsoDeVaga> usos) {
        this.usos = usos;
    }



    public void estacionar(){

    }

    public double sair(){

    }

    public double totalArrecadado(){

    }

    public double arrecadadoNoMes(){

    }

    public int totalDeUsos(){

    }
}
