package fakultet;

public class Nastavnik extends Osoba {

	public enum Zvanje {doc, prof}
	private Zvanje zvanje;
	private String oznaka = "N";
	
	public Nastavnik(String ime, String prezime, Zvanje zvanje) {
		super(ime, prezime);
		this.zvanje = zvanje;
	}

	@Override
	public String getOznaka() {
		return oznaka;
	}

	@Override
	public String toString() {
		return zvanje + ". dr " + super.toString();
	}
	
	

}
