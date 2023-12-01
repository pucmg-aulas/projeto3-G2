package com.lpm.model;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

public class Estacionamento implements IEmpacotavel {
    private String nome;
    private ArrayList<Cliente> clientes;
    private ArrayList<Vaga> vagas;
    private int quantFileiras;
    private int vagasPorFileira;

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setVagas(ArrayList<Vaga> vagas) {
        this.vagas = vagas;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Vaga> getVagas() {
        return vagas;
    }

    public int getQuantFileiras() {
        return quantFileiras;
    }

    public int getVagasPorFileira() {
        return vagasPorFileira;
    }

    @Override
    public void gerar() {
        ArrayList<String> estacionamentosExistentes = new ArrayList<String>();
        ArrayList<String> usoDeVagasExistentes = new ArrayList<String>();

        String line;
        String[] data;
        try {
            // Fazendo leitura dos estacionamentos que ja existem

            BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\projeto3\\db\\estacionamentos.csv"));

            while((line = br.readLine()) != null) {
                data = line.split(",");
                if(!data[0].equalsIgnoreCase(this.nome)) {
                    estacionamentosExistentes.add(line);
                }
            }

            br.close();

            // Guardando estacionamentos que ja existem

            Iterator<String> iteratorEstacionamentos = estacionamentosExistentes.iterator();

            BufferedWriter bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\projeto3\\db\\estacionamentos.csv")); // acessando a escrita no arquivo

            bw.write(""); // limpar o arquivo

            bw.close();

            bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\projeto3\\db\\estacionamentos.csv", true));

            while (iteratorEstacionamentos.hasNext()) {
                bw.write(iteratorEstacionamentos.next() + "\n"); // guardando os estacionamentos que ja existem
            }

            // guardando estacionamento atual

            bw.write(this.nome + "," + this.quantFileiras + "," + this.vagasPorFileira);

            Iterator<Vaga> iteratorVagas = this.vagas.iterator();
            Vaga auxVaga;

            while (iteratorVagas.hasNext()) {
                auxVaga = iteratorVagas.next();
                bw.write("," + auxVaga.getId() + "_" + auxVaga.disponivel());
            }

            bw.write("\n");

            bw.close();

            // Gerando Clientes

            bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\projeto3\\db\\clientes.csv")); // acessando a escrita no arquivo

            bw.write(""); // limpar o arquivo

            bw.close();

            bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\projeto3\\db\\clientes.csv", true));

            Iterator<Cliente> iteratorClientes = this.clientes.iterator();
            Cliente auxCliente;

            while (iteratorClientes.hasNext()) {
                auxCliente = iteratorClientes.next();

                bw.write(auxCliente.getNome() + "," + auxCliente.getId() + "\n");
            }

            bw.close();

            // Gerando Veiculos

            bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\projeto3\\db\\veiculos.csv")); // acessando a escrita no arquivo

            bw.write(""); // limpar o arquivo

            bw.close();

            bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\projeto3\\db\\veiculos.csv", true));

            iteratorClientes = this.clientes.iterator();
            Iterator<Veiculo> iteratorVeiculos;

            while (iteratorClientes.hasNext()) {
                auxCliente = iteratorClientes.next();

                if (!auxCliente.getVeiculos().isEmpty()) {
                    bw.write(auxCliente.getId());

                    iteratorVeiculos = auxCliente.getVeiculos().iterator();

                    while (iteratorVeiculos.hasNext()) {
                        bw.write("," + iteratorVeiculos.next().getPlaca());
                    }
                    bw.write("\n");
                }

            }

            bw.close();

            // Gerando UsoDeVagas

            // Fazendo leitura dos usos que ja existem

            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\projeto3\\db\\usoDeVagas.csv"));

            while((line = br.readLine()) != null) {
                data = line.split(",");
                if(!data[0].equalsIgnoreCase(this.nome)) {
                    usoDeVagasExistentes.add(line);
                }
            }

            br.close();

            // Escrevendo usos que ja existem

            bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\projeto3\\db\\usoDeVagas.csv")); // acessando a escrita no arquivo

            bw.write(""); // limpar o arquivo

            bw.close();

            bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\projeto3\\db\\usoDeVagas.csv", true));

            Iterator<String> iteratorUsoDeVagasExistentes = usoDeVagasExistentes.iterator();

            while(iteratorUsoDeVagasExistentes.hasNext()) {
                bw.write(iteratorUsoDeVagasExistentes.next() + "\n"); // guardando os usos que ja existem
            }

            iteratorClientes = this.clientes.iterator();
            Veiculo auxVeiculo;
            UsoDeVaga auxUsoDeVaga;
            Iterator<UsoDeVaga> iteratorUsosDeVaga;
            LocalDateTime auxSaida;

            while (iteratorClientes.hasNext()) {
                auxCliente = iteratorClientes.next();

                if (!auxCliente.getVeiculos().isEmpty()) {
                    iteratorVeiculos = auxCliente.getVeiculos().iterator();

                    while (iteratorVeiculos.hasNext()) {
                        auxVeiculo = iteratorVeiculos.next();
                        iteratorUsosDeVaga = auxVeiculo.getUsos().iterator();
                        
                        while(iteratorUsosDeVaga.hasNext()) {
                            auxUsoDeVaga = iteratorUsosDeVaga.next();
                            auxSaida = auxUsoDeVaga.getSaida();

                            if(auxSaida == null) {
                                bw.write(this.nome + "," + auxUsoDeVaga.getVaga().getId() + "," + auxVeiculo.getPlaca() + "," + auxUsoDeVaga.getEntrada().toString() + ",null\n");
                            } else {
                                bw.write(this.nome + "," + auxUsoDeVaga.getVaga().getId() + "," + auxVeiculo.getPlaca() + "," + auxUsoDeVaga.getEntrada().toString() + "," + auxUsoDeVaga.getSaida().toString() + "\n");
                            }
                        }
                    }
                }
            }

            bw.close();
        } catch (IOException e) {
            throw new Error("Erro: Objeto nao pode ser serializado");
        }
    }

    @Override
    public void ler() {
        String line, line2, line3;
        String[] data, data2, data3, auxSplitVagas;
        boolean auxDisponivel;
        try {
            // Leitura Estacionamento
            BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\projeto3\\db\\estacionamentos.csv"));

            while ((line = br.readLine()) != null) {
                data = line.split(",");

                if (data[0].equalsIgnoreCase(this.nome)) {
                    this.quantFileiras = Integer.parseInt(data[1]);
                    this.vagasPorFileira = Integer.parseInt(data[2]);

                    for (int i = 3; i < data.length; i++) {
                        auxSplitVagas = data[i].split("_");
                        if (auxSplitVagas[1].equalsIgnoreCase("true")) {
                            auxDisponivel = true;
                        } else {
                            auxDisponivel = false;
                        }
                        this.vagas.add(new Vaga(auxSplitVagas[0], auxDisponivel));
                    }
                    br.close();

                    // Leitura Clientes

                    br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\projeto3\\db\\clientes.csv"));
                    BufferedReader br2 = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\projeto3\\db\\veiculos.csv"));
                    BufferedReader br3 = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\projeto3\\db\\usoDeVagas.csv"));
                    ArrayList<Veiculo> auxVeiculos = new ArrayList<Veiculo>();
                    ArrayList<UsoDeVaga> auxUsoDeVagas = new ArrayList<UsoDeVaga>();

                    while ((line = br.readLine()) != null) {
                        data = line.split(",");

                        while ((line2 = br2.readLine()) != null) {
                            data2 = line2.split(",");

                            if (data2[0].equalsIgnoreCase(data[1])) {
                                for (int i = 1; i < data2.length; i++) {
                                    while ((line3 = br3.readLine()) != null) {
                                        data3 = line3.split(",");

                                        if (data3[0].equalsIgnoreCase(this.nome) && data3[2].equalsIgnoreCase(data2[i])) {
                                            if(data3[4].equalsIgnoreCase("null")) {
                                                auxUsoDeVagas.add(new UsoDeVaga(buscarVaga(data3[1]), LocalDateTime.parse(data3[3]), null));
                                            } else {
                                                auxUsoDeVagas.add(new UsoDeVaga(buscarVaga(data3[1]), LocalDateTime.parse(data3[3]), LocalDateTime.parse(data3[4])));
                                            }
                                        }
                                    }
                                    br3.close();
                                    br3 = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\projeto3\\db\\UsoDeVagas.csv"));
                                    auxVeiculos.add(new Veiculo(data2[i], auxUsoDeVagas));
                                    auxUsoDeVagas = new ArrayList<UsoDeVaga>();
                                }
                            }
                        }
                        br2.close();
                        br2 = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\projeto3\\db\\Veiculos.csv"));
                        this.clientes.add(new Cliente(data[1], data[0], auxVeiculos));
                        auxVeiculos = new ArrayList<Veiculo>();
                    }

                    br.close();
                    break;
                }
            }
        } catch (IOException e) {
            throw new Error("Erro: Objeto nao pode ser serializado.\n " + e);
        }
    }

    private Vaga buscarVaga(String id) {
        Iterator<Vaga> iteratorVagas = this.vagas.iterator();
        Vaga auxVaga;

        while (iteratorVagas.hasNext()) {
            auxVaga = iteratorVagas.next();
            if(auxVaga.getId().equalsIgnoreCase(id)) {
                return auxVaga;
            }
        }

        return null;
    }

    public Estacionamento(String nome) {
        this.clientes = new ArrayList<Cliente>();
        this.nome = nome;
        this.quantFileiras = 0;
        this.vagas = new ArrayList<Vaga>();
        this.vagasPorFileira = 0;
    }

    public Estacionamento(String nome, int quantFileiras, int vagasPorFileira) {
        if ((0 < quantFileiras && quantFileiras <= 26) && vagasPorFileira > 0) {
            this.nome = nome;
            this.quantFileiras = quantFileiras;
            this.vagasPorFileira = vagasPorFileira;
            clientes = new ArrayList<Cliente>();
            vagas = new ArrayList<Vaga>();
            gerarVagas();
        } else {
            throw new Error("Erro: dimensoes invalidas");
        }
    }

    // Método para imprimir os clientes cadastrados
    public void printClientes() {
        Iterator<Cliente> iterator = clientes.iterator();
        Cliente aux;
        while (iterator.hasNext()) {
            aux = iterator.next();
            System.out.println("Nome: " + aux.getNome() + "\nID: " + aux.getId() + "\nVeiculos: ");
            aux.printVeiculos();
        }
    }

    public String getNome() {
        return nome;
    }

    // public void addVeiculo(Veiculo veiculo, String idCli) {
    // Iterator<Cliente> iterator = clientes.iterator();
    // Cliente aux;
    //
    // while (iterator.hasNext()) {
    // aux = iterator.next();
    // if (aux.getId().equalsIgnoreCase(idCli)) {
    // aux.addVeiculo(veiculo);
    // break;
    // }
    // }
    //
    // throw new Error("Erro: cliente inexistente");
    // }

    public void addCliente(Cliente cliente) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
        } else {
            throw new Error("Erro: cliente ja cadastrado no estacionamento");
        }
    }

    private void gerarVagas() {
        char fileiraAtual = 'A';
        int numVagaAtual = 1;
        for (int i = 0; i < quantFileiras; i++) {
            for (int j = 0; j < vagasPorFileira; j++) {
                vagas.add(new Vaga(fileiraAtual, numVagaAtual));
                numVagaAtual++;
            }
            fileiraAtual++;
        }
    }

    public Veiculo procurarVeiculo(String placa) {
        Iterator<Cliente> iteratorCliente = clientes.iterator();
        Veiculo veiculo;

        while (iteratorCliente.hasNext()) {
            veiculo = iteratorCliente.next().possuiVeiculo(placa);
            if (veiculo != null) {
                return veiculo;
            }
        }

        return null;
    }

    public void estacionar(String placa, String idVaga) {
        Iterator<Vaga> iteratorVaga = vagas.iterator();
        Vaga auxVaga;

        Veiculo veiculo = procurarVeiculo(placa);

        if (veiculo != null) {
            while (iteratorVaga.hasNext()) {
                auxVaga = iteratorVaga.next();
                if (auxVaga.getId() == idVaga) {
                    veiculo.estacionar(auxVaga);
                    break;
                }
            }
        } else {
            throw new Error("Erro: veiculo nao encontrado");
        }
    }

    public void sair(String placa) {
        ArrayList<UsoDeVaga> usos = procurarVeiculo(placa).getUsos();
        int indexUso = usos.size() - 1;
        UsoDeVaga usoAtual = usos.get(indexUso);

        Iterator<Vaga> iterator = vagas.iterator();
        Vaga aux;
        while (iterator.hasNext()) {
            aux = iterator.next();
            if (aux.getId() == usoAtual.getVaga().getId()) {
                usoAtual.sair();
                usos.set(indexUso, usoAtual);
                aux.sair();
                return;
            }
        }

        throw new Error("Erro: vaga nao foi liberada / carro nao encontrado");
    }

    public double totalArrecadado() {
        Iterator<Cliente> iterator = clientes.iterator();
        double result = 0.0;

        while (iterator.hasNext()) {
            result = result + iterator.next().arrecadadoTotal();
        }

        return result;
    }

    public double arrecadacaoNoMes(int mes) {
        Iterator<Cliente> iterator = clientes.iterator();
        double result = 0.0;

        while (iterator.hasNext()) {
            result = result + iterator.next().arrecadadoNoMes(mes);
        }

        return result;
    }

    public double valorMedioPorUso() {
        Iterator<Cliente> iterator = clientes.iterator();
        int totalUsos = 0;

        while (iterator.hasNext()) {
            totalUsos = totalUsos + iterator.next().totalDeUsos();
        }

        return (totalArrecadado() / totalUsos);
    }

    public String top5Clientes(int mes) {
        ArrayList<Cliente> copiaClientes = clientes;
        int tamClientes = copiaClientes.size(), i = 0;
        double tempValor;
        Cliente tempCliente;
        String result = "";

        if (tamClientes >= 5) {
            Iterator<Cliente> iterator = copiaClientes.iterator();
            double[] aux = new double[tamClientes];

            while (iterator.hasNext()) {
                aux[i] = iterator.next().arrecadadoNoMes(mes);
                i++;
            }

            i = 0;

            while(i < (tamClientes-1)) {
                if (aux[i] < aux[i + 1]) {
                    tempValor = aux[i];
                    tempCliente = copiaClientes.get(i);
                    aux[i] = aux[i + 1];
                    copiaClientes.set(i, copiaClientes.get(i + 1));
                    aux[i + 1] = tempValor;
                    copiaClientes.set(i + 1, tempCliente);
                    i = 0;
                } else {
                    i++;
                }
            }

            for (i = 0; i < 5; i++) {
                result = result.concat("\n-" + copiaClientes.get(i).getNome() + " R$" + aux[i]);
            }

            return result;

        } else {
            throw new Error("Erro: E necessario ter 5 ou mais clientes para utilizar essa funcao");
        }
    }
}
