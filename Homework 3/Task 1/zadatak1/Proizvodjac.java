package zadatak1;

import java.awt.Color;
import java.util.Random;

public abstract class Proizvodjac extends Parcela implements Runnable {

	protected int vreme;
	protected Baterija baterija;
	protected Thread proizvodnja;
	
	Proizvodjac(char oznaka, Color pozadina, int vreme, Baterija baterija) {
		super(oznaka, pozadina);
		this.vreme = vreme;
		this.baterija = baterija;
		proizvodnja = new Thread(this);
		proizvodnja.start();
	}
	
	public void zaustavi() {
		proizvodnja.interrupt();
	}
	
	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Thread.sleep(vreme + new Random().nextInt(300));
				proizvedi();
				Thread.sleep(300);
				setForeground(Color.WHITE);
				repaint();
			}
		}
		catch (InterruptedException e) {}
		
	}

	public abstract void proizvedi();

}
