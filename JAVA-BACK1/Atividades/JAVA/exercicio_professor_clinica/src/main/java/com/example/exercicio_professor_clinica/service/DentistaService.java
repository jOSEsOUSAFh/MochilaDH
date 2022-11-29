package com.example.exercicio_professor_clinica.service;

import com.example.exercicio_professor_clinica.model.Dentista;
import com.example.exercicio_professor_clinica.repository.IDao;
import org.springframework.stereotype.Service;

import java.util.List;

public class DentistaService {
    private IDao<Dentista> dentistaDao;

    public DentistaService(IDao<Dentista> dentistaDao) {
        this.dentistaDao = dentistaDao;
    }

    public Dentista registrarOdontologo(Dentista odontologo) {
        return dentistaDao.salvar(odontologo);

    }

    public void eliminar(Integer id) {
        dentistaDao.deletar(id);
    }

    public Dentista buscar(Integer id) {
        return dentistaDao.buscar(id);
    }

    public List<Dentista> buscarTodos() {
        return dentistaDao.buscarTodos();
    }

    public Dentista actualizar(Dentista odontologo) {
        return dentistaDao.atualizar(odontologo);
    }
}
