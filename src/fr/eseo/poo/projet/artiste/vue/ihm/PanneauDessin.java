package fr.eseo.poo.projet.artiste.vue.ihm;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import fr.eseo.poo.projet.artiste.controleur.outils.Outil;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public class PanneauDessin extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;
	public static final int LARGEUR_PAR_DEFAUT = 500;
	public static final int HAUTEUR_PAR_DEFAUT = 500;
	public static final java.awt.Color COULEUR_FOND_PAR_DEFAUT = java.awt.Color.WHITE;
	private final List<VueForme> vueFormes = new ArrayList<VueForme>();
	private Outil outilCourant;
	private java.awt.Color color;
	private boolean modeRemplissage;

	public PanneauDessin() {
		super();
		super.setPreferredSize(new Dimension(LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT));
		super.setBackground(COULEUR_FOND_PAR_DEFAUT);
		this.color = Forme.COULEUR_PAR_DEFAUT;
		this.modeRemplissage = false;

	}

	public PanneauDessin(int largeur, int hauteur, java.awt.Color c) {
		super();
		super.setPreferredSize(new Dimension(largeur, hauteur));
		super.setBackground(c);
		this.color = Forme.COULEUR_PAR_DEFAUT;
		this.modeRemplissage = false;
	}

	public List<VueForme> getVueFormes() {
		return this.vueFormes;
	}

	public void ajouterVueForme(VueForme vueForme) {
		this.vueFormes.add(vueForme);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();

		for (int i = 0; i < vueFormes.size(); i++) {
			getVueFormes().get(i).affiche(g2d);
		}

		g2d.dispose();
	}

	public Outil getOutilCourant() {
		return this.outilCourant;
	}

	private void setOutilCourant(Outil outilCourant) {
		this.outilCourant = outilCourant;
	}

	public void associerOutil(Outil outilCourant) {
		if (outilCourant != null) {
			if (getOutilCourant() != null) {
				this.dissocierOutil();
			}
			setOutilCourant(outilCourant);
			outilCourant.setPanneauDessin(this);
			addMouseListener(outilCourant);
			addMouseMotionListener(outilCourant);
		}

	}

	private void dissocierOutil() {
		if (getOutilCourant() != null) {
			this.outilCourant.setPanneauDessin(null);
			removeMouseListener(outilCourant);
			removeMouseMotionListener(outilCourant);
			setOutilCourant(null);
		}

	}

	public java.awt.Color getCouleurCourante() {
		return this.color;

	}

	public void setCouleurCourante(java.awt.Color color) {
		this.color = color;
	}

	public boolean getModeRemplissage() {
		return this.modeRemplissage;
	}

	public void setModeRemplissage(boolean modeRemplissage) {
		this.modeRemplissage = modeRemplissage;
	}

}
