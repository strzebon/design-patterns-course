package rabaty;

public class ObliczCenePoRabacieKwotowym implements IObliczCenePoRabacie {

    private double kwota;
    public ObliczCenePoRabacieKwotowym(double kwota) {
        this.kwota = kwota;
    }

    public ObliczCenePoRabacieKwotowym(){
        this.kwota = 0;
    }

    @Override
    public double obliczCenePoRabacie(double cena) {
        if(kwota > cena){
            kwota -= cena;
            return 0;
        }

        double x = kwota;
        kwota = 0;
        return cena - x;
    }
}
