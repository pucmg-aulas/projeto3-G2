package com.lpm.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Estacionamento implements Serializable,  IEmpacotavel {
    private String nome;
    private ArrayList<Cliente> clientes;
    private ArrayList<Vaga> vagas;
    private int quantFileiras;
    private int vagasPorFileira;

    @Override
    public void gerar() {
        try {
            File arq = new File(".\\db\\" + nome + ".ser"); // definindo caminho do arquivo

            if(arq.exists()) arq.delete();

            arq.createNewFile();

            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq)); // criando saida do objeto
            objOutput.writeObject(this);
            objOutput.close();
        } catch (IOException e) {
            throw new Error("Erro: Objeto nao pode ser serializado");
        }
    }

    @Override
    public void ler() {
        Estacionamento result;
        try {
            File arq = new File(".\\db\\Estacionamento" + nome + ".ser"); // definindo caminho do arquivo

            if(arq.exists()) {
                ObjectInputStream objOutput = new ObjectInputStream(new FileInputStream(arq));
                
                try {
                    result = (Estacionamento) objOutput.readObject();

                    this.clientes = result.clientes;
                    this.nome = result.nome;
                    this.quantFileiras = result.quantFileiras;
                    this.vagas = result.vagas;
                    this.vagasPorFileira = result.vagasPorFileira;
                    gerarVagas();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                
                objOutput.close();
            }
        } catch (IOException e) {
            throw new Error("Erro: Objeto nao pode ser serializado.\n");
        }
    }

    public Estacionamento() {
        this.clientes = new ArrayList<Cliente>();
        this.nome = null;
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

//    Método para imprimir os clientes cadastrados
    public void printClientes() {
        Iterator<Cliente> iterator = clientes.iterator();
        Cliente aux;
        while(iterator.hasNext()) {
            aux = iterator.next();
            System.out.println("Nome: " + aux.getNome() + "\nID: " + aux.getId() + "\nVeiculos: ");
            aux.printVeiculos();
        }
    }

    public String getNome() {
        return nome;
    }

//    public void addVeiculo(Veiculo veiculo, String idCli) {
//        Iterator<Cliente> iterator = clientes.iterator();
//        Cliente aux;
//
//        while (iterator.hasNext()) {
//            aux = iterator.next();
//            if (aux.getId().equalsIgnoreCase(idCli)) {
//                aux.addVeiculo(veiculo);
//                break;
//            }
//        }
//
//        throw new Error("Erro: cliente inexistente");
//    }

    public void addCliente(Cliente cliente) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
        } else {
            throw new Error("Erro: cliente ja cadastrado no estacionamento");
        }
    }

    private void gerarVagas() {
        char fileiraAtual = 'A';
        int numVagaAtual = 0;
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

    public void estacionar(String placa) {
        Iterator<Vaga> iteratorVaga = vagas.iterator();
        Vaga auxVaga;

        Veiculo veiculo = procurarVeiculo(placa);

        if (veiculo != null) {
            while (iteratorVaga.hasNext()) {
                auxVaga = iteratorVaga.next();
                if (auxVaga.disponivel()) {
                    veiculo.estacionar(auxVaga);
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

        while(iterator.hasNext()) {
            result = result + iterator.next().arrecadadoTotal();
        }

        return result;
    }

    public double arrecadacaoNoMes(int mes) {
        Iterator<Cliente> iterator = clientes.iterator();
        double result = 0.0;

        while(iterator.hasNext()) {
            result = result + iterator.next().arrecadadoNoMes(mes);
        }

        return result;
    }

    public double valorMedioPorUso() {
        Iterator<Cliente> iterator = clientes.iterator();
        int totalUsos = 0;

        while(iterator.hasNext()) {
            totalUsos = totalUsos + iterator.next().totalDeUsos();
        }

        return (totalArrecadado()/totalUsos);
    }

    public String top5Clientes(int mes) {
        ArrayList<Cliente> copiaClientes = clientes;
        int tamClientes = copiaClientes.size(), i = 0;
        double tempValor;
        Cliente tempCliente;
        String result = "";

        if(tamClientes >= 5) {
            Iterator<Cliente> iterator = copiaClientes.iterator();
            double[] aux = new double[tamClientes];

            while(iterator.hasNext()) {
                aux[i] = iterator.next().arrecadadoNoMes(mes);
                i++;
            }

            for(i = 0; i < tamClientes-1; i++) {
                if(aux[i] < aux[i+1]) {
                    tempValor = aux[i];
                    tempCliente = copiaClientes.get(i);
                    aux[i] = aux[i+1];
                    copiaClientes.set(i, copiaClientes.get(i+1));
                    aux[i+1] = tempValor;
                    copiaClientes.set(i+1, tempCliente);
                }
            }

            for(i = 0; i < 5; i++) {
                result.concat("-" + copiaClientes.get(i).getNome() + " R$" + aux[i]);
            }

            return result;

        } else {
            throw new Error("Erro: E necessario ter 5 ou mais clientes para utilizar essa funcao");
        }
    }
}
