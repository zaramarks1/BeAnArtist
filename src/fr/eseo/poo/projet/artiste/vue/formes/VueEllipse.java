package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Graphics2D;

import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;


public class VueEllipse extends VueForme{

	public VueEllipse(Ellipse ellipse) {
		super(ellipse);
	}
	

	@Override
	public void affiche(Graphics2D g2d) {
		
		Ellipse ellipse = (Ellipse) this.getForme();
		java.awt.Color colorG2d = g2d.getColor();
		g2d.setColor(ellipse.getCouleur());
		if(ellipse.estRempli()) {
			g2d.fillOval((int)ellipse.getPosition().getAbscisse(), (int)ellipse.getPosition().getOrdonnee(), 
				(int)ellipse.getLargeur(), (int)ellipse.getHauteur());
		}
		
		g2d.drawOval((int)ellipse.getPosition().getAbscisse(), (int)ellipse.getPosition().getOrdonnee(), 
				(int)ellipse.getLargeur(), (int)ellipse.getHauteur());
		
		g2d.setColor(colorG2d);
		
		
		
	}
}
