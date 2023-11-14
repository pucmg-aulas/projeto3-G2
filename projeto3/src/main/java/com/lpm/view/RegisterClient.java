package com.lpm.view;

import com.lpm.model.Cliente;
import com.lpm.model.Estacionamento;
import com.lpm.model.Veiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterClient extends JFrame {

    private JPanel panel1;
    private JTextField textId;
    private JTextField textVehicle;
    private JButton cadastrarVeiculoButton;
    private JButton salvarButton;
    private JTextField textName;

    public RegisterClient(Estacionamento estacionamento) {
        setTitle("Xulambs Parking");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        add(panel1);
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarCliente(estacionamento);
            }
        });

        cadastrarVeiculoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RegisterVehicle().setVisible(true);
            }
        });
    }

    private void salvarCliente(Estacionamento estacionamento) {
        String id = textId.getText();
        String nome = textName.getText();
        Veiculo veiculo = new Veiculo(textVehicle.getText());

        if (nome.isEmpty() || id.isEmpty() || veiculo.getPlaca().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente cliente = new Cliente(id, nome, veiculo);
        estacionamento.addCliente(cliente);
        estacionamento.printClientes();


        JOptionPane.showMessageDialog(this, "Cliente salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        dispose();
        new Main().setVisible(true);
    }

    public static void main(String[] args) {
        new RegisterClient(new Estacionamento());
    }
}
