import java.util.Date;

public class Paciente {
    String nome;
    String sobreNome;
    String rg;
    String data;
    Endereço endereço;
    private static int id = 0;

    public Paciente(String nome, String sobreNome, String rg, String data, Endereço endereço) {
        id++;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.rg = rg;
        this.data = data;
        this.endereço = endereço;
    }

    public int getId() {
        return id;
    }

    public static void setId(int id) {
        Paciente.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Endereço getEndereço() {
        return endereço;
    }

    public void setEndereço(Endereço endereço) {
        this.endereço = endereço;
    }
}
