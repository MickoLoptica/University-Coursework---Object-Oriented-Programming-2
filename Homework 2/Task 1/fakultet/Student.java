package fakultet;

public class Student extends Osoba {

	private int godina;
	private static int sledeciIndeks = 1;
	private int brojIndeksa;
	private String oznaka = "S";
	
	public Student(String ime, String prezime, int godina) {
		super(ime, prezime);
		this.godina = godina;
		this.brojIndeksa = sledeciIndeks++;
	}

	@Override
	public String getOznaka() {
		return oznaka;
	}

	@Override
	public String toString() {
		return String.format("%04d", godina) + "/" + String.format("%04d", brojIndeksa)
			+ " - " + super.toString();
	}

	
	
}
