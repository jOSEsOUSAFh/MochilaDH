public class Main {
    public static void main(String[] args) {
        ArvoreFactory floresta = new ArvoreFactory();
        Arvores Ornamentais = floresta.getArvores(200,400,"Verde");
        Arvores Ornamentais2 = floresta.getArvores(200,400,"Verde");
        Arvores Frutíferas = floresta.getArvores(500,300,"Vermelho");
        Arvores Florífera = floresta.getArvores(100,200,"Azul");

        System.out.println(Ornamentais.toString());
        System.out.println(Florífera.toString());
        System.out.println(Ornamentais2.toString());


    }
}
