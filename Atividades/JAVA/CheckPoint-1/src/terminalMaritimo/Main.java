package terminalMaritimo;

public class Main {
    public static void main(String[] args) {

 //Polimorfismo
 Funcionario Marcos = new OperadorNivel1("Marcos",543,"Operador",true,true);
 OperadorNivel1 Joao = new OperadorNivel1("Joao",543,"Operador",true,true)  ;
 OperadorNivel1 Paulo = new OperadorNivel1("Paulo",543,"Operador",true,true);


 OperadorNivel2 funalo = new OperadorNivel2("fulano",123,"Operador",true,true,true);
 //Polimorfismo
 Funcionario Jose = new OperadorNivel2("José",456,"Operador",false,true,true);
 OperadorNivel2 beltrano = new OperadorNivel2("Beltrano",332,"Operador",true,true,true);

 mecanico Mario = new mecanico("Mario",767,"Mecanico",true);
 mecanico Fabio = new mecanico("Fabio",747,"Mecanico",true);
 //Polimorfismo
 Funcionario Luis = new mecanico("Luis",747,"Mecanico",true);


        System.out.println("------------------Operador nivel 2 ----------------------");
 Jose.baterPonto();
 // Utilizando o Polimorfismo
 ((OperadorNivel2) Jose).fazerCheckListG();
 Jose.trabalhar("Pequeno porte");


        System.out.println("--------------------Operador nivel 1-------------------------");
Marcos.baterPonto();
// Utilizando o Polimorfismo
((OperadorNivel1) Marcos).fazerCheckListP();
Marcos.trabalhar("Grande porte");



        System.out.println("----------------------Mecanico-----------------------");
Luis.baterPonto();
Luis.trabalhar("Pequeno porte");
// Utilizando o Polimorfismo
((mecanico) Luis).abastecerMaquinas("PÁ CARREGADEIRA");


    }

}
