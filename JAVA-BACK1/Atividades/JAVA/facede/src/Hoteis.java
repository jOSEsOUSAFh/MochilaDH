public class Hoteis {
    private  String checkIn;
    private String checkOut;
    private String cidade;

    public Hoteis(String checkIn, String checkOut, String cidade) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.cidade = cidade;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
