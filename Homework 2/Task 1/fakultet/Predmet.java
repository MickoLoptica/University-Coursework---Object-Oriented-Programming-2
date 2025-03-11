package fakultet;

import java.util.LinkedList;

public class Predmet {

	private String naziv;
	private String sifra;
	private LinkedList<Osoba> osobe = new LinkedList<>();
	private boolean imaNastavnika = false;
	
	public Predmet(String naziv, String sifra) {
		this.naziv = naziv;
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public String getSifra() {
		return sifra;
	}
	
	public void dodajOsobu(Osoba osoba) throws GViseNastavnika {
		if (osoba.getOznaka() == "N" && imaNastavnika) throw new GViseNastavnika();
		osobe.add(osoba);
		if (osoba.getOznaka() == "N") imaNastavnika = true;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(naziv).append(" (").append(sifra).append(")");
		for (Osoba o:osobe) {
			s.append("\n");
			s.append(o);
		}
		return s.toString();
	}
	
	
	
	
	
}
