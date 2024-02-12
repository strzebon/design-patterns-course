package rabaty;

public class ObliczCenePoRabacieProcentowym implements IObliczCenePoRabacie {
    private double rabat;

    public ObliczCenePoRabacieProcentowym(double rabat) {
        this.rabat = rabat;
    }

    public ObliczCenePoRabacieProcentowym(){
        rabat = 0;
    }

    @Override
    public double obliczCenePoRabacie(double cena) {
        return cena * (1-rabat);
    }
}
