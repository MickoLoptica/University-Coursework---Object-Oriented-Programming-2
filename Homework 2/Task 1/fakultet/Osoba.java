package fakultet;

public abstract class Osoba {

	private String ime;
	private String prezime;
	
	public Osoba(String ime, String prezime) {
		this.ime = ime;
		this.prezime = prezime;
	}
	
	public abstract String getOznaka();

	@Override
	public String toString() {
		return ime + " " + prezime;
	}
	
	
	
}
