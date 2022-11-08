package com.materias.dao.impl;

import com.materias.dao.ConfiguraçaoJDBC;
import com.materias.dao.IDao;
import com.materias.model.Materia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MateriaDaoH2 implements IDao<Materia> {
  private ConfiguraçaoJDBC configuraçaoJDBC;

    public MateriaDaoH2(ConfiguraçaoJDBC configuraçaoJDBC) {
        this.configuraçaoJDBC = configuraçaoJDBC;
    }

    @Override
    public Materia salvar(Materia materia) {
        Connection connection = configuraçaoJDBC.conectarComBD();
        Statement statement = null;
        String query = String.format("INSERT INTO materias(nome) VALUES('%S')",materia.getNome());
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()){
                materia.setId(keys.getInt(1));
                statement.close();
                connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return materia;
    }

    @Override
    public List<Materia> buscarTodos() {
        Connection connection = configuraçaoJDBC.conectarComBD();
        Statement statement = null;
        String query = String.format("SELECT * FROM materias");
        List<Materia> materias = new ArrayList<>();

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                System.out.println(resultSet.getInt(1));
                materias.add(new Materia(resultSet.getInt("id"),
                        resultSet.getString("nome")));
            }



        }catch (SQLException e){
            e.printStackTrace();
        }

        return materias;
    }
}
