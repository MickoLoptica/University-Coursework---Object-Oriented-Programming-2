package kafic;

public class Sok extends Pice {

	public enum Vrsta {GAZIRAN, NEGAZIRAN}
	private Vrsta vrsta;
	private String oznaka;
	
	public Sok(String naziv, float zapremina, int cenaPoLitru, Vrsta vrsta) {
		super(naziv, zapremina, cenaPoLitru);
		this.vrsta = vrsta;
		if (vrsta == Vrsta.GAZIRAN) oznaka = "G";
		else oznaka = "N";
	}

	public Vrsta getVrsta() {
		return vrsta;
	}

	@Override
	public String getOznaka() {
		return oznaka;
	}
	
}
