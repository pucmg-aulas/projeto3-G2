public class Estacionamento {
    private String nome;
    private Cliente id[];
    private Vaga vagas[];
    private int quantFileiras, vagasPorFileira;

    public Estacionamento(String nome, Cliente id[], Vaga vagas[], int quantFileiras, int vagasPorFileira){
        this.nome = nome;
        this.id = id;
        this.vagas = vagas;
        this.quantFileiras = quantFileiras;
        this.vagasPorFileira = vagasPorFileira;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getQuantFileiras(){
        return this.quantFileiras;
    }

    public void setQuantFileiras(int quantFileiras){
        this.quantFileiras = quantFileiras;
    }

    public int getVagasPorFileiras(){
        return this.vagasPorFileira;
    }

    public void setVagasPorFileira(int vagasPorFileira){
        this.vagasPorFileira = vagasPorFileira;
    }
    
}
