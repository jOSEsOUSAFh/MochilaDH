package com.example.exercicio_professor_clinica.model;

public class Dentista {
    private Integer id;
    private String nome;
    private String sobrenome;
    private Integer matricula;

    public Dentista() {
    }

    public Dentista(String nombre, String apellido, Integer matricula) {
        this.nome = nombre;
        this.sobrenome = apellido;
        this.matricula = matricula;
    }

    public Dentista(Integer id, String nombre, String apellido, Integer matricula) {
        this.id = id;
        this.nome = nombre;
        this.sobrenome = apellido;
        this.matricula = matricula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Odontologo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", matricula=" + matricula +
                '}';
    }
}
