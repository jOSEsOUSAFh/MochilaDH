package com.example.exercicio_professor_clinica.repository.impl;

import com.example.exercicio_professor_clinica.model.Endereco;
import com.example.exercicio_professor_clinica.model.Paciente;
import com.example.exercicio_professor_clinica.repository.IDao;
import com.example.exercicio_professor_clinica.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDaoH2 implements IDao<Paciente> {
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/db_clinica;INIT=RUNSCRIPT FROM 'create.sql'";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "";

    private EnderecoDaoH2 enderecoDaoH2 = new EnderecoDaoH2();

    @Override
    public Paciente salvar(Paciente paciente) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            Endereco endereco = enderecoDaoH2.salvar(paciente.getEndereco());
            paciente.getEndereco().setId(endereco.getId());

            preparedStatement = connection.prepareStatement("INSERT INTO pacientes(nome,sobrenome,cpf,data,idEndereco) VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setString(2, paciente.getSobrenome());
            preparedStatement.setString(3, paciente.getCpf());
            preparedStatement.setDate(4, Util.utilDateToSqlDate(paciente.getData()));
            preparedStatement.setInt(5, paciente.getEndereco().getId());

            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            if(keys.next())
                paciente.setId(keys.getInt(1));

            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return paciente;
    }

    @Override
    public void deletar(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("DELETE FROM pacientes where id = ?");
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Paciente buscar(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Paciente paciente = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT id,nome,sobrenome,cpf,data,idEndereco  FROM pacientes where id = ?");
            preparedStatement.setInt(1,id);

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                int idPaciente = result.getInt("id");
                String nome = result.getString("nome");
                String sobrenome = result.getString("sobrenome");
                String cpf = result.getString("cpf");
                java.sql.Date data = result.getDate("data");
                int idEndereco = result.getInt("idEndereco");
                Endereco endereco = enderecoDaoH2.buscar(idEndereco);
                paciente = new Paciente(idPaciente,nome,sobrenome,cpf,data,endereco);
            }

            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return paciente;
    }

    @Override
    public List<Paciente> buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Paciente> pacientes = new ArrayList<>();
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT *  FROM pacientes");

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                int idPaciente = result.getInt("id");
                String nome = result.getString("nome");
                String sobrenome = result.getString("sobrenome");
                String cpf = result.getString("cpf");
                Date data = result.getDate("data");
                int idEndereco = result.getInt("domicilio_id");
                Endereco endereco = enderecoDaoH2.buscar(idEndereco);
                Paciente paciente = new Paciente(idPaciente,nome,sobrenome,cpf,data,endereco);
                pacientes.add(paciente);
            }

            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return pacientes;
    }

    @Override
    public Paciente atualizar(Paciente paciente) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            Endereco endereco = enderecoDaoH2.atualizar(paciente.getEndereco());

            preparedStatement = connection.prepareStatement("UPDATE pacientes SET nome=?, sobrenome=?, cpf=?, data=?, idEndereco=?  WHERE id = ?");

            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setString(2, paciente.getSobrenome());
            preparedStatement.setString(3, paciente.getCpf());
            preparedStatement.setDate(4, Util.utilDateToSqlDate(paciente.getData()));
            preparedStatement.setInt(5, paciente.getEndereco().getId());
            preparedStatement.setInt(6, paciente.getId());

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return paciente;
    }
}
