package com.example.filme.model;

public class Filme {

    private Integer id;
    private String titulo;
    private String categoria;
    private Integer premios;

    public Filme(Integer id, String titulo, String categoria, Integer premios) {
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.premios = premios;
    }

    public Filme() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getPremios() {
        return premios;
    }

    public void setPremios(Integer premios) {
        this.premios = premios;
    }
}
