package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Cercle;
import fr.eseo.poo.projet.artiste.vue.formes.VueCercle;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public class OutilCercle extends OutilForme{

	
	protected VueForme creerVueForme() {
		Cercle cercle = new Cercle(getDebut());
		if(getDebut().getAbscisse()==getFin().getAbscisse() && getDebut().getOrdonnee() == getFin().getOrdonnee()) {
			return new VueCercle(cercle);
		}
		double largeur = getFin().getOrdonnee()-getDebut().getOrdonnee();
		double hauteur = getFin().getAbscisse()-getDebut().getAbscisse();
		
		if(Math.abs(hauteur) > Math.abs(largeur)) {
			cercle.setLargeur(Math.abs(hauteur));
			
		}else {
			cercle.setHauteur(Math.abs(largeur));
		}
		if (largeur<0) {
			getDebut().setOrdonnee(getDebut().getOrdonnee()-cercle.getHauteur());
		}
		if(hauteur<0){
			getDebut().setAbscisse(getDebut().getAbscisse()-cercle.getLargeur());		
		}
		cercle.setPosition(getDebut());
		cercle.setCouleur(this.getPanneauDessin().getCouleurCourante());
		cercle.setRempli(this.getPanneauDessin().getModeRemplissage());
		return new VueCercle(cercle);
	
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		if(event.getClickCount() == 2) {
			setFin(new Coordonnees(getDebut().getAbscisse(), getDebut().getOrdonnee()));
			getPanneauDessin().ajouterVueForme(new VueCercle
					(new Cercle(new Coordonnees(getDebut().getAbscisse(), getDebut().getOrdonnee()))));
			getPanneauDessin().repaint();
		}
	}

}

