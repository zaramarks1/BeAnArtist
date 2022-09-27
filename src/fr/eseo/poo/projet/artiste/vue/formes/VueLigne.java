package fr.eseo.poo.projet.artiste.vue.formes;


import java.awt.Graphics2D;
import fr.eseo.poo.projet.artiste.modele.formes.Ligne;


public class VueLigne extends VueForme{
	
	
	public VueLigne(Ligne ligne) {
		super(ligne);
	}
	

	@Override
	public void affiche(Graphics2D g2d) {
		
		Ligne ligne = (Ligne) this.getForme();
		java.awt.Color colorG2d = g2d.getColor();
		g2d.setColor(ligne.getCouleur());
		g2d.drawLine((int)ligne.getPosition().getAbscisse(), (int)ligne.getPosition().getOrdonnee(), 
				(int)ligne.getC2().getAbscisse(), (int)ligne.getC2().getOrdonnee());
		g2d.setColor(colorG2d);
		
		
	}

	

	
}
