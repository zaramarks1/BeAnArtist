package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

public class Ellipse extends Forme implements Remplissable {

	public boolean modeRemplissage;

	public Ellipse(Coordonnees position, double largeur, double hauteur) {
		setPosition(position);
		setHauteur(hauteur);
		setLargeur(largeur);
		this.modeRemplissage = false;
	}

	public Ellipse() {
		super();
		this.modeRemplissage = false;
	}

	public Ellipse(Coordonnees position) {
		super(position);
		this.modeRemplissage = false;
	}

	public Ellipse(double largeur, double hauteur) {
		this(new Coordonnees(), largeur, hauteur);
	}

	public void setHauteur(double hauteur) {
		if (hauteur >= 0) {
			super.setHauteur(hauteur);
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void setLargeur(double largeur) {
		if (largeur >= 0) {
			super.setLargeur(largeur);
		} else {
			throw new IllegalArgumentException();
		}
	}

	public String toString() {
		DecimalFormat df = new DecimalFormat("0.0#", DecimalFormatSymbols.getInstance());
		StringBuffer valeur = new StringBuffer("[Ellipse] : pos (" + df.format(this.getPosition().getAbscisse()) + " , "
				+ df.format(this.getPosition().getOrdonnee()) + ") dim " + df.format(this.getLargeur()) + " x "
				+ df.format(this.getHauteur()) + " périmètre : " + df.format(this.perimetre()) + " aire : "
				+ df.format(this.aire()));
		if (Locale.getDefault().getDisplayLanguage().equals("português")
				|| Locale.getDefault().getDisplayLanguage().equals("English")) {
			valeur.append(" couleur = R" + this.getCouleur().getRed() + ",G" + this.getCouleur().getGreen() + ",B"
					+ this.getCouleur().getBlue());
		} else {
			valeur.append(" couleur = R" + this.getCouleur().getRed() + ",V" + this.getCouleur().getGreen() + ",B"
					+ this.getCouleur().getBlue());
		}
		if (this.modeRemplissage) {
			valeur.insert(8, "-Rempli");
		}
		return valeur.toString();
	}

	@Override
	public double perimetre() {
		// TODO Auto-generated method stub

		double a = this.getHauteur() / 2;
		double b = this.getLargeur() / 2;
		double h = Math.pow(Math.abs(a - b) / (a + b), 2);

		return Math.PI * (a + b) * (1 + (3 * h / (10 + Math.sqrt(4 - 3 * h))));
	}

	@Override
	public double aire() {
		// TODO Auto-generated method stub
		return Math.PI * getLargeur() * getHauteur() / 4;
	}

	@Override
	public boolean contient(Coordonnees c) {
		double x = c.getAbscisse();
		double y = c.getOrdonnee();
		double a = this.getLargeur() / 2;
		double b = this.getHauteur() / 2;
		double k = this.getCadreMaxY() - this.getHauteur() / 2;
		double h = this.getCadreMaxX() - this.getLargeur() / 2;

		return (Math.pow((x - h), 2) / Math.pow(a, 2)) + (Math.pow((y - k), 2) / Math.pow(b, 2)) <= 1;

	}

	@Override
	public boolean estRempli() {
		// TODO Auto-generated method stub
		return this.modeRemplissage;
	}

	@Override
	public void setRempli(boolean modeRemplissage) {
		this.modeRemplissage = modeRemplissage;

	}

}
