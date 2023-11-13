package com.lpm.view;

import com.lpm.model.Veiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterVehicle extends JFrame {

    private JPanel panel1;
    private JTextField textPlate;
    private JButton cadastrarButton;

    public RegisterVehicle() {
        setTitle("Xulambs Parking");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(panel1);

        setVisible(true);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarVeiculo();
                dispose();
                new RegisterClient().setVisible(true);
            }
        });
    }

    private void cadastrarVeiculo() {
        String placa = textPlate.getText();

        if (placa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha a placa do veículo.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, "Veículo cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);


        Veiculo novoVeiculo = new Veiculo(placa);


        // Limpa o campo da placa após o cadastro
        textPlate.setText("");
    }

    public static void main(String[] args) {
        new RegisterVehicle();
    }

}
