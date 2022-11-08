package terminalMaritimo;

import java.sql.Struct;

public class OperadorNivel1 extends Funcionario {
    private boolean CNH_C;
    private boolean cursoMaquinaP;
    public OperadorNivel1(String nome, int matricula,String funcao,boolean CNH_C,boolean cursoMaquinaP) {
        super(nome, matricula, funcao);
        this.CNH_C = CNH_C;
        this.cursoMaquinaP = cursoMaquinaP;

    }



    @Override
    public void trabalhar(String maquina) {
        if (maquina !="Grande porte" && cursoMaquinaP == true && CNH_C == true){
            System.out.println("Operar maquina de pequeno porte");
        }else {
            System.out.println("Operador sem permissão para trabalhar");
            if (maquina == "Grande porte"){
                System.out.println(getNome() +" não tem nivel suficiente");
            }
        };

    }

    public void fazerCheckListP(){
        System.out.println("Fazer check list da maquina de pequeno porte que for utilizar");
    };


}
