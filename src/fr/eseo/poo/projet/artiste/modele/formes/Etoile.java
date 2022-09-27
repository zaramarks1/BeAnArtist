package fr.eseo.poo.projet.artiste.modele.formes;

import java.awt.geom.GeneralPath;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

public class Etoile extends Forme implements Remplissable {

	public static final int NOMBRE_BRANCHES_PAR_DEFAUT = 6;
	public static final double ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT = 1;
	public static final double LONGUEUR_BRANCHE_PAR_DEFAUT = 0.6;
	private List<Coordonnees> coordonnees = new ArrayList<Coordonnees>();

	public int nombreBranches;
	public double anglePremireBranche, longeurBranche;
	public boolean modeRemplissage;

	public Etoile() {
		this(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,
				ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, LONGUEUR_BRANCHE_PAR_DEFAUT);
	}

	public Etoile(double taille) {
		this(new Coordonnees(), taille, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
				LONGUEUR_BRANCHE_PAR_DEFAUT);

	}

	public Etoile(Coordonnees position) {
		this(position, Etoile.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
				LONGUEUR_BRANCHE_PAR_DEFAUT);

	}

	public Etoile(Coordonnees position, double taille) {
		this(position, taille, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
				LONGUEUR_BRANCHE_PAR_DEFAUT);
	}

	public Etoile(Coordonnees position, double taille, int nombreBranches, double anglePremireBranche,
			double longeurBranche) {
		super(position);
		this.setHauteur(taille);
		this.setAnglePremiereBranche(anglePremireBranche);
		this.setLongueurBranche(longeurBranche);
		this.setNombreBranches(nombreBranches);
		modeRemplissage = false;
		creerEtoile();
	}

	public void setPosition(Coordonnees coordonnees) {
		super.setPosition(coordonnees);
	}

	public void setHauteur(double hauteur) {
		if (hauteur >= 0) {
			super.setHauteur(hauteur);
			super.setLargeur(hauteur);

		} else {
			throw new IllegalArgumentException();
		}

		creerEtoile();

	}

	public void setLargeur(double largeur) {
		if (largeur >= 0) {
			super.setLargeur(largeur);
			super.setHauteur(largeur);
		} else {
			throw new IllegalArgumentException();
		}
		creerEtoile();
	}

	public void setNombreBranches(int nombreBranches) {
		this.nombreBranches = nombreBranches;

		if (nombreBranches < 3 || nombreBranches > 15) {
			throw new IllegalArgumentException();
		}
		creerEtoile();
	}

	public void setLongueurBranche(double longeur) {
		this.longeurBranche = longeur;
		if (longeur > 1.0 || longeur < 0.0) {
			throw new IllegalArgumentException();
		}
		creerEtoile();
	}

	public void setAnglePremiereBranche(double angle) {
		this.anglePremireBranche = angle;
		if (angle > Math.PI || angle < Math.PI * -1) {
			throw new IllegalArgumentException();
		}
		creerEtoile();
	}

	public List<Coordonnees> getCoordonnees() {
		return this.coordonnees;
	}

	public int getNombreBranches() {
		return this.nombreBranches;
	}

	public double getLongueurBranche() {
		return this.longeurBranche;
	}

	public double getAnglePremiereBranche() {
		return this.anglePremireBranche;
	}

	public String toString() {
		DecimalFormat df = new DecimalFormat("0.0#", DecimalFormatSymbols.getInstance());
		StringBuffer valeur = new StringBuffer("[Etoile] : pos (" + df.format(this.getPosition().getAbscisse()) + " , "
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
			valeur.insert(7, "-Rempli");
		}
		return valeur.toString();
	}

	@Override
	public double perimetre() {
		double perimetre = 0;
		for (int i = 0; i < this.getCoordonnees().size() - 1; i++) {
			perimetre += this.getCoordonnees().get(i).distanceVers(getCoordonnees().get(i + 1));
		}
		perimetre += this.getCoordonnees().get(0).distanceVers(getCoordonnees().get(1));
		return perimetre;
	}

	@Override
	public double aire() {

		double hauteur = this.getCoordonnees().get(1).distanceVers(this.getCoordonnees().get(3));
		double aire = (hauteur * (getLargeur() / 2) * this.getNombreBranches()) / 2;
		return aire;
	}

	@Override
	public boolean contient(Coordonnees coordonnees) {
		GeneralPath gPath = new GeneralPath();

		gPath.moveTo(getCoordonnees().get(0).getAbscisse(), getCoordonnees().get(0).getOrdonnee());

		for (int i = 1; i < getCoordonnees().size(); i++) {
			gPath.lineTo((int) Math.round(getCoordonnees().get(i).getAbscisse()),
					(int) Math.round(getCoordonnees().get(i).getOrdonnee()));
		}
		gPath.lineTo((int) Math.round(getCoordonnees().get(0).getAbscisse()),
				(int) Math.round(getCoordonnees().get(0).getOrdonnee()));

		return gPath.contains(coordonnees.getAbscisse(), coordonnees.getOrdonnee());

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

	private void creerEtoile() {
		this.getCoordonnees().clear();

		double longueurTotal = getLargeur() / 2;
		double longueurEtoile = longueurTotal - (longueurTotal * getLongueurBranche());
		double centreX = this.getCadreMaxX() - longueurTotal;
		double centreY = this.getCadreMaxY() - longueurTotal;
		int qtBranches = this.getNombreBranches();
		double angleDebut = this.getAnglePremiereBranche();
		double angleChaque = Math.PI / qtBranches;

		for (int i = 0; i < qtBranches * 2; i++) {
			double angleChaquePosition = (i * angleChaque) - angleDebut;
			double coordSommetX = Math.cos(angleChaquePosition);
			double coordSommetY = Math.sin(angleChaquePosition);

			if (i % 2 == 0) {
				this.getCoordonnees().add(new Coordonnees(centreX + (coordSommetX * longueurTotal),
						centreY + (coordSommetY * longueurTotal)));
			} else {
				this.getCoordonnees().add(new Coordonnees(centreX + (coordSommetX * longueurEtoile),
						centreY + (coordSommetY * longueurEtoile)));
			}
		}
	}

}
