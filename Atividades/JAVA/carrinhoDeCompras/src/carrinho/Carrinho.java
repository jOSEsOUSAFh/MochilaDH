package carrinho;

import java.util.ArrayList;

public class Carrinho {
    private ArrayList<Produto> listaProdutos = new ArrayList<>();

    private Estado estado;

    public Carrinho(ArrayList<Produto> listaProdutos, Estado estado) {
        //TODO carrinho deve ser iniciado vazio
    }

    public void adicionar(Produto produto){

    }

    public void cancelar(){

    }
    public void voltar(){

    }
    public void avancar(){

    }

    public void mostrarProduto(){

    }


    public ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(ArrayList<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
