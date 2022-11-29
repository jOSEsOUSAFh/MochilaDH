package com.example.filme.repository;

import java.util.List;

public interface IFilme<T> {

    T salvar(T t);
    List<T> buscarTodos();
    T atualizar(T t);
    Boolean deletar(Integer id);
    T buscar(Integer id);
}
