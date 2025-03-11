package zadatak2;

public class Vektor {

	private double x;
	private double y;
	
	public Vektor(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vektor() {
		while (x == 0) {
			x = (Math.random() * 2) - 1;
		}
		while (y == 0) {
			y = (Math.random() * 2) - 1;
		}
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public Vektor ort() {
		Vektor ort = new Vektor(x / Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))
				, y / Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
		return ort;
	}
	
}
