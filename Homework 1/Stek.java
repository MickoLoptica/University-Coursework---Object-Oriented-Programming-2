package masina;

public class Stek {

	private int kap;
	private int next = 0;
	private int[] stek;
	
	public Stek(int k) {
		kap = k;
		stek = new int[k];
	}
	
	public void dodaj(int x) {
		if (next == kap) {
			return;
		}
		stek[next++] = x;
	}

	public int ukloni() {
		if (next == 0) {
			return -1000;
		}
		return stek[--next];
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (int i = 0; i < next; i++) {
			if (i != 0) {
				sb.append(',');
			}
			sb.append(stek[i]);
		}
		sb.append(']');
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Stek s = new Stek(5);
		s.dodaj(3);
		s.dodaj(2);
		s.dodaj(4);
		System.out.println(s);
	}
	
}
