package fr.eseo.poo.projet.artiste.controleur.outils;


import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.formes.VueLigne;

public class OutilLigne extends OutilForme {
	
	
	protected VueForme creerVueForme() {
		
		Ligne ligne = new Ligne();
		if(getDebut().getAbscisse()!=getFin().getAbscisse() || getDebut().getOrdonnee() != getFin().getOrdonnee()) {
			ligne.setC1(getDebut());
			ligne.setC2(getFin());
		}else {
			ligne.setPosition(getDebut());
		}
		ligne.setCouleur(this.getPanneauDessin().getCouleurCourante());
		VueLigne vueLigne = new VueLigne(ligne);
		return vueLigne;
	}

}
