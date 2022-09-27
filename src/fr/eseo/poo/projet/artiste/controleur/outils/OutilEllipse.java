package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.poo.projet.artiste.vue.formes.VueEllipse;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public class OutilEllipse extends OutilForme{

	@Override
	protected VueForme creerVueForme() {
		Ellipse ellipse = new Ellipse();
		
		
	if(getDebut().getAbscisse()==getFin().getAbscisse() && getDebut().getOrdonnee() == getFin().getOrdonnee()) {
		ellipse.setPosition(getDebut());
		return new VueEllipse(ellipse);
	}
	
	double hauteur = getFin().getOrdonnee()-getDebut().getOrdonnee();
	double largeur = getFin().getAbscisse()-getDebut().getAbscisse();

	if (hauteur<0) {
		getDebut().setOrdonnee(getFin().getOrdonnee());
		getFin().setOrdonnee(getFin().getOrdonnee()-hauteur);
	}
	
	if(largeur<0){
		getDebut().setAbscisse(getFin().getAbscisse());
		getFin().setAbscisse(getFin().getAbscisse()-largeur);
	}

		ellipse.setPosition(getDebut());
		ellipse.setHauteur(Math.abs(hauteur));
		ellipse.setLargeur(Math.abs(largeur));
		ellipse.setCouleur(this.getPanneauDessin().getCouleurCourante());
		ellipse.setRempli(this.getPanneauDessin().getModeRemplissage());
		return new VueEllipse(ellipse);
	}

}
