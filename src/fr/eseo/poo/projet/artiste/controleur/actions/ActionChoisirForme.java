package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilCercle;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilEllipse;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilEtoile;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirForme extends javax.swing.AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String NOM_ACTION_LIGNE = "Creer Ligne";
	public static final String NOM_ACTION_ELLIPSE = "Creer Ellipse";
	public static final String NOM_ACTION_CERCLE = "Creer Cercle";
	public static final String NOM_ACTION_ETOILE = "Creer Etoile";
	
	PanneauDessin panneauDessin;
	PanneauBarreOutils panneauOutils;
	
	public ActionChoisirForme(PanneauDessin panneauDessin, PanneauBarreOutils panneauOutils, String action) {
		super(action);
		this.panneauDessin = panneauDessin;
		this.panneauOutils = panneauOutils;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
		if (e.getActionCommand().equals(NOM_ACTION_LIGNE)) {
			panneauDessin.associerOutil(new OutilLigne());
		}else if(e.getActionCommand().equals(NOM_ACTION_ELLIPSE)) {
			//action = NOM_ACTION_ELLIPSE;
			panneauDessin.associerOutil(new OutilEllipse());
		}else if (e.getActionCommand().equals(NOM_ACTION_CERCLE)) {
			//action = NOM_ACTION_CERCLE;
			panneauDessin.associerOutil(new OutilCercle());
		}else if (e.getActionCommand().equals(NOM_ACTION_ETOILE)) {
				//action = NOM_ACTION_CERCLE;
				panneauDessin.associerOutil(new OutilEtoile(panneauOutils));
		}
		
	}
	
}
