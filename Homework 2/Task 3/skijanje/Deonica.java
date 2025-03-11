package skijanje;

public abstract class Deonica {

	protected double duzina;
	protected double nagib;
	protected char oznaka;
	protected double ubrzanje;
	
	
	public Deonica(double duzina, double nagib) {
		this.duzina = duzina;
		this.nagib = nagib;
	}

	public double duzina() {
		return duzina;
	}

	public double nagib() {
		return nagib;
	}
	
	public abstract char oznaka();
	
	public abstract double ubrzanje();
	
	public double brzina(double pocetnaBrzina) {
		return Math.sqrt(2 * ubrzanje() * duzina + Math.pow(pocetnaBrzina, 2));
	}
	
	public double vreme(double pocetnaBrzina) {
		return (this.brzina(pocetnaBrzina) - pocetnaBrzina)/ubrzanje();
	}

	@Override
	public String toString() {
		return oznaka() + "(" + duzina + "," + nagib + ")";
	}
	
}
