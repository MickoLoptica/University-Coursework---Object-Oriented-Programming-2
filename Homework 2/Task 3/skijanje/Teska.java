package skijanje;

public class Teska extends Deonica {
	
	public Teska(double duzina, double nagib) {
		super(duzina, nagib);
		ubrzanje = 9.81 * Math.sin((nagib * Math.PI)/180);
		oznaka = 'T';
	}

	@Override
	public char oznaka() {
		return oznaka;
	}

	@Override
	public double ubrzanje() {
		return ubrzanje;
	}
	
}
