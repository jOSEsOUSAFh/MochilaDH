public class processarArtigo {
    public static void main(String[] args) {

        CheckArtigo processo = new CheckArtigo();

        processo.verificar(new artigo("Macarrao",900,2000,"Saudavel"));


        processo.verificar(new artigo("Feijao",900,2000,"Saudavel"));


        processo.verificar(new artigo("Arroz",900,2000,"Saudavel"));



    }
}
