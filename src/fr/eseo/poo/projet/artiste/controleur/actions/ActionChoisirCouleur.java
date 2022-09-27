package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;



import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirCouleur extends javax.swing.AbstractAction{
	
	private static final long serialVersionUID = 1L;
	private PanneauDessin panneauDessin;
	public static final String NOM_ACTION = "Choisir Couleur";
	
	public ActionChoisirCouleur(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		java.awt.Color inputColor =  javax.swing.JColorChooser.showDialog(this.panneauDessin, 
				NOM_ACTION, this.panneauDessin.getCouleurCourante());
		
		if(inputColor!=null) {
			this.panneauDessin.setCouleurCourante(inputColor);
		}
		
	}

}
