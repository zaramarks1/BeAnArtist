package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilEllipseTest {

	public OutilEllipseTest() {
		testEllipseLigne();
	}
	
	public void testEllipseLigne() {
		JFrame  fenetre = new JFrame("Test Outil Ellipse");
		PanneauDessin panneau = new PanneauDessin();
		OutilEllipse outilEllipse = new OutilEllipse();
		panneau.associerOutil(outilEllipse);
		
		fenetre.add(panneau);
		fenetre.setPreferredSize(new Dimension(500,500));
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		fenetre.setLocation((int) (dimension.getWidth() / 2 - (int) panneau.getWidth() / 2),
	                (int) (dimension.getHeight() / 2 - (int) panneau.getHeight() / 2));
				

		fenetre.pack();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
	}
	

	public static void main (String [] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override 
			public void run() {
				new OutilEllipseTest();
			}
		});
	}
}
