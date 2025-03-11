package masina;

public class Dodavanje extends Operacija {

	private int a;
	
	public Dodavanje(int a) {
		super();
		this.a = a;
	}

	@Override
	public void izvrsi(Stek stek) {
		stek.dodaj(a);
	}

}
