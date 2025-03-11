package zadatak1;

import java.awt.Color;

public class Hidroelektrana extends Proizvodjac {

	protected int vodenePovrsine = 0; 
	
	public Hidroelektrana(Baterija baterija) {
		super('H', Color.BLUE, 1500, baterija);
	}

	@Override
	public void proizvedi() {
		
		if (vodenePovrsine > 0) {
			setForeground(Color.RED);
			this.baterija.napuni(vodenePovrsine);
			repaint();
		}
		
	}
	
}
