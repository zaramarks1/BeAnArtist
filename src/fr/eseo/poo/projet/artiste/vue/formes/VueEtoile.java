package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Graphics2D;
import java.awt.geom.Path2D;

import fr.eseo.poo.projet.artiste.modele.formes.Etoile;

public class VueEtoile extends VueForme{
	
	public VueEtoile(Etoile etoile) {
		super(etoile);
	}

	@Override
	public void affiche(Graphics2D g2d) {
		Etoile etoile = (Etoile) this.getForme();
		java.awt.Color colorG2d = g2d.getColor();
		g2d.setColor(etoile.getCouleur());
		Path2D path = new Path2D.Double();
		
		path.moveTo(etoile.getCoordonnees().get(0).getAbscisse(), 
				etoile.getCoordonnees().get(0).getOrdonnee());
		
		for(int i=1; i < etoile.getCoordonnees().size();i++) {
				path.lineTo((int)Math.round(etoile.getCoordonnees().get(i).getAbscisse()), 
						(int)Math.round(etoile.getCoordonnees().get(i).getOrdonnee()));
		}
		
		path.lineTo((int)Math.round(etoile.getCoordonnees().get(0).getAbscisse()), 
				(int)Math.round(etoile.getCoordonnees().get(0).getOrdonnee()));
		
		if(etoile.estRempli()) {
			g2d.fill(path);
		}
		
		g2d.draw(path);
		
		g2d.setColor(colorG2d);
		
	}

}
