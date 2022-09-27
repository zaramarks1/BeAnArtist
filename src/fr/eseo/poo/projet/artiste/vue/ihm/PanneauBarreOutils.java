package fr.eseo.poo.projet.artiste.vue.ihm;

import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirRemplissage;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;

public class PanneauBarreOutils extends javax.swing.JPanel {

	private PanneauDessin panneauDessin;
	private static final long serialVersionUID = 1L;
	public static final String BRANCHE_SPINNER_NOM = "Nb Branches etoile";
	public static final String LONGUEUR_SPINNER_NOM = "Longueur etoile";

	// JToolBar tb = new JToolBar(JToolBar.VERTICAL);

	javax.swing.BoxLayout boxLayout;
	JButton jButtonEffacer, jbuttonChoisirCouleur;

	JSpinner spinnerBranche, spinnerLongueur;

	public PanneauBarreOutils(PanneauDessin panneauDessin) {
		super();
		this.panneauDessin = panneauDessin;
		boxLayout = new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS);
		setLayout(boxLayout);
		initComponents();
	}

	public void initComponents() {
		this.add(panneauDessin);
		ActionEffacer actionEffacer = new ActionEffacer(this.panneauDessin);

		jButtonEffacer = new JButton(actionEffacer);
		jButtonEffacer.setName(ActionEffacer.NOM_ACTION);
		jButtonEffacer.setVisible(true);
		this.add(jButtonEffacer);

		javax.swing.ButtonGroup buttonGroup = new javax.swing.ButtonGroup();

		ActionChoisirForme choisirFormeLigne = new ActionChoisirForme(this.panneauDessin, this,
				ActionChoisirForme.NOM_ACTION_LIGNE);
		ActionChoisirForme choisirFormeEllipse = new ActionChoisirForme(this.panneauDessin, this,
				ActionChoisirForme.NOM_ACTION_ELLIPSE);
		ActionChoisirForme choisirFormeCercle = new ActionChoisirForme(this.panneauDessin, this,
				ActionChoisirForme.NOM_ACTION_CERCLE);
		ActionChoisirForme choisirFormeEtoile = new ActionChoisirForme(this.panneauDessin, this,
				ActionChoisirForme.NOM_ACTION_ETOILE);

		javax.swing.JToggleButton buttonLigne = new javax.swing.JToggleButton(choisirFormeLigne);
		buttonLigne.setName(ActionChoisirForme.NOM_ACTION_LIGNE);
		javax.swing.JToggleButton buttonEllipse = new javax.swing.JToggleButton(choisirFormeEllipse);
		buttonEllipse.setName(ActionChoisirForme.NOM_ACTION_ELLIPSE);
		javax.swing.JToggleButton buttonCercle = new javax.swing.JToggleButton(choisirFormeCercle);
		buttonCercle.setName(ActionChoisirForme.NOM_ACTION_CERCLE);
		javax.swing.JToggleButton buttonEtoile = new javax.swing.JToggleButton(choisirFormeEtoile);
		buttonEtoile.setName(ActionChoisirForme.NOM_ACTION_ETOILE);

		ActionSelectionner actionSelectionner = new ActionSelectionner(this.panneauDessin);
		javax.swing.JToggleButton buttonSelectionner = new javax.swing.JToggleButton(actionSelectionner);
		buttonSelectionner.setName(ActionSelectionner.NOM_ACTION);

		buttonGroup.add(buttonLigne);
		buttonGroup.add(buttonEllipse);
		buttonGroup.add(buttonCercle);
		buttonGroup.add(buttonEtoile);
		buttonGroup.add(buttonSelectionner);

		ActionChoisirCouleur actionChoisirCouleur = new ActionChoisirCouleur(this.panneauDessin);
		jbuttonChoisirCouleur = new JButton(actionChoisirCouleur);
		jbuttonChoisirCouleur.setName(ActionChoisirCouleur.NOM_ACTION);
		jbuttonChoisirCouleur.setVisible(true);

		ActionChoisirRemplissage actionChoisirRemplissage = new ActionChoisirRemplissage(this.panneauDessin);
		javax.swing.JCheckBox checkBox = new javax.swing.JCheckBox(actionChoisirRemplissage);
		checkBox.setName(ActionChoisirRemplissage.NOM_ACTION);

		SpinnerModel spinnerModelBranche = new SpinnerNumberModel(Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, 3, 15, 1);

		SpinnerModel spinnerModelLongueur = new SpinnerNumberModel(Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT, 0, 1, 0.01);

		spinnerBranche = new JSpinner(spinnerModelBranche);
		spinnerLongueur = new JSpinner(spinnerModelLongueur);

		spinnerBranche.setName(BRANCHE_SPINNER_NOM);
		spinnerLongueur.setName(LONGUEUR_SPINNER_NOM);

		this.add(buttonLigne);
		this.add(buttonEllipse);
		this.add(buttonCercle);
		this.add(buttonEtoile);
		this.add(buttonSelectionner);
		this.add(jbuttonChoisirCouleur);
		this.add(checkBox);
		this.add(spinnerBranche);
		this.add(spinnerLongueur);

	}

	public int getNbBranches() {
		return Integer.parseInt(spinnerBranche.getValue().toString());
	}

	public double getLongueurBranche() {
		return Double.parseDouble(spinnerLongueur.getValue().toString());
	}
}
