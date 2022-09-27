package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionEffacer extends  javax.swing.AbstractAction{
	
	private static final long serialVersionUID = 1L;
	
	public static final String NOM_ACTION = "Effacer Tout";
	public PanneauDessin panneauDessin;
	
	public ActionEffacer(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin= panneauDessin;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
			int input = JOptionPane.showConfirmDialog(this.panneauDessin, NOM_ACTION, NOM_ACTION, JOptionPane.YES_NO_OPTION);
			if (input == JOptionPane.YES_OPTION) {
				this.panneauDessin.getVueFormes().clear();
				this.panneauDessin.repaint();
			}
		}
		
		
	
}
