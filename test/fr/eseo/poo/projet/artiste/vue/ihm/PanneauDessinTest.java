package fr.eseo.poo.projet.artiste.vue.ihm;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class PanneauDessinTest {

	public PanneauDessinTest() {
		testConstructeurParDefaut();
		testConstructeur();
	}
	
	private void testConstructeur() {
		JFrame  fenetre = new JFrame("Blues du Businessman");
		PanneauDessin panneau = new PanneauDessin(500,500, new java.awt.Color(255,255,255));
		implementsConstructeur(panneau, fenetre);
	}
	
	private void testConstructeurParDefaut() {
		JFrame  fenetre = new JFrame("Etre un Artiste");
		PanneauDessin panneau = new PanneauDessin();
		implementsConstructeur(panneau, fenetre);
	}
	
	public void implementsConstructeur(PanneauDessin panneau, JFrame fenetre) {
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
				new PanneauDessinTest();
			}
		});
	}
}
