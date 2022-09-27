package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

public class Cercle extends Ellipse implements Remplissable{
	
	public Cercle(Coordonnees position, double taille  ) {
		super(position, taille, taille);
		super.modeRemplissage = false;	
	}
	
	public Cercle() {
		super(Forme.LARGEUR_PAR_DEFAUT, Forme.LARGEUR_PAR_DEFAUT);
		super.modeRemplissage = false;

	}
	
	public Cercle(Coordonnees position) {
		super(position, Forme.LARGEUR_PAR_DEFAUT, Forme.LARGEUR_PAR_DEFAUT);
		super.modeRemplissage = false;

		
	}
	
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.0#", DecimalFormatSymbols.getInstance());
		StringBuffer valeur = new StringBuffer("[Cercle] : pos (" 
				+ df.format(this.getPosition().getAbscisse()) 
				+ " , "+  df.format(this.getPosition().getOrdonnee())
				+ ") dim " + df.format(this.getLargeur()) 
				+ " x " + df.format(this.getHauteur()) 
				+" périmètre : "+ df.format(this.perimetre()) 
				+ " aire : " + df.format(this.aire()));

		
		if (Locale.getDefault().getDisplayLanguage().equals("português")
				|| Locale.getDefault().getDisplayLanguage().equals("English")) {
				valeur.append(" couleur = R" + this.getCouleur().getRed() 
				+",G"+this.getCouleur().getGreen()
				+",B"+this.getCouleur().getBlue());
			
		}else {
			valeur.append(" couleur = R" + this.getCouleur().getRed() 
				+",V"+this.getCouleur().getGreen()
				+",B"+this.getCouleur().getBlue());
		}
		if(this.modeRemplissage) {
			valeur.insert(7, "-Rempli");
		}
		return valeur.toString();
				 
	}
	
	public Cercle(double taille) {
		super(taille,taille);
	}
	
	public void setHauteur(double hauteur) {
		super.setHauteur(hauteur);
		super.setLargeur(hauteur);
		}
	
	public void setLargeur(double largeur) {
		super.setHauteur(largeur);
		super.setLargeur(largeur);
	}
	
	@Override
	public double perimetre() {
		// TODO Auto-generated method stub
		return Math.PI*getLargeur();
	}
	
}
