package zadatak2;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Scena extends Canvas implements Runnable{

	private boolean pauzirano = true;
	protected ArrayList<Figura> figure = new ArrayList<>();
	protected Thread crtanje;
	protected int stdPomeraj = 3;
	protected Simulacija vlasnik;
	protected int visina;
	protected int sirina;
	
	public Scena(Simulacija vlasnik) {
		
		setBackground(Color.GRAY);
		this.vlasnik = vlasnik;
		crtanje = new Thread(this);
		crtanje.start();
		
	}
	
	@Override
	public void paint(Graphics g) {
		
		for (Figura f: figure) {
			f.iscrtaj(g);
		}
		
		if (pauzirano) {
			Font font = new Font("Comic Sans MS", Font.BOLD, 20);
			FontMetrics metrika = g.getFontMetrics(font);
			int x = (sirina - metrika.stringWidth("PAUZA")) / 2;
			int y = ((visina - metrika.getHeight()) / 2) - metrika.getAscent() / 2;
			g.setFont(font);
			g.drawString("PAUZA", x, y);
		}
		
	}
	
	public void dodajFiguru(MouseEvent e) {
		
		if (pauzirano) {
			
			Vektor polozaj = new Vektor(e.getX(), e.getY());
			Vektor pomeraj = new Vektor();
			Disk noviDisk = new Disk(polozaj, pomeraj);
			noviDisk.scena = this;
			boolean crtaj = true;
			
			for (Figura f: figure) {
				int x = (int)noviDisk.getPolozaj().getX();
				int y = (int)noviDisk.getPolozaj().getY();
				int r = (int)noviDisk.getR();
				if (noviDisk.preklapanjeVektor(f) 
						|| noviDisk.preklapanjeKruznica(f)
						|| x < r || y < r 
						|| x > getWidth() - r || y > getHeight() - r) {
					crtaj = false;
				}
			}
			
			if (crtaj) {
				figure.add(noviDisk);
				noviDisk.iscrtaj(getGraphics());
			}
			
		}
		
	}
	
	public synchronized boolean radi() {
		return !pauzirano;
	}
	
	public synchronized void pauziraj() {
		
		pauzirano = true;
		
	}
	
	public synchronized void pokreni() {

		notify();
		pauzirano = false;
		
	}
	
	public synchronized void zavrsi() {
		
		crtanje.interrupt();
		pauzirano = true;
		
	}
	
	@Override
	public void run() {
		
		try {
			
			Graphics g = getGraphics();
			while (!Thread.interrupted()) {
				
				synchronized (this) {
					while (pauzirano) {
						wait();
					}
				}
				
				Thread.sleep(100);
				this.pomeranje();	
				repaint();
			}
		}
		catch (InterruptedException e) {}
		
	}
	
	public void pomeranje() {
		
		for (Figura f: figure) {
			
			double x0 = f.getPolozaj().getX();
			double y0 = f.getPolozaj().getY();
			double r0 = f.getR();
			double xNovo = x0 + f.getPomeraj().ort().getX() * stdPomeraj;
			double yNovo = y0 + f.getPomeraj().ort().getY() * stdPomeraj; 
			
			if (xNovo < r0 || xNovo > sirina - 2 * r0) {
				f.setPomeraj(new Vektor(-f.getPomeraj().getX(), f.getPomeraj().getY()));
			}
			if (yNovo < r0 || yNovo > visina - 2 * r0) {
				f.setPomeraj(new Vektor(f.getPomeraj().getX(), -f.getPomeraj().getY()));
			}
			
			f.setPolozaj(new Vektor(xNovo, yNovo));
			
			for (Figura ff: figure) {
				if (ff.equals(f)) {
					continue;
				}
				else {
					if (ff.preklapanjeKruznica(f)) {
						odbijanje(f, ff);
					}
				}
			}
			
		}
		
	}
	
	private void odbijanje(Figura f1, Figura f2) {
	
		Vektor v1 = f1.getPomeraj();
		Vektor v2 = f2.getPomeraj();
		Vektor vp1 = f1.getPolozaj();
		Vektor vp2 = f2.getPolozaj();
		Vektor v1mv2 = new Vektor(v1.getX() - v2.getX(), v1.getY() - v2.getY());
		Vektor x1mx2 = new Vektor(vp1.getX() - vp2.getX(), vp1.getY() - vp2.getY());
		double dot1 = v1mv2.getX() * x1mx2.getX() + v1mv2.getY() * x1mx2.getY();
		double moduo1 = x1mx2.getX() * x1mx2.getX() + x1mx2.getY() * x1mx2.getY();
		double konst1 = dot1 / moduo1;
		Vektor konstx1 = new Vektor(konst1 * x1mx2.getX(), konst1 * x1mx2.getY());
		Vektor v1n = new Vektor(v1.getX() - konstx1.getX(), v1.getY() - konstx1.getY());
		f1.setPomeraj(v1n);
	
		Vektor v2mv1 = new Vektor(v2.getX() - v1.getX(), v2.getY() - v1.getY());
		Vektor x2mx1 = new Vektor(vp2.getX() - vp1.getX(), vp2.getY() - vp1.getY());
		double dot2 = v2mv1.getX() * x2mx1.getX() + v2mv1.getY() * x2mx1.getY();
		double moduo2 = x2mx1.getX() * x2mx1.getX() + x2mx1.getY() * x2mx1.getY();
		double konst2 = dot2 / moduo2;
		Vektor konstx2 = new Vektor(konst2 * x2mx1.getX(), konst2 * x2mx1.getY());
		Vektor v2n = new Vektor(v2.getX() - konstx2.getX(), v2.getY() - konstx2.getY());
		f2.setPomeraj(v2n);
	
	}

}
