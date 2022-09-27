package fr.eseo.poo.projet.artiste.controleur.outils;


import java.awt.event.MouseEvent;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

abstract public class Outil implements javax.swing.event.MouseInputListener{
	
	private  PanneauDessin panneauDessin = new PanneauDessin();
	private Coordonnees debut, fin;
	
	public PanneauDessin getPanneauDessin() {
		//this.panneauDessin.addMouseListener(this);
		return this.panneauDessin;
		
	}
	
	public void setPanneauDessin(PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
	}
	
	//get debut
	public Coordonnees getDebut() {
		return this.debut;
	}
	
	//get fin
	public Coordonnees getFin() {
		return this.fin;
	}
	
	public void setDebut(Coordonnees debut) {
		this.debut = debut;
	}
	
	public void setFin(Coordonnees fin) {
		this.fin = fin;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		setDebut(new Coordonnees(e.getX(), e.getY()));
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		setFin(new Coordonnees(e.getX(), e.getY()));
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	
		
	}
	
	

	
}
