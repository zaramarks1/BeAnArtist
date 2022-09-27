package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coloriable;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;

abstract public class Forme implements Coloriable {

	public static final double LARGEUR_PAR_DEFAUT = 20;
	public static final double HAUTEUR_PAR_DEFAUT = 30;
	public static final java.awt.Color COULEUR_PAR_DEFAUT = javax.swing.UIManager.getColor("Panel.foreground");
	private double largeur;
	private double hauteur;
	private Coordonnees position;
	private java.awt.Color color;

	public Forme() {
		this(new Coordonnees(), LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);

	}

	public Forme(double largeur, double hauteur) {
		this(new Coordonnees(), largeur, hauteur);

	}

	public Forme(Coordonnees coordonnees) {
		this(coordonnees, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}

	public Forme(Coordonnees coordonnees, double largeur, double hauteur) {
		this.position = coordonnees;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.color = COULEUR_PAR_DEFAUT;
	}

	public Coordonnees getPosition() {
		return this.position;
	}

	public void setPosition(Coordonnees coordonnees) {
		this.position.setAbscisse(coordonnees.getAbscisse());
		this.position.setOrdonnee(coordonnees.getOrdonnee());

	}

	public double getLargeur() {
		return this.largeur;
	}

	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}

	public double getHauteur() {
		return this.hauteur;
	}

	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}

	public void deplacerDe(double deltaX, double deltaY) {
		getPosition().deplacerDe(deltaX, deltaY);

	}

	public void deplacerVers(double nouvelleAbscisse, double nouvelleOrdonnee) {
		this.position.deplacerVers(nouvelleAbscisse, nouvelleOrdonnee);
	}

	public double getCadreMinX() {

		if (this.largeur < 0) {
			return position.getAbscisse() + largeur;
		} else {
			return position.getAbscisse();
		}

	}

	public double getCadreMinY() {

		if (this.hauteur < 0) {
			return position.getOrdonnee() + this.hauteur;
		} else {
			return position.getOrdonnee();
		}

	}

	public double getCadreMaxX() {
		if (largeur > 0) {
			return position.getAbscisse() + this.largeur;
		} else {
			return position.getAbscisse();
		}

	}

	public double getCadreMaxY() {
		if (this.hauteur > 0) {
			return position.getOrdonnee() + this.hauteur;
		} else {
			return position.getOrdonnee();
		}
	}

	abstract public double perimetre();

	abstract public double aire();

	abstract public boolean contient(Coordonnees x);

	@Override
	public void setCouleur(java.awt.Color color) {
		this.color = color;
	}

	@Override
	public java.awt.Color getCouleur() {
		return this.color;
	}

}
