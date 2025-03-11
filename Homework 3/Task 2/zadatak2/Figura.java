package zadatak2;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Figura {

	protected Vektor polozaj;
	protected Vektor pomeraj;
	protected double r = 20;
	protected Color boja;
	protected Scena scena;
	
	public Figura(Vektor polozaj, Vektor pomeraj, double r) {
		this.polozaj = polozaj;
		this.pomeraj = pomeraj;
		this.r = r;
	}

	public Figura(Vektor polozaj, Vektor pomeraj) {
		this.polozaj = polozaj;
		this.pomeraj = pomeraj;
	}
	
	public Vektor getPolozaj() {
		return polozaj;
	}

	public void setPolozaj(Vektor polozaj) {
		this.polozaj = polozaj;
	}

	public Vektor getPomeraj() {
		return pomeraj;
	}

	public void setPomeraj(Vektor pomeraj) {
		this.pomeraj = pomeraj;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}
	
	public Color getBoja() {
		return boja;
	}

	public boolean preklapanjeVektor(Figura drugaFigura) {
		
		double x = polozaj.getX();
		double x0 = drugaFigura.getPolozaj().getX();
		double r0 = drugaFigura.getR();
		double y = polozaj.getY();
		
		if (x > x0 - r0 && x < x0 + r0 
				&& y < Math.abs(Math.sqrt(r0 * r0 - x0 * x0))) {
			return true;
		}
		else return false;
		
	}
	
	public boolean preklapanjeKruznica(Figura drugaFigura) {
		
		double r1 = this.r;
		double r2 = drugaFigura.getR();
		double x1 = polozaj.getX();
		double x2 = drugaFigura.getPolozaj().getX();
		double y1 = polozaj.getY();
		double y2 = drugaFigura.getPolozaj().getY();
		
		if (r1 + r1 < Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 -y2, 2))) {
			return false;
		}
		else return true;
		
	}
	
	public abstract void iscrtaj(Graphics g);
	
}
