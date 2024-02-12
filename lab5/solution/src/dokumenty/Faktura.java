package dokumenty;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;

import konfuguracja.Konfiguracja;
import magazyn.Towar;
import rabaty.IObliczCenePoRabacie;


public class Faktura {
	Date dataSprzedazy;
	String kontrahent;
	ArrayList<Pozycja> pozycje;
	double suma;
	 IObliczCenePoRabacie strategia;
	public Faktura(Date dataSprzedazy,String kontrahent)
	{
		this.dataSprzedazy=dataSprzedazy;
		this.kontrahent=kontrahent;
		pozycje=new ArrayList<Pozycja>();
		suma=0;
		this.strategia = Konfiguracja.getInstancja().getObliczanieRabatu();
	}
	public void dodajPozycje(Towar towar, double ilosc)
	{
		Pozycja pozycja = new Pozycja(towar,ilosc);
		double cena = strategia.obliczCenePoRabacie(pozycja.getCena() * ilosc) / ilosc;
		pozycja.setCena(cena);
		pozycje.add(pozycja);
		this.przeliczSume();
	}
	public double getSuma()
	{
		return suma;
	}
	public Date getDataSprzedazy()
	{
		return dataSprzedazy;
	}

	//jak sie zmieni cos na fakturze to trzeba wywolac te metode
	private void przeliczSume()
	{
		Iterator<Pozycja> iteratorPozycji=pozycje.iterator();
		Pozycja pozycja;
		suma=0;
		while(iteratorPozycji.hasNext())
		{
			pozycja = iteratorPozycji.next();
			suma+=pozycja.getWartosc();
		}
	}
	public Iterator<Pozycja> getIteratorPozycji()
	{
		return pozycje.iterator();
	}
	public String getKontrahent()
	{
		return this.kontrahent;
	}
	
	
}
