package dokumenty;

import java.util.Iterator;

public class MetodaWydruku2 implements IMetodaWydruku {
    @Override
    public void drukujNaglowek(Faktura faktura) {
        System.out.println("=====================================================");
        System.out.println("FAKTURA");
        System.out.println("Data: "+faktura.getDataSprzedazy().toString());
        System.out.println("Firma: "+faktura.getKontrahent());
    }

    @Override
    public void drukujPozycje(Faktura faktura) {
        Iterator<Pozycja> iteratorPozycji=faktura.getIteratorPozycji();
        while(iteratorPozycji.hasNext())
        {
            Pozycja pozycja=iteratorPozycji.next();
            System.out.println("Produkt: "+pozycja.getIlosc()+" x "+pozycja.getNazwa()+" za "+pozycja.getWartosc());
        }
    }

    @Override
    public void drukujStopke(Faktura faktura) {
        System.out.println("Razem: "+faktura.getSuma());
        System.out.println("=====================================================");
    }
}
