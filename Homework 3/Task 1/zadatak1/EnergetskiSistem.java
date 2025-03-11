package zadatak1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EnergetskiSistem extends Frame {

	protected static Baterija baterija;
	
	public EnergetskiSistem(int brojRedova, int brojKolona, int kapacitet) {
		
		baterija = new Baterija(kapacitet);
		
		setBounds(700, 200, 500, 500);
		setResizable(false);
		setTitle("Energetski sistem");
		
		Panel gornjiDeo = new Panel();
		Button dodaj = new Button("Dodaj");
		
		gornjiDeo.add(dodaj);
		add(gornjiDeo, BorderLayout.NORTH);
		
		Plac plac = new Plac(brojRedova, brojKolona);
		add(plac, BorderLayout.CENTER);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				plac.zaustaviSve();
				dispose();
			}
		});
		
		dodaj.addActionListener((ae) -> {
			plac.dodaj();
		});
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new EnergetskiSistem(5, 5, 100);
	}

}
