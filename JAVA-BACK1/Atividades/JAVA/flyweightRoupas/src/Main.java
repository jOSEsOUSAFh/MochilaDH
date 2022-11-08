public class Main {
    public static void main(String[] args) {

        RoupasFactory roupa = new RoupasFactory();
        Roupas modelo1 = roupa.CriarRoupas("XS","Camisa",true,true);
        Roupas modelo2 = roupa.CriarRoupas("XS","Camisa",true,true);
        Roupas modelo3 = roupa.CriarRoupas("M","Camisa",true,true);
        Roupas modelo4 = roupa.CriarRoupas("S","Camisa",false,true);
        Roupas modelo5 = roupa.CriarRoupas("M","Camisa",true,true);


        roupa.menuInicial();



    }
}
