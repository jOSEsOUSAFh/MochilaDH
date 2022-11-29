package com.example.filme.service;

import com.example.filme.dto.FilmeDTO;
import com.example.filme.model.Filme;
import com.example.filme.repository.IFilme;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class FilmeService {

    private IFilme<Filme> filmeRepository;

    public FilmeService(IFilme<Filme> filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public Filme salvar(Filme filme){
        return this.filmeRepository.salvar(filme);
    }

    public List<FilmeDTO> buscarTodos(){
        ObjectMapper mapper = new ObjectMapper();
        List<Filme> filmes = filmeRepository.buscarTodos();
        List<FilmeDTO> filmeDTOS = new ArrayList<FilmeDTO>();
        for(Filme filme:filmes){
            FilmeDTO filmeDTO = mapper.convertValue(filme,FilmeDTO.class);
            filmeDTOS.add(filmeDTO);
        }
        return filmeDTOS;
    }

    public Boolean deletar(Integer id){
        return filmeRepository.deletar(id);
    }

    public Filme atualizar(Filme pelicula){
        return filmeRepository.atualizar(pelicula);
    }

    public Filme buscar(Integer id){
        return filmeRepository.buscar(id);
    }
}
