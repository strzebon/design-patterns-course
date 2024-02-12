package rabaty;

import rabatlosowy.LosowyRabat;

public class Adapter implements IObliczCenePoRabacie{
    private final LosowyRabat losowyRabat;
    public Adapter(LosowyRabat losowyRabat){
        this.losowyRabat = losowyRabat;
    }
    @Override
    public double obliczCenePoRabacie(double cena) {
        return(cena * (1 - losowyRabat.losujRabat()));
    }
}
