public class apiVoos {
    public String buscarVoos(Voos voos){
    if (voos.getDestino().compareTo("SP")==0){
        System.out.println("Destino encontrado");
    }
    return "Destino não encontrado";
    }
}
