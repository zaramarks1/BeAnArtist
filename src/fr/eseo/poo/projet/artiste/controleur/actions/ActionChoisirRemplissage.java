package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirRemplissage extends javax.swing.AbstractAction {

	private int qtClique = 0;
	private static final long serialVersionUID = 1L;
	public static final String NOM_ACTION = "Remplir";
	public PanneauDessin panneauDessin;

	public ActionChoisirRemplissage(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (qtClique == 0) {
			this.panneauDessin.setModeRemplissage(true);
			qtClique = 1;
		} else {
			this.panneauDessin.setModeRemplissage(false);
			qtClique = 0;
		}

	}

}
