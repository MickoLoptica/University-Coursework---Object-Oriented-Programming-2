package zadatak2;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Simulacija extends Frame {

	protected Label pauza = new Label("PAUZA");
	protected Scena scena = new Scena(this);
	
	public Simulacija() {
		
			setBounds(700, 200, 400, 300);
			setResizable(false);
			setTitle("Simulacija");
			
			add(scena, BorderLayout.CENTER);
			
			scena.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char key = Character.toUpperCase(e.getKeyChar());
					switch(key) {
					case KeyEvent.VK_ESCAPE: {
						scena.zavrsi();
						dispose();
						break;
					}
					case KeyEvent.VK_SPACE: {
						if (scena.radi()) {
							scena.pauziraj();
						}
						else {
							scena.pokreni();
						}
						break;
					}
					}
					scena.repaint();
				}
			});
			
			scena.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					scena.dodajFiguru(e);
					repaint();
				}
			});
			
			scena.visina = getHeight();
			scena.sirina = getWidth();
			
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					scena.zavrsi();
					dispose();
				}
			});
			
			setVisible(true);
			
	}
	
	public static void main(String[] args) {
		new Simulacija();
	}
	
}
