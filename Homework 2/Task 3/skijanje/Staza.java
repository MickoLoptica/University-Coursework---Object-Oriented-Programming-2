package skijanje;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Staza {

	private LinkedList<Deonica> deonice = new LinkedList<>();
	private String naziv;
	
	public Staza(String naziv) {
		this.naziv = naziv;
	}
	
	public void dodaj(Deonica deonica) {
		deonice.add(deonica);
	}
	
	public int broj() {
		return deonice.size();
	}
	
	public double duzina() {
		double ukupnaDuzina = 0;
		for (Deonica d:deonice) {
			ukupnaDuzina += d.duzina();
		}
		return ukupnaDuzina;
	}
	
	public double brzina(double pocetnaBrzina) {
		double krajnjaBrzina = pocetnaBrzina;
		for (Deonica d:deonice) {
			krajnjaBrzina = d.brzina(krajnjaBrzina);
		}
		return krajnjaBrzina;
	}
	
	public double vreme(double pocetnaBrzina) {
		double ukupnoVreme = 0;
		double pocetnaBrzinaSledeceDeonice = pocetnaBrzina;
		for (Deonica d:deonice) {
			ukupnoVreme += d.vreme(pocetnaBrzinaSledeceDeonice);
			pocetnaBrzinaSledeceDeonice = d.brzina(pocetnaBrzinaSledeceDeonice);
		}
		return ukupnoVreme;
	}
	
	public double nagib() {
		double maksNagib = 0;
		for (Deonica d:deonice) {
			if (d.nagib() > maksNagib) maksNagib = d.nagib();
		}
		return maksNagib;
	}
	
	public char oznaka() throws GOznaka {
		if (deonice.size() == 0) throw new GOznaka();
		char najcescaOznaka = deonice.getFirst().oznaka();
		char trenutnaOznaka;
		int maksBrojPojavljivanja = 0;
		int trenutniBrojPojavljivanja = 0;
		for (Deonica d:deonice) {
			trenutnaOznaka = d.oznaka();
			for (Deonica d2:deonice) {
				if (d2.oznaka() == trenutnaOznaka) trenutniBrojPojavljivanja++;
			}
			if (trenutniBrojPojavljivanja > maksBrojPojavljivanja) {
				najcescaOznaka = trenutnaOznaka;
				maksBrojPojavljivanja = trenutniBrojPojavljivanja;
			}
		}
		return najcescaOznaka;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(naziv).append("|").append(broj()).append("|").append(duzina())
			.append("|").append(nagib()).append("\n");
		s.append("[");
		for (Deonica d:deonice) {
			if (d != deonice.peekFirst()) s.append(","); 
			s.append(d);
		}
		s.append("]");
		return s.toString();
	}
	
}
