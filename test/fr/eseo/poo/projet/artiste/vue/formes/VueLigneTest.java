package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Dimension;


import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueLigneTest {

	
	public VueLigneTest() {
		testLigne();
	}
	
	public void testLigne() {
		JFrame  fenetre = new JFrame("Test Ligne");
		
		//Config des lignes
		PanneauDessin panneau = new PanneauDessin();
		
		VueLigne vueLigne1 = new VueLigne( new Ligne(20,10));
		VueLigne vueLigne2 = new VueLigne(new Ligne(new Coordonnees(50,50),10,10));
		VueLigne vueLigne3 = new VueLigne(new Ligne(new Coordonnees(100,200),100,50));
		
		vueLigne1.getForme().setCouleur(java.awt.Color.GREEN);
		vueLigne2.getForme().setCouleur(java.awt.Color.BLUE);
		
		
		//vueLigne3.getForme().setCouleur(java.awt.Color.RED);
		
		fenetre.add(panneau);
		fenetre.setPreferredSize(new Dimension(500,500));
		//fenetre.setPreferredSize(new Dimension(panneau.getWidth(), panneau.getHeight()));
		//fenetre.setSize(panneau.getWidth(), panneau.getHeight());
		
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		fenetre.setLocation((int) (dimension.getWidth() / 2 - (int) panneau.getWidth() / 2),
	                (int) (dimension.getHeight() / 2 - (int) panneau.getHeight() / 2));
				
		//Ajoute des lignes 
		panneau.ajouterVueForme(vueLigne1);
		panneau.ajouterVueForme(vueLigne2);
		panneau.ajouterVueForme(vueLigne3);
		
		//Affiche
		fenetre.pack();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
	}
	

	public static void main (String [] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override 
			public void run() {
				new VueLigneTest();
			}
		});
	}
}
