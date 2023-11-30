package com.lpm.model.dao;

import com.lpm.model.ConexaoJDBC;
import com.lpm.model.Estacionamento;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EstacionamentoDAO {

    public void cadastrarEstacionamento(Estacionamento estacionamento) {
        String sql = "INSERT INTO ESTACIONAMENTOS (NOME_ESTACIONAMENTO, QUANTIDADE_FILEIRAS, VAGAS_POR_FILEIRA) VALUES (?, ?, ?)";

        try{
            PreparedStatement ps = ConexaoJDBC.getConnection().prepareStatement(sql);

            ps.setString(1, estacionamento.getNome());
            ps.setInt(2, estacionamento.getQuantFileiras());
            ps.setInt(3, estacionamento.getVagasPorFileira());

            ps.execute();

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Estacionamento lerEstacionamento(String nomeEstacionamento) {
        String sql = "SELECT * FROM ESTACIONAMENTOS WHERE NOME_ESTACIONAMENTO = ?";
        int quantidade_fileiras, vagas_por_fileira;

        try {
            PreparedStatement ps = ConexaoJDBC.getConnection().prepareStatement(sql);

            ps.setString(1, nomeEstacionamento);

            ps.execute();

            ResultSet rs = ps.getResultSet();

            if(rs.next()) {
                quantidade_fileiras = rs.getInt("quantidade_fileiras");
                vagas_por_fileira = rs.getInt("vagas_por_fileira");
                return new Estacionamento(nomeEstacionamento, quantidade_fileiras, vagas_por_fileira);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
