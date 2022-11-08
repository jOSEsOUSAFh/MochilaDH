public class apiHoteis {
    public String buscarHotel(Hoteis hoteis){
    if (hoteis.getCidade().compareTo("SP")==0){
    return "Destino encontrado";
    }
    return "Destino não encontrado";
    }
}
