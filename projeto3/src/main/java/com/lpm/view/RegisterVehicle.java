package com.lpm.view;

import javax.swing.*;

public class RegisterVehicle extends JFrame {

    private JPanel panel1;
    private JTextField textPlate;
    private JButton cadastrarButton;

    public RegisterVehicle() {
        setTitle("Xulambs Parking - Cliente");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(panel1);

        setVisible(true);
    }

    public static void main(String[] args) {
        new RegisterVehicle();
    }

}
