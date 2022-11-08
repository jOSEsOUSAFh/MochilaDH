package terminalMaritimo;

public class mecanico extends Funcionario {
    private boolean cursoDeMecanica;

    public mecanico(String nome, int matricula,String funcao ,boolean cursoDeMecanica) {
        super(nome, matricula,funcao);
        this.cursoDeMecanica = cursoDeMecanica;
    }

    @Override // Sobrescrito
    public void trabalhar(String maquina) {
        if (cursoDeMecanica == true){
            System.out.println("checar os check-lists dos operadores e fazer manutenção nas maquinas conforme necessario ");
        }else {
            System.out.println("Mecanico não qualificado para trabalho");
        };

    }

    //Sobrecarca
    public void abastecerMaquinas(){
        System.out.println("Abastece todas as maquinas");
    };

    public void abastecerMaquinas(String maquina){
        System.out.println("Abatece a maquina " + maquina);
    };
}
