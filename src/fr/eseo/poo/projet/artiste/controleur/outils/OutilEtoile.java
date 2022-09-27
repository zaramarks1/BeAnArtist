package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;
import fr.eseo.poo.projet.artiste.vue.formes.VueEtoile;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;

public class OutilEtoile extends OutilForme {
	
	PanneauBarreOutils panneauBarreOutil;
	public OutilEtoile(PanneauBarreOutils panneauBarreOutil) {
		this.panneauBarreOutil = panneauBarreOutil;
	}

	@Override
	protected VueForme creerVueForme() {
		Etoile etoile = new Etoile();
		
		//etoile.setLargeur(Math.abs((getFin().getOrdonnee()-getDebut().getOrdonnee())*2));
		etoile.setLargeur(getFin().distanceVers(getDebut())*2);
		etoile.setAnglePremiereBranche(getDebut().angleVers(getFin()));
		etoile.setPosition(new Coordonnees(getFin().getAbscisse()-etoile.getLargeur()/2,
				getFin().getOrdonnee() - etoile.getLargeur()/2));
		
		etoile.setCouleur(this.getPanneauDessin().getCouleurCourante());
		etoile.setRempli(this.getPanneauDessin().getModeRemplissage());
		etoile.setNombreBranches(panneauBarreOutil.getNbBranches());
		etoile.setLongueurBranche(panneauBarreOutil.getLongueurBranche());
		return new VueEtoile(etoile);
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		if(event.getClickCount() == 2) {
			setFin(new Coordonnees(getDebut().getAbscisse(), getDebut().getOrdonnee()));
			getPanneauDessin().ajouterVueForme(new VueEtoile
					(new Etoile(new Coordonnees(getDebut().getAbscisse()
							, getDebut().getOrdonnee()), Etoile.LARGEUR_PAR_DEFAUT)));
			getPanneauDessin().repaint();
		}
	}

}
