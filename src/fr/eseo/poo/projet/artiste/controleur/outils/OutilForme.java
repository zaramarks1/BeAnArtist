package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;


abstract public class OutilForme extends Outil{

	@Override
	public void mouseClicked(MouseEvent event) {
		
		if(event.getClickCount() == 2) {
			setFin(new Coordonnees(getDebut().getAbscisse(), getDebut().getOrdonnee()));
			VueForme vueForme = creerVueForme();
			getPanneauDessin().ajouterVueForme(vueForme);
			getPanneauDessin().repaint();
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent event) {
		super.mouseReleased(event);
		if(getDebut().getAbscisse()!=getFin().getAbscisse() || getDebut().getOrdonnee() != getFin().getOrdonnee()) {
			
			VueForme vueForme = creerVueForme();
			getPanneauDessin().ajouterVueForme(vueForme);
			getPanneauDessin().repaint();
			
		}
	}
	
	 protected abstract VueForme creerVueForme() ;
}
