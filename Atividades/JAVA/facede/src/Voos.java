public class Voos {
    private String ida;
    private   String volta;
    private String origem;
    private String destino;

    public Voos(String ida, String volta, String origem, String destino) {
        this.ida = ida;
        this.volta = volta;
        this.origem = origem;
        this.destino = destino;
    }

    public String getIda() {
        return ida;
    }

    public void setIda(String ida) {
        this.ida = ida;
    }

    public String getVolta() {
        return volta;
    }

    public void setVolta(String volta) {
        this.volta = volta;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
