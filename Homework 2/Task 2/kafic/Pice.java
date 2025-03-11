package kafic;

public abstract class Pice {

	private String naziv;
	private float zapremina;
	private float cena;
	
	public Pice(String naziv, float zapremina, int cenaPoLitru) {
		this.naziv = naziv;
		this.zapremina = zapremina;
		this.cena = zapremina * cenaPoLitru;
	}

	public String getNaziv() {
		return naziv;
	}

	public float getZapremina() {
		return zapremina;
	}

	public float getCena() {
		return cena;
	}
	
	public abstract String getOznaka();

	@Override
	public String toString() {
		return naziv + " (" + String.format("%.2f",zapremina) + " L): " 
				+ String.format("%.2f", cena) + " RSD";
	}
	
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Pice)) return false;
		else {
			Pice drugoPice = (Pice) o;
			if ((this.getNaziv().equals(drugoPice.getNaziv())) 
					&& (this.getZapremina() == drugoPice.getZapremina())) {
				return true;
			}
			else return false;
		}
	}

}
