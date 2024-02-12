package konfuguracja;

import dokumenty.IMetodaWydruku;
import rabaty.IObliczCenePoRabacie;

public class Konfiguracja {
    private static Konfiguracja instancja;
    private IObliczCenePoRabacie strategia;
    private IMetodaWydruku metodaWydruku;

    public static Konfiguracja getInstancja() {
        if (instancja == null) instancja = new Konfiguracja();

        return instancja;
    }

    public void setStrategia(IObliczCenePoRabacie strategia) {
        this.strategia = strategia;
    }

    public IObliczCenePoRabacie getObliczanieRabatu() {
        return strategia;
    }

    public void setMetodaWydruku(IMetodaWydruku metodaWydruku) {
        this.metodaWydruku = metodaWydruku;
    }

    public IMetodaWydruku getMetodaWydruku() {
        return metodaWydruku;
    }
}
