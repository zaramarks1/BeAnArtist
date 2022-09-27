package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Cercle;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueCercleTest {

	public VueCercleTest() {
		testEllipse();
	}
	
	public void testEllipse() {
		JFrame  fenetre = new JFrame("Test Cercle");
		
		//Config des cercles
		PanneauDessin panneau = new PanneauDessin();

		Cercle c1 = new Cercle();
		c1.setRempli(true);
		VueCercle  vueCercle1 = new VueCercle (c1);
		VueCercle  vueCercle2 = new VueCercle (new Cercle(new Coordonnees(20,20), 40));
		VueCercle  vueCercle3 = new VueCercle  (new Cercle(new Coordonnees(100,100), 120));
		
		vueCercle1.getForme().setCouleur(java.awt.Color.GREEN);
		vueCercle2.getForme().setCouleur(java.awt.Color.BLUE);
		//vueCercle3.getForme().setCouleur(java.awt.Color.RED);
		
		
		fenetre.add(panneau);
		fenetre.setPreferredSize(new Dimension(500,500));
		//fenetre.setPreferredSize(new Dimension(panneau.getWidth(), panneau.getHeight()));
		//fenetre.setSize(panneau.getWidth(), panneau.getHeight());
		
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		fenetre.setLocation((int) (dimension.getWidth() / 2 - (int) panneau.getWidth() / 2),
	                (int) (dimension.getHeight() / 2 - (int) panneau.getHeight() / 2));
				
		//Ajoute des cercles
		panneau.ajouterVueForme(vueCercle1);
		panneau.ajouterVueForme(vueCercle2);
		panneau.ajouterVueForme(vueCercle3);

		
		//Affiche
		fenetre.pack();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
	}
	

	public static void main (String [] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override 
			public void run() {
				new VueCercleTest();
			}
		});
	}
}
