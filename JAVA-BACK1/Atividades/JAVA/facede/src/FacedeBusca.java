import java.util.Date;

public class FacedeBusca  implements IfacedeBusca{

    private apiHoteis ApiHoteis;
    private apiVoos ApiVoos;

public FacedeBusca(){
ApiVoos = new apiVoos();
ApiHoteis = new apiHoteis();
}




public String buscar (String Cidade, String checkIn, String CheckOut){
Hoteis hoteis = new Hoteis(Cidade, checkIn, CheckOut);
Voos voos = new Voos(checkIn,CheckOut,Cidade,Cidade);

String resultadosHotel = ApiHoteis.buscarHotel(hoteis);
String resultadosVoos = ApiVoos.buscarVoos(voos);


return "O destino do voo e a cidade da hospedagem é "+resultadosHotel;




}

}
