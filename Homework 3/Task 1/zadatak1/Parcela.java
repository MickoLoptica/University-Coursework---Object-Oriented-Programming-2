package zadatak1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Parcela extends Label {

	protected char oznaka;
	protected Color pozadina;
	protected Plac roditelj;
	
	public Parcela(char oznaka, Color pozadina) {
		
		this.oznaka = oznaka;
		this.pozadina = pozadina;
		
		this.setText("" + oznaka);
		this.setBackground(pozadina);
		this.setForeground(Color.WHITE);
		this.setAlignment(CENTER);
		this.setFont(new Font("Serif", Font.BOLD, 14));
		
		addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			roditelj.izaberi(Parcela.this);
		}
		});
		
	}
	
	public void promeniPozadinu(Color pozadina) {
		this.pozadina = pozadina;
		repaint();
	}
	
	
	
}
