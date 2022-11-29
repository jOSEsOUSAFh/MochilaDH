package com.example.filme.controller;

import com.example.filme.dto.FilmeDTO;
import com.example.filme.model.Filme;
import com.example.filme.repository.impl.FilmeRepository;
import com.example.filme.service.FilmeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    private FilmeService filmeService = new FilmeService(new FilmeRepository());

    @GetMapping
    public List<FilmeDTO> buscarTodas(){
        return filmeService.buscarTodos();
    }





    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Integer id){
        ResponseEntity responseEntity = null;
        if (filmeService.deletar(id))
            responseEntity = ResponseEntity.status(HttpStatus.OK).build();
        else
            responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return responseEntity;
    }

    @PostMapping
    public ResponseEntity<Filme> salvar(@RequestBody Filme filme){
        return ResponseEntity.ok(filmeService.salvar(filme));
    }

    @PutMapping
    public ResponseEntity<Filme> atualizarPelicula(@RequestBody Filme filme){
        return ResponseEntity.ok(filmeService.atualizar(filme));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> buscarPelicula(@PathVariable Integer id){
        return ResponseEntity.ok(filmeService.buscar(id));
    }

}
