package zadatak1;

public class Baterija {

	private int kapacitet;
	private int energija;
	
	public Baterija(int kapacitet) {
		this.kapacitet = kapacitet;
		this.energija = kapacitet;
	}
	
	public synchronized void napuni(int kolicina) {
		energija += kolicina;
		if (energija > kapacitet) energija = kapacitet;
	}
	
	public synchronized void isprazni() {
		energija = 0;
	}
	
	public boolean puna() {
		return energija == kapacitet;
	}
	
}
