package com.materias.service;

import com.materias.dao.IDao;
import com.materias.model.Materia;

import java.util.List;

public class MateriaService {
    private IDao<Materia> materiaIDao;

    public MateriaService(IDao<Materia> materiaIDao) {
        this.materiaIDao = materiaIDao;
    }

    public Materia salvar(Materia materia){
        return materiaIDao.salvar(materia);
    }

    public List<Materia> buscarTodos(){
        return materiaIDao.buscarTodos();
    }
}
