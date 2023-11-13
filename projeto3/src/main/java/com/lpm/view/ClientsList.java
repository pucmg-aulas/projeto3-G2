package com.lpm.view;

import javax.swing.*;
import java.awt.*;

public class ClientsList extends JFrame {
    private JPanel panel1;
    private JTable table1;

    public ClientsList() {
        setTitle("Xulambs Parking");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Adiciona um JScrollPane para a tabela
        JScrollPane scrollPane = new JScrollPane(table1);
        panel1.setLayout(new BorderLayout());
        panel1.add(scrollPane, BorderLayout.CENTER);

        add(panel1);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientsList();
            }
        });
    }
}
