package main.java.com.grupo2;

public class Estacionamento {
    private String nome;
    private Cliente[] id;
    private Vaga[] vagas;
    private int quantFileiras;
    private int vagasPorFileira;

    public Estacionamento(String nome, int fileiras, int vagasPorFileira) {}

    public void addVeiculo(Veiculo veiculo, String idCli) {}

    public void addCliente(Cliente cliente) {}

    private void gerarVagas() {}

    public void estacionar(String placa) {}

    public void sair(String placa) {}

    public double totalArrecadado() {}

    public double arrecadacaoNoMes() {}

    public double valorMedioPorUso() {}

    public String top5Clientes(int mes) {}
}
