package com.example.exercicio_professor_clinica.service;

import com.example.exercicio_professor_clinica.model.Endereco;
import com.example.exercicio_professor_clinica.repository.IDao;
import org.springframework.stereotype.Service;

import java.util.List;

public class EnderecoService {
    private IDao<Endereco> enderecoDao;

    public EnderecoService(IDao<Endereco> enderecoDao) {
        this.enderecoDao = enderecoDao;
    }
    public Endereco salvar(Endereco d){
        enderecoDao.salvar(d);
        return d;
    }
    public Endereco buscar(Integer id){
        return enderecoDao.buscar(id);
    }
    public List<Endereco> buscarTodos(){
        return enderecoDao.buscarTodos();
    }
    public void deletar(Integer id){
        enderecoDao.deletar(id);
    }
}
