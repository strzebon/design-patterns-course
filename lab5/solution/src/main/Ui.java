package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Calendar;

import dokumenty.MetodaWydruku1;
import dokumenty.MetodaWydruku2;
import dokumenty.WydrukFaktury;
import kategorie.Kategoria;
import konfuguracja.Konfiguracja;
import magazyn.Towar;

import dokumenty.Faktura;

//ZEWNETRZNY RABAT
import rabatlosowy.LosowyRabat;
import rabaty.Adapter;
import rabaty.ObliczCenePoRabacieKwotowym;
import rabaty.ObliczCenePoRabacieProcentowym;


public class Ui {

	public static void main(String[] args) {
		SingleObject object = SingleObject.getInstance();
		object.showMessage();
		Calendar teraz=Calendar.getInstance();
		LosowyRabat lr = new LosowyRabat();
		Konfiguracja.getInstancja().setStrategia(new Adapter(lr));
//		Konfiguracja.getInstancja().setStrategia(new ObliczCenePoRabacieKwotowym(20));
//		Konfiguracja.getInstancja().setStrategia(new ObliczCenePoRabacieProcentowym(0.5));
		Konfiguracja.getInstancja().setMetodaWydruku(new MetodaWydruku2());
		
		//Tworzymy towary
//		Towar t1=new Towar(10,"buty");
//		Towar t2=new Towar(2,"skarpety");

		Kategoria produkt = new Kategoria("Produkt");
		Kategoria elektronika = new Kategoria(produkt, "Elektronika");
		Kategoria agd = new Kategoria(elektronika, "AGD");
		Kategoria rtv = new Kategoria(elektronika, "RTV");
		Kategoria jedzenie = new Kategoria(produkt, "Jedzenie");
		Kategoria owoce = new Kategoria(jedzenie, "Owoce");
		Kategoria warzywa = new Kategoria(jedzenie, "Warzywa");

		produkt.addPodkategoria(elektronika);
		produkt.addPodkategoria(jedzenie);
		elektronika.addPodkategoria(agd);
		elektronika.addPodkategoria(rtv);
		jedzenie.addPodkategoria(owoce);
		jedzenie.addPodkategoria(warzywa);

		Towar t1 = new Towar(200, "pralka");
		Towar t2 = new Towar(500, "telewizor");
		Towar t3 = new Towar(5, "mango");
		Towar t4 = new Towar(2, "ziemniak");

		agd.addTowar(t1);
		rtv.addTowar(t2);
		owoce.addTowar(t3);
		warzywa.addTowar(t4);

		ArrayList<Kategoria> kategorie= new ArrayList<>();
		kategorie.add(produkt);
		while(!kategorie.isEmpty()){
			ArrayList<Kategoria> podkategorie= new ArrayList<>();
			for(Kategoria kategoria: kategorie){
				System.out.print(kategoria.getNazwa() + " ( ");
				for(Towar towar: kategoria.getTowary()){
					System.out.print(towar.getNazwa() + " ");
				}
				System.out.print(" ) ");
				podkategorie.addAll(kategoria.getPodkategorie());
			}
			System.out.println();
			kategorie = podkategorie;
		}
		
		//I przykladowa fakture
		Faktura f=new Faktura(teraz.getTime(),"Fido");
		f.dodajPozycje(t1,3);
		f.dodajPozycje(t2, 5);
		
		WydrukFaktury.drukujFakture(f);

		
		//TEST ZEWN. rabatu
//		LosowyRabat lr=new LosowyRabat();
//		System.out.println(lr.losujRabat());
	}
//	private static void wypiszFakture(Faktura faktura)
//	{
//		System.out.println("=====================================================");
//		System.out.println("FA z dnia: "+faktura.getDataSprzedazy().toString());
//		System.out.println("Wystawiona dla: "+faktura.getKontrahent());
//		System.out.println("Na kwote: "+faktura.getSuma());
//		Iterator<Pozycja> iteratorPozycji=faktura.getIteratorPozycji();
//		while(iteratorPozycji.hasNext())
//		{
//			Pozycja pozycja=iteratorPozycji.next();
//			System.out.println("Towar: "+pozycja.getNazwa()+" Ilosc: "+pozycja.getIlosc()+" Wartosc:" + pozycja.getWartosc());
//		}
//		System.out.println("=====================================================");
//	}

}
