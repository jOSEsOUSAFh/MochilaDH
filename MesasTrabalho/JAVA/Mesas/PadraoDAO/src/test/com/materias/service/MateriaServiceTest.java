package test.com.materias.service;

import com.materias.dao.ConfiguraçaoJDBC;
import com.materias.dao.impl.MateriaDaoH2;
import com.materias.model.Materia;
import com.materias.service.MateriaService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MateriaServiceTest {
private MateriaService materiaService = new MateriaService(new MateriaDaoH2(new ConfiguraçaoJDBC()));


@Test
    public void salvarMateriaTest(){
    Materia materia = new Materia("Front");

    Materia materiaRegistrada = materiaService.salvar(materia);

    assertTrue(materiaRegistrada.getId()!= null);
}

@Test
    public void buscarTodosTest(){
    Materia materia = new Materia("Front");
    Materia materia2 = new Materia("Front2");

    materiaService.salvar(materia);
    materiaService.salvar(materia2);

    List<Materia> materias = materiaService.buscarTodos();

    assertEquals(2,materias.size());

}





}