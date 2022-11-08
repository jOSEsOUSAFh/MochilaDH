import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RoupasFactory {
    Scanner entrada = new Scanner(System.in);

    static final Map<String,Roupas> ListaTamanhoXS = new HashMap<>();
    static final Map<String,Roupas> ListaTamanhoS = new HashMap<>();
    static final Map<String,Roupas> ListaTamanhoM = new HashMap<>();
    static final Map<String,Roupas> ListaRoupasImportadas = new HashMap<>();
    static final Map<String,Roupas> ListaRoupasUsadas = new HashMap<>();



    private static int contadorID;


    public void menuInicial(){
        String opcao;

        System.out.println("1) Lista de Roupas XS\n"+"2)Lista de Roupas S\n"+"3)Lista de Roupas M\n"+
                "4)Lista de Roupas Importadas\n"+"5)Lista de Roupas Reutilizada(Com Bug)\n"+
                "Digite o numero correspondente ao que deseja fazer ou digite qualquer outro caractere para sair: ");

        opcao = entrada.next();

        do {
            if (opcao.equalsIgnoreCase("1")){
                ListaDeRoupasXS();
            } else if (opcao.equalsIgnoreCase("2")) {
                //ListaDeRoupasS();
            } else if (opcao.equalsIgnoreCase("3")) {
                //ListaDeRoupasM();
            } else if (opcao.equalsIgnoreCase("4")) {
                //ListaDeRupasImportadas();
            } else if (opcao.equalsIgnoreCase("5")) {
                //ListaDeRoupasReutilizadas();
            }
        }while (opcao == "1" || opcao == "2" || opcao == "3" || opcao == "4" || opcao.equals("5"));

    }



    public void ListaDeRoupasXS(){
        System.out.println("Lista de Roupa XS: "+ ListaTamanhoXS );
    }
    public void ListaDeRoupasS(){
        System.out.println("Lista de Roupa S: "+ ListaTamanhoS );

    }

    public void ListaDeRoupasM(){
        System.out.println("Lista de Roupa M: "+ ListaTamanhoM );

    }
    public void ListaDeRupasImportadas(){
        System.out.println("Lista de Roupa Importadas: " +ListaRoupasImportadas );

    }
    public void ListaDeRoupasReutilizadas(){
        System.out.println("Lista de Roupa Reutilizadas : "+ ListaRoupasUsadas );

    }




    public static Roupas CriarRoupas(String tamanho, String tipo, boolean eNovo, boolean importada){
        String id ="\nID:"+contadorID++ +tamanho +tipo +eNovo + importada+" ";
        Roupas roupas = ListaTamanhoXS.get(tipo);

        if (!ListaTamanhoXS.containsKey(id) && tamanho == "XS"){
            ListaTamanhoXS.put(id,new Roupas(tamanho,tipo,eNovo,importada));
            roupas = ListaTamanhoXS.get(id);

        }

        if (!ListaTamanhoS.containsKey(id) && tamanho.equals("S")){
            ListaTamanhoS.put(id,new Roupas(tamanho,tipo,eNovo,importada));
            // System.out.println("Lista tamanho S: "+ ListaTamanhoS);
        }

        if (!ListaTamanhoM.containsKey(id) && tamanho.equals("M")){
            ListaTamanhoM.put(id,new Roupas(tamanho,tipo,eNovo,importada));
            //System.out.println("Lista tamanho M: "+ ListaTamanhoM);
        }

        if (!ListaRoupasImportadas.containsKey(id) && importada == true){
            ListaRoupasImportadas.put(id,new Roupas(tamanho,tipo,eNovo,importada));
            // System.out.println("Lista Importada: "+ ListaRoupasImportadas);
        }

        if (!ListaRoupasUsadas.containsKey(id) && eNovo == false){
            ListaRoupasUsadas.put(id,new Roupas(tamanho,tipo,eNovo,importada));
            // System.out.println("Lista Usadas: "+ ListaRoupasUsadas);
        }


        return roupas;
    };



}
