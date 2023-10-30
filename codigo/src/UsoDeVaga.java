public class UsoDeVaga {
    static double FRACAO_USO = 0.25;
    static double VALOR_FRACAO = 4.0;
    static double VALOR_MAXIMO = 50.0;
    private Vaga vaga;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private double valorPago;

    public UsoDeVaga(Vaga vaga, LocalDateTime entrada, LocalDateTime saida, double valorPago){
        this.vaga = vaga;
        this.entrada = entrada;
        this.saida = saida;
        this.valorPago = valorPago;
    }
}
