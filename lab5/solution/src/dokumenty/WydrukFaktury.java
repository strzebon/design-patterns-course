package dokumenty;

import konfuguracja.Konfiguracja;

import java.util.Iterator;

public class WydrukFaktury {

    public static void drukujFakture(Faktura faktura){
        IMetodaWydruku metodaWydruku = Konfiguracja.getInstancja().getMetodaWydruku();
        metodaWydruku.drukujNaglowek(faktura);
        metodaWydruku.drukujPozycje(faktura);
        metodaWydruku.drukujStopke(faktura);
    }

//    public static void drukujFakture(Faktura faktura){
//        System.out.println("=====================================================");
//        System.out.println("FA z dnia: "+faktura.getDataSprzedazy().toString());
//        System.out.println("Wystawiona dla: "+faktura.getKontrahent());
//        System.out.println("Na kwote: "+faktura.getSuma());
//        Iterator<Pozycja> iteratorPozycji=faktura.getIteratorPozycji();
//        while(iteratorPozycji.hasNext())
//        {
//            Pozycja pozycja=iteratorPozycji.next();
//            System.out.println("Towar: "+pozycja.getNazwa()+" Ilosc: "+pozycja.getIlosc()+" Wartosc:" + pozycja.getWartosc());
//        }
//        System.out.println("=====================================================");
//    }
}
