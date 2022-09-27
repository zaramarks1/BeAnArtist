package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class Ligne extends Forme {

	Coordonnees c1;
	Coordonnees c2;
	public static final double EPSILON = 0.001;

	public Ligne(Coordonnees position, double largeur, double hauteur) {
		super(position, largeur, hauteur);

	}

	public Ligne() {
		super();

	}

	public Ligne(Coordonnees position) {
		super(position);

	}

	public Ligne(double largeur, double hauteur) {
		super(largeur, hauteur);
	}

	public Coordonnees getC1() {
		c1 = new Coordonnees(this.getPosition().getAbscisse(), this.getPosition().getOrdonnee());
		return c1;
	}

	public Coordonnees getC2() {
		c2 = new Coordonnees(this.getPosition().getAbscisse() + this.getLargeur(),
				this.getPosition().getOrdonnee() + this.getHauteur());
		return c2;
	}

	public void setC1(Coordonnees c1) {
		this.setLargeur(this.getC2().getAbscisse() - c1.getAbscisse());
		this.setHauteur(this.getC2().getOrdonnee() - c1.getOrdonnee());
		this.setPosition(c1);
	}

	public void setC2(Coordonnees c2) {
		this.getC2().setAbscisse(c2.getAbscisse());
		this.getC2().setOrdonnee(c2.getOrdonnee());
		this.setLargeur(c2.getAbscisse() - getC1().getAbscisse());
		this.setHauteur(c2.getOrdonnee() - getC1().getOrdonnee());
	}

	public String toString() {
		double degree = getC1().angleVers(getC2()) * 180 / Math.PI;
		if (degree < 0) {
			degree += 360;
		}
		DecimalFormat df = new DecimalFormat("0.0#", DecimalFormatSymbols.getInstance());
		StringBuffer valeur = new StringBuffer(
				"[Ligne] c1 : (" + df.format(getC1().getAbscisse()) + " , " + df.format(getC1().getOrdonnee())
						+ ") c2 : (" + df.format(getC2().getAbscisse()) + " , " + df.format(getC2().getOrdonnee())
						+ ") longueur : " + df.format(this.perimetre()) + " angle : " + df.format(degree) + "°");

		if (Locale.getDefault().getDisplayLanguage().equals("português")
				|| Locale.getDefault().getDisplayLanguage().equals("English")) {
			valeur.append(" couleur = R" + this.getCouleur().getRed() + ",G" + this.getCouleur().getGreen() + ",B"
					+ this.getCouleur().getBlue());
		} else {
			valeur.append(" couleur = R" + this.getCouleur().getRed() + ",V" + this.getCouleur().getGreen() + ",B"
					+ this.getCouleur().getBlue());
		}
		return valeur.toString();

	}

	@Override
	public double perimetre() {
		// TODO Auto-generated method stub
		return getC1().distanceVers(getC2());
	}

	@Override
	public double aire() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contient(Coordonnees c) {
		return c.distanceVers(this.getC1()) + c.distanceVers(this.getC2())
				- this.getC1().distanceVers(this.getC2()) <= EPSILON;

	}

}
