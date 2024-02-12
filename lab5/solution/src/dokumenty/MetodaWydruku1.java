package dokumenty;

import java.util.Iterator;

public class MetodaWydruku1 implements IMetodaWydruku {
    @Override
    public void drukujNaglowek(Faktura faktura) {
        System.out.println("=====================================================");
        System.out.println("FA z dnia: "+faktura.getDataSprzedazy().toString());
        System.out.println("Wystawiona dla: "+faktura.getKontrahent());
    }

    @Override
    public void drukujPozycje(Faktura faktura) {
        Iterator<Pozycja> iteratorPozycji=faktura.getIteratorPozycji();
        while(iteratorPozycji.hasNext())
        {
            Pozycja pozycja=iteratorPozycji.next();
            System.out.println("Towar: "+pozycja.getNazwa()+" Ilosc: "+pozycja.getIlosc()+" Wartosc:" + pozycja.getWartosc());
        }
    }

    @Override
    public void drukujStopke(Faktura faktura) {
        System.out.println("Na kwote: "+faktura.getSuma());
        System.out.println("=====================================================");
    }
}
