package com.lpm.view;

import com.lpm.controller.RegisterClientController;
import com.lpm.model.Cliente;
import com.lpm.model.Estacionamento;
import com.lpm.model.Veiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterClient extends JFrame {

    private JPanel panel1;
    private JTextField textId;
    private JButton salvarButton;
    private JTextField textName;
    private RegisterClientController controller;

    public RegisterClient(Estacionamento estacionamentoAtual) {
        setTitle("Xulambs Parking");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        add(panel1);

        controller = new RegisterClientController(this, estacionamentoAtual);
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.registrarCliente();
                estacionamentoAtual.gerar();
            }
        });
    }

    public JTextField getTextId() {
        return textId;
    }

    public JTextField getTextName() {
        return textName;
    }
}
