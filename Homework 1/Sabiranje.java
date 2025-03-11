package masina;

public class Sabiranje extends Operacija {
	
	@Override
	public void izvrsi(Stek stek) {
		int a = stek.ukloni();
		if (a == -1000) return;
		int b = stek.ukloni();
		if (b == -1000) return;
		stek.dodaj(a + b);
	}

}
