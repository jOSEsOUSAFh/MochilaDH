package com.materias;

import com.materias.dao.ConfiguraçaoJDBC;
import com.materias.dao.impl.MateriaDaoH2;
import com.materias.model.Materia;
import com.materias.service.MateriaService;

public class Main {
    public static void main(String[] args) {
        Materia materia = new Materia("Back");
        Materia materia2 = new Materia("Back");

        MateriaService materiaService = new MateriaService(new MateriaDaoH2(new ConfiguraçaoJDBC()));

        materiaService.salvar(materia);
        materiaService.salvar(materia2);
        materiaService.buscarTodos();

    }
}
