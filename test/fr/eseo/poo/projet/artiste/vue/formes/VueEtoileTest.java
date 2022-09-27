package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueEtoileTest {

	
	public VueEtoileTest() {
		testEtoile();
	}
	
	public void testEtoile() {
		JFrame  fenetre = new JFrame("Test Etoile");
		
		//Config des ellipses
		PanneauDessin panneau = new PanneauDessin();

		Etoile etoile1 = new Etoile();
		etoile1.setRempli(true);
		
		VueEtoile vueEtoile1 = new VueEtoile(etoile1);
		VueEtoile vueEtoile2 = new VueEtoile (new Etoile(new Coordonnees(20,20), 40));
		VueEtoile vueEtoile3 = new VueEtoile (new Etoile(new Coordonnees(100,100), 120, 3, 1,0.7));
		

		vueEtoile1.getForme().setCouleur(java.awt.Color.GREEN);
		vueEtoile2.getForme().setCouleur(java.awt.Color.BLUE);
		vueEtoile3.getForme().setCouleur(java.awt.Color.RED);
		
		
		fenetre.add(panneau);
		fenetre.setPreferredSize(new Dimension(500,500));
		
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		fenetre.setLocation((int) (dimension.getWidth() / 2 - (int) panneau.getWidth() / 2),
	                (int) (dimension.getHeight() / 2 - (int) panneau.getHeight() / 2));
				
		//Ajoute des ellipses
		panneau.ajouterVueForme(vueEtoile1);
		panneau.ajouterVueForme(vueEtoile2);
		panneau.ajouterVueForme(vueEtoile3);

		
		//Affiche
		fenetre.pack();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
	}
	
	public static void main (String [] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override 
			public void run() {
				new VueEtoileTest();
			}
		});
	}
	

}
