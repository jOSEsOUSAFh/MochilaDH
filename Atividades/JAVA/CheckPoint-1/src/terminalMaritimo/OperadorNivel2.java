package terminalMaritimo;

public class OperadorNivel2 extends Funcionario {
    private boolean CNH_D;
    private boolean cursoMaquinaP;
    private boolean cursoMaquinaG;

    public OperadorNivel2(String nome, int matricula,String funcao, boolean CNH_D, boolean cursoMaquinaP, boolean cursoMaquinaG) {
        super(nome, matricula, funcao);
        this.CNH_D = CNH_D;
        this.cursoMaquinaP = cursoMaquinaP;
        this.cursoMaquinaG = cursoMaquinaG;
    }


    @Override
    public void trabalhar(String maquina) {
        if (CNH_D == true && cursoMaquinaP == true && cursoMaquinaG == true ){
            System.out.println("Operando maquina de grande porte");
        }else {
            System.out.println("Operador sem permissão para operar maquinas");
        };


    };

    public void fazerCheckListG(){
        System.out.println("Fazer check list da maquina de grande porte que for utilizar");
    };

}
