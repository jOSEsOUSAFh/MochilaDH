import java.util.HashMap;

public class ArvoreFactory {
    private static final HashMap<String, Arvores> arvoresMap = new HashMap<>();

    public Arvores getArvores(int altura, int largura, String cor){
        String id= "ID: "+ altura +" "+largura+" "+cor;
        System.out.println(id);

        if (!arvoresMap.containsKey(id)){
            arvoresMap.put(id,new Arvores(altura,largura,cor));
            System.out.println("ARVORE PLANTADA COM SUCESSO!!");
            return arvoresMap.get(id);
        }
        System.out.println("ARVORE RE-PLANTADA");
        return arvoresMap.get(id);
    };

}
