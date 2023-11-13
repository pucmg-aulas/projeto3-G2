package com.lpm.view;

import com.lpm.model.Cliente;

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

    public RegisterClient() {
        setTitle("Xulambs Parking - Cliente");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        add(panel1);
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarCliente();
            }
        });

        cadastrarVeiculoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterVehicle().setVisible(true);
            }
        });
    }

    private void salvarCliente() {
        String nome = textName.getText();
        String veiculo = textVehicle.getText();

        if (nome.isEmpty() || veiculo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

//        Cliente cliente = new Cliente(nome, veiculo);

        JOptionPane.showMessageDialog(this, "Cliente salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        dispose();
        new Main().setVisible(true);
    }

    public static void main(String[] args) {
        new RegisterClient();
    }
}
