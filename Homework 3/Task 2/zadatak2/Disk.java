package zadatak2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Disk extends Figura {

	protected Color boja = Color.BLUE;
	
	public Disk(Vektor polozaj, Vektor pomeraj, double r) {
		super(polozaj, pomeraj, r);
	}
	
	public Disk(Vektor polozaj, Vektor pomeraj) {
		super(polozaj, pomeraj);
	}
	
	@Override
	public void iscrtaj(Graphics g) {
		
		Color staraBoja = g.getColor();
		g.setColor(boja);
		int[] xKoordinate = {(int)getPolozaj().getX()
				, (int)(getPolozaj().getX() + getR() * Math.cos(Math.PI / 4))
				, (int)(getPolozaj().getX() + getR())
				, (int)(getPolozaj().getX() + getR() * Math.cos(Math.PI / 4))
				, (int)getPolozaj().getX()
				, (int)(getPolozaj().getX() - getR() * Math.cos(Math.PI / 4))
				, (int)(getPolozaj().getX() - getR())
				, (int)(getPolozaj().getX() - getR() * Math.cos(Math.PI / 4))};
		int[] yKoordinate = {(int)(getPolozaj().getY() - getR())
				, (int)(getPolozaj().getY() - getR() * Math.sin(Math.PI / 4))
				, (int)getPolozaj().getY()
				, (int)(getPolozaj().getY() + getR() * Math.sin(Math.PI / 4))
				, (int)(getPolozaj().getY() + getR())
				, (int)(getPolozaj().getY() + getR() * Math.sin(Math.PI / 4))
				, (int)getPolozaj().getY()
				, (int)(getPolozaj().getY() - getR() * Math.sin(Math.PI / 4))};
		
		g.fillPolygon(xKoordinate, yKoordinate, 8);
		g.setColor(staraBoja);
		
	}
	
}
