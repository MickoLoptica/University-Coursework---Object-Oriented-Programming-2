package zadatak1;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

public class Plac extends Panel {

	private int brojRedova;
	private int brojKolona;
	private Parcela izabranaParcela;
	protected ArrayList<Parcela> parcele = new ArrayList<>();
	
	public Plac(int brojRedova, int brojKolona) {
		
		this.brojRedova = brojRedova;
		this.brojKolona = brojKolona;
		
		setLayout(new GridLayout(brojRedova, brojKolona, 5, 5));
		for (int i = 0; i < brojRedova * brojKolona; i++) {
			double nasumicnost = Math.random();
			if (nasumicnost < 0.7) {
				TravnataPovrs novaTravnataPovrs = new TravnataPovrs();
				novaTravnataPovrs.roditelj = this;
				this.add(novaTravnataPovrs);
				parcele.add(novaTravnataPovrs);
			}
			else {
				VodenaPovrs novaVodenaPovrs = new VodenaPovrs();
				novaVodenaPovrs.roditelj = this;
				this.add(novaVodenaPovrs);
				parcele.add(novaVodenaPovrs);
			}
		}
		
	}

	public void izaberi(Parcela parcela) {
		
		if (izabranaParcela != null) {
			izabranaParcela.setFont(new Font("Serif", Font.BOLD, 14));
		}
		izabranaParcela = parcela;
		izabranaParcela.setFont(new Font("Serif", Font.BOLD, 20));
		repaint();
		
	}

	public void dodaj() {
		
		if (izabranaParcela != null) {
			int i = 0;
			int j = 0;
			Hidroelektrana novaHidroelektrana = new Hidroelektrana(EnergetskiSistem.baterija);
			for (Parcela p: parcele) {
				this.remove(p);
				if (p == izabranaParcela) {
					i = parcele.indexOf(p);
				}
			}
			parcele.remove(izabranaParcela);
			parcele.add(i, novaHidroelektrana);
			this.add(novaHidroelektrana);
			for (Parcela p: parcele) {
				this.add(p);
				p.roditelj = this;
			}
			
			for (Parcela p: parcele) {
				if (p instanceof Hidroelektrana) {
					j = parcele.indexOf(p);
					((Hidroelektrana) p).vodenePovrsine = 0;
					for (Parcela r: parcele) {
						if (r instanceof VodenaPovrs) {
							i = parcele.indexOf(r);
							if ((i == j - brojKolona) || (i == j + brojKolona)
									|| (i == j - 1 && j % brojKolona != 0)
									|| (i == j + 1 && ((j + 1) % brojKolona != 0 || j == 0))
									|| (i == j - brojKolona - 1 && j % brojKolona != 0)
									|| (i == j - brojKolona + 1 && (j + 1) % brojKolona != 0)
									|| (i == j + brojKolona - 1 && j % brojKolona != 0)
									|| (i == j + brojKolona + 1 && ((j + 1) % brojKolona != 0 || j == 0))) {
								((Hidroelektrana) p).vodenePovrsine++;
							}
						}
					}
				}
			}
			
			izabranaParcela = null;
			revalidate();
			repaint();
		}
	}
	
	public void zaustaviSve() {
		
		for (Parcela p: parcele) {
			if (p instanceof Proizvodjac) {
				((Proizvodjac) p).zaustavi();
			}
		}
		
	}
	
}
