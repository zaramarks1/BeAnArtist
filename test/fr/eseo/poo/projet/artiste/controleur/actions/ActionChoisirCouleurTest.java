package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirCouleurTest {

	public ActionChoisirCouleurTest() {
		testActionChoisirCouleur();
	}
	
	public void testActionChoisirCouleur() {
		JFrame  fenetre = new JFrame(ActionChoisirCouleur.NOM_ACTION);
		PanneauDessin panneau = new PanneauDessin(500,500, Color.WHITE);
		PanneauBarreOutils panneauBarreOutils =	new PanneauBarreOutils(panneau);
		
		panneau.setVisible(true);
		fenetre.add(panneauBarreOutils, BorderLayout.EAST);
				
		fenetre.add(panneau);
		fenetre.setPreferredSize(new Dimension(700,700));
		
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
				new ActionChoisirCouleurTest();
			}
		});
	}
}
