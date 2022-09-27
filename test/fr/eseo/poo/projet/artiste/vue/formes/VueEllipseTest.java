package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueEllipseTest {

	
	public VueEllipseTest() {
		testEllipse();
	}
	
	public void testEllipse() {
		JFrame  fenetre = new JFrame("Test Ellipse");
		
		//Config des ellipses
		PanneauDessin panneau = new PanneauDessin();

		Ellipse e1 = new Ellipse();
		e1.setRempli(true);
		
		VueEllipse vueEllipse1 = new VueEllipse(e1);
		VueEllipse vueEllipse2 = new VueEllipse (new Ellipse(new Coordonnees(20,20), 40,50));
		VueEllipse vueEllipse3 = new VueEllipse (new Ellipse(new Coordonnees(100,100), 120,240));
		

		vueEllipse1.getForme().setCouleur(java.awt.Color.GREEN);
		vueEllipse2.getForme().setCouleur(java.awt.Color.BLUE);
		vueEllipse3.getForme().setCouleur(java.awt.Color.RED);
		
		
		fenetre.add(panneau);
		fenetre.setPreferredSize(new Dimension(500,500));
		//fenetre.setPreferredSize(new Dimension(panneau.getWidth(), panneau.getHeight()));
		//fenetre.setSize(panneau.getWidth(), panneau.getHeight());
		
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		fenetre.setLocation((int) (dimension.getWidth() / 2 - (int) panneau.getWidth() / 2),
	                (int) (dimension.getHeight() / 2 - (int) panneau.getHeight() / 2));
				
		//Ajoute des ellipses
		panneau.ajouterVueForme(vueEllipse1);
		panneau.ajouterVueForme(vueEllipse2);
		panneau.ajouterVueForme(vueEllipse3);

		
		//Affiche
		fenetre.pack();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
	}
	

	public static void main (String [] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override 
			public void run() {
				new VueEllipseTest();
			}
		});
	}
}
