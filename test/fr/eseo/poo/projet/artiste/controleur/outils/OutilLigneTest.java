package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilLigneTest {
	
	
	public OutilLigneTest() {
		testOutilLigne();
	}
	
	public void testOutilLigne() {
		JFrame  fenetre = new JFrame("Test Ligne");
		//Config de l'outil ligne
		PanneauDessin panneau = new PanneauDessin();
		OutilLigne outilLigne = new OutilLigne();
		panneau.associerOutil(outilLigne);
		//outilLigne.setPanneauDessin(panneau);

		fenetre.add(panneau);
		fenetre.setPreferredSize(new Dimension(500,500));
		//fenetre.setPreferredSize(new Dimension(panneau.getWidth(), panneau.getHeight()));
		//fenetre.setSize(panneau.getWidth(), panneau.getHeight());
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
				new OutilLigneTest();
			}
		});
	}


}
