public class Roupas {
    private String tamanho;
    private String tipo;
    private boolean eNovo;
    private boolean importada;

    public Roupas(String tamanho, String tipo, boolean eNovo, boolean importada) {
        this.tamanho = tamanho;
        this.tipo = tipo;
        this.eNovo = eNovo;
        this.importada = importada;
    }


    public String getTamanho() {
        return tamanho;
    }

    public String getTipo() {
        return tipo;
    }


    public boolean geteNovo() {
        return eNovo;
    }

    public void seteNovo(boolean eNovo) {
        this.eNovo = eNovo;
    }


    public boolean isImportada() {
        return importada;
    }


    @Override
    public String toString() {
        return ">  Expecificações: Tamanho='" + tamanho + '\'' +
                "- Tipo='" + tipo + '\'' +
                "- eNovo=" + eNovo +
                "- Importada=" + importada + "\n" ;
    }
}
