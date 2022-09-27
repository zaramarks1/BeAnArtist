package fr.eseo.poo.projet.artiste.modele;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Coordonnees {

	public static final double ABSCISSE_PAR_DEFAUT = 0;
	public static final double ORDONNEE_PAR_DEFAUT = 0;

	public double abcsisse;
	public double ordonnee;

	public Coordonnees() {
		this(ABSCISSE_PAR_DEFAUT, ORDONNEE_PAR_DEFAUT);
	}

	public Coordonnees(double abcsisse, double ordonnee) {
		this.abcsisse = abcsisse;
		this.ordonnee = ordonnee;
	}

	public double getAbscisse() {
		return this.abcsisse;
	}

	public double getOrdonnee() {
		return this.ordonnee;
	}

	public void setAbscisse(double abcsisse) {
		this.abcsisse = abcsisse;
	}

	public void setOrdonnee(double ordonnee) {
		this.ordonnee = ordonnee;
	}

	public void deplacerDe(double deltaX, double deltaY) {
		this.setAbscisse(this.getAbscisse() + deltaX);
		this.setOrdonnee(this.getOrdonnee() + deltaY);
	}

	public void deplacerVers(double x, double y) {
		this.setAbscisse(x);
		this.setOrdonnee(y);
	}

	public double distanceVers(Coordonnees c) {
		return Math.sqrt(
				Math.pow(c.getAbscisse() - this.getAbscisse(), 2) + Math.pow(c.getOrdonnee() - this.getOrdonnee(), 2));
	}

	public double angleVers(Coordonnees c) {
		return Math.atan2(c.getOrdonnee() - this.getOrdonnee(), c.getAbscisse() - this.getAbscisse());
	}

	public String toString() {
		DecimalFormat df = new DecimalFormat("0.0#", DecimalFormatSymbols.getInstance());
		return "(" + df.format(this.getAbscisse()) + " , " + df.format(this.getOrdonnee()) + ")";
	}
}
