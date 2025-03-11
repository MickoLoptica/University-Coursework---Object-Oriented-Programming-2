package kafic;

import java.util.LinkedList;

public class KartaPica {

	LinkedList<Pice> pica = new LinkedList<>();
	
	public void dodajPice(Pice pice) throws GPostoji {
		for (Pice p: pica) {
			if (p.equals(pice)) throw new GPostoji();
		}
		pica.add(pice);
	}
	
	public int getBrojPica() {
		return pica.size();
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("GAZIRANI SOKOVI");
		for (Pice p: pica) {
			if (p.getOznaka() == "G") {
				s.append("\n");
				s.append(p);
			}
		}
		s.append("\n");
		s.append("NEGAZIRANI SOKOVI");
		for (Pice p: pica) {
			if (p.getOznaka() == "N") {
				s.append("\n");
				s.append(p);
			}
		}
		return s.toString();
	}
	
	
	
}
