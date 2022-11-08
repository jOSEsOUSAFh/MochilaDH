public class CheckQuality {


    public void verificar(artigo produto){

        if (
                produto.getEmbalagem().equalsIgnoreCase("Saudavel")
                ||
                produto.getEmbalagem().equalsIgnoreCase("Quase saudavel")
                &&
           produto.getLote() >= 1000
                &&
           produto.getPeso() >= 1200

        ){

            System.out.println(produto.getNome() + " aprovado");
            System.out.println("--------------------");

        }else {
            System.out.println(produto.getNome() + " Rejeitado");
            System.out.println("--------------------");
        }

    }
}
