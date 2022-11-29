package com.example.exercicio_professor_clinica.service;

import com.example.exercicio_professor_clinica.model.Paciente;
import com.example.exercicio_professor_clinica.repository.IDao;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public class PacienteService {
    private IDao<Paciente> pacienteIDao;

    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    public Paciente salvar(Paciente p) {
        p.setData(new Date());
        return pacienteIDao.salvar(p);
    }

    public Paciente buscar(Integer id) {
        return pacienteIDao.buscar(id);
    }

    public List<Paciente> buscarTodos() {
        return pacienteIDao.buscarTodos();
    }

    public void eliminar(Integer id) {
        pacienteIDao.deletar(id);
    }

    public Paciente actualizar(Paciente p) {
        return pacienteIDao.atualizar(p);
    }
}
