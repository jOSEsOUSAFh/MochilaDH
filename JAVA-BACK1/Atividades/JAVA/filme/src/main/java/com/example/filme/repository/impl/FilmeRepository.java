package com.example.filme.repository.impl;

import com.example.filme.model.Filme;
import com.example.filme.repository.IFilme;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FilmeRepository implements IFilme<Filme> {

    private List<Filme> filmes;

    public FilmeRepository() {
        this.filmes = salvarFilmes();
    }

    @Override
    public Filme salvar(Filme filme) {
        if(filme.getId()==null)
            filme.setId(new Random().nextInt());
        this.filmes.add(filme);
        return filme;
    }

    @Override
    public List<Filme> buscarTodos() {
        return this.filmes;
    }

    @Override
    public Filme atualizar(Filme filme) {
        deletar(filme.getId());
        salvar(filme);
        return filme;
    }

    @Override
    public Boolean deletar(Integer id) {
        for(Filme filme:filmes){
            if ((filme.getId().equals(id))){
                filmes.remove(filme);
                return true;
            }
        }
        return false;
    }

    @Override
    public Filme buscar(Integer id) {

        for(Filme filme:filmes){
            if ((filme.getId().equals(id))){
                return filme;
            }
        }
        return null;
    }

    private List<Filme> salvarFilmes(){
        List<Filme> filmesSalvos = new ArrayList<>();
        filmesSalvos.add(new Filme(1,"Star Wars","Ficção",7));
        filmesSalvos.add(new Filme(2,"TI","Tecnologia",2));
        return filmesSalvos;
    }
}
