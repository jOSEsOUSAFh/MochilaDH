package com.example.exercicio_professor_clinica.repository.impl;

import com.example.exercicio_professor_clinica.model.Endereco;
import com.example.exercicio_professor_clinica.repository.IDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDaoH2 implements IDao<Endereco> {
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/db_clinica;INIT=RUNSCRIPT FROM 'create.sql'";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "";


    @Override
    public Endereco salvar(Endereco endereco) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("INSERT INTO enderecos(rua,numero,bairro,cidade) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, endereco.getRua());
            preparedStatement.setString(2, endereco.getNumero());
            preparedStatement.setString(3, endereco.getBairro());
            preparedStatement.setString(4, endereco.getCidade());

            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            if(keys.next())
                endereco.setId(keys.getInt(1));

            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return endereco;
    }

    @Override
    public void deletar(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("DELETE FROM enderecos where id = ?");
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public Endereco buscar(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Endereco endereco = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT id,rua,numero,bairro,cidade FROM enderecos where id = ?");
            preparedStatement.setInt(1,id);

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                int idEndereco = result.getInt("id");
                String rua = result.getString("rua");
                String numero = result.getString("numero");
                String bairro = result.getString("bairro");
                String cidade = result.getString("cidade");

                endereco = new Endereco(idEndereco,rua,numero,bairro,cidade);
            }

            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return endereco;
    }

    @Override
    public List<Endereco> buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Endereco> enderecos = new ArrayList<>();
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT *  FROM enderecos");

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {

                int idEndereco = result.getInt("id");
                String rua = result.getString("rua");
                String numero = result.getString("numero");
                String bairro = result.getString("bairro");
                String cidade = result.getString("cidade");

                Endereco domicilio = new Endereco(idEndereco,rua,numero,bairro,cidade);

                enderecos.add(domicilio);

            }

            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return enderecos;
    }

    @Override
    public Endereco atualizar(Endereco endereco) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("UPDATE enderecos SET rua = ?, numero = ? ,bairro = ?, cidade = ?  WHERE id = ?");

            preparedStatement.setString(1, endereco.getRua());
            preparedStatement.setString(2, endereco.getNumero());
            preparedStatement.setString(3, endereco.getBairro());
            preparedStatement.setString(4, endereco.getCidade());
            preparedStatement.setInt(5, endereco.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return endereco;
    }
}
