public class CheckArtigo {

    CheckQuality artigo;

    public CheckArtigo(){
        this.artigo = new CheckQuality();


    }

    public void verificar(artigo produto){

        artigo.verificar(produto);
    }


}
