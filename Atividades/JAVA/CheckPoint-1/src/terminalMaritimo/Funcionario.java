package terminalMaritimo;

import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class Funcionario {

    private String nome;
    private int matricula;

    private String funcao;


    public Funcionario(String nome, int matricula, String funcao) {
        this.nome = nome;
        this.matricula = matricula;
        this.funcao = funcao;
    }


    public abstract void trabalhar(String maquina);

    public  void baterPonto(){

        System.out.println("Registrando ponto do funcionario " + nome +" as: " + LocalDateTime.now());
    };


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
