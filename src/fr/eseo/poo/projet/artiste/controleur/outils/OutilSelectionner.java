package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;


public class OutilSelectionner extends Outil{
	
	public Forme formeSelectionnee;
	//public PanneauDessin panneauDessin;
	
	
	public OutilSelectionner() {
		super();
		
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		
		 formeSelectionnee = null;
			for(int i=0;i<super.getPanneauDessin().getVueFormes().size();i++) {
				if (super.getPanneauDessin().getVueFormes().get(i).getForme().contient(
						new Coordonnees(event.getX(), event.getY()))) {
					this.formeSelectionnee=super.getPanneauDessin().getVueFormes().get(i).getForme();
				}
			}	
		if(formeSelectionnee!=null) {
				JOptionPane.showConfirmDialog(super.getPanneauDessin(), 
					formeSelectionnee.toString(), ActionSelectionner.NOM_ACTION, 
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
		
	
}
