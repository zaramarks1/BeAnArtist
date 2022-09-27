package fr.eseo.poo.projet.artiste.xml;

import static javax.xml.xpath.XPathConstants.NUMBER;
import static javax.xml.xpath.XPathConstants.STRING;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Cercle;
import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.formes.VueCercle;
import fr.eseo.poo.projet.artiste.vue.formes.VueEllipse;
import fr.eseo.poo.projet.artiste.vue.formes.VueEtoile;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.formes.VueLigne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Un lecteur SVG est un processeur DOM/XPath responsable du chargement d'un
 * dessin au format SVG.
 * 
 * Les méthodes lisDessin et lisXxxx devront être complétées.
 * 
 */
public class LecteurSVG {

	/**
	 * Lance le test de chargement (méthode teste) avec le fichier SVG
	 * "Dessin-in.svg".
	 */
	public static void main(String[] args) throws FileNotFoundException, XPathExpressionException {
		LecteurSVG lecteur = new LecteurSVG();
		lecteur.teste("Dessin-in.svg");
	}

	/**
	 * Evaluateur d'expressions XPath permettant de naviguer facilement dans le
	 * document DOM.
	 */
	private XPath xpath = XPathFactory.newInstance().newXPath();

	/**
	 * Teste le chargement du fichier SVG. Le contenu du fichier est ensuite affiché
	 * dans la fenêtre de l'application (classe FenêtreBeAnArtist).
	 * 
	 * @param nomFichier le fichier d'entrée à lire
	 * @throws FileNotFoundException    si le fichier n'existe pas
	 * @throws XPathExpressionException
	 */
	public void teste(String nomFichier) throws FileNotFoundException, XPathExpressionException {
		final List<VueForme> dessin = lisDessin(nomFichier);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// création du panneau de dessin
				JFrame fenetre = new JFrame("Etre Un Artiste");
				PanneauDessin panneauDessin = new PanneauDessin(960, 720, new Color(255, 255, 255));
				fenetre.add(panneauDessin);
				fenetre.pack();
				fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				fenetre.setLocationRelativeTo(null);
				// ajout des formes dans le panneau
				for (VueForme vueForme : dessin) {
					panneauDessin.ajouterVueForme(vueForme);
				}
				fenetre.setVisible(true);
			}
		});
	}

	/**
	 * Charge le fichier SVG donné dans un document DOM puis renvoie l'intégralité
	 * du dessin sous la forme d'une liste de vues représentant les formes stockées
	 * dans le fichier.
	 * 
	 * @param nomFichier le nom du fichier SVG
	 * @return l'intégralité du dessin sous la forme d'une liste de vues
	 * @throws FileNotFoundException    si le fichier n'est pas trouvé ou accessible
	 * @throws XPathExpressionException
	 */
	public List<VueForme> lisDessin(String nomFichier) throws FileNotFoundException, XPathExpressionException {
		List<VueForme> dessin = new ArrayList<>();
		Document document = new ChargeurDOM().charge(nomFichier);
		// TODO initialiser correctement la variable "figures" en utilisant la variable
		// "xpath".
		// L'expression XPath doit renvoyer les listes des noeuds DOM représentant
		// toutes les formes
		// présentes dans le dessin.
		NodeList figures = (NodeList) xpath.evaluate("svg/*", document, XPathConstants.NODESET);

		// NodeList figures = (NodeList) xpath.evaluate("", document, NODESET);
		for (int i = 0; i < figures.getLength(); i++) {
			Node noeud = figures.item(i);
			VueForme vue = lisVueForme(noeud);
			// note: la condition suivante "vue != null" permet de lancer le "main" bien que
			// toutes
			// les méthodes lis<Forme> ne soient pas encore implémentées.
			if (vue != null) {
				dessin.add(vue);
			}
		}
		return dessin;
	}

	/**
	 * Crée une forme et sa vue associée réprésentées par le noeud DOM donné, puis
	 * renvoie cette vue. Cette méthode invoque les méthodes lis<Forme> définies
	 * pour chacune des <Forme> considérée.
	 * 
	 * @param noeud le noeud représentant la vue et sa forme
	 * @return la vue stockée dans le noeud considéré
	 */
	public VueForme lisVueForme(Node noeud) throws XPathExpressionException {
		VueForme vue = null;
		switch (noeud.getNodeName()) {
		// TODO modifier la chaîne du "case" suivant
		case "ellipse":
			vue = new VueEllipse(lisEllipse(noeud));
			break;
		// TODO modifier la chaîne du "case" suivant
		case "circle":
			vue = new VueCercle(lisCercle(noeud));
			break;
		// TODO modifier la chaîne du "case" suivant
		case "line":
			vue = new VueLigne(lisLigne(noeud));
			break;
		// TODO modifier la chaîne du "case" suivant
		case "polygon":
			vue = new VueEtoile(lisEtoile(noeud));
			break;
		default:
			System.err.println("Erreur : " + noeud.getNodeName());
			for (int i = 0; i < noeud.getAttributes().getLength(); i++) {
				System.err.println(noeud.getAttributes().item(i));
			}
		}
		// TODO définir la couleur de la forme (utiliser notamment la méthode
		// "lisCouleur")
		vue.getForme().setCouleur(this.lisCouleur(noeud));
		if (vue.getForme() instanceof Ellipse || vue.getForme() instanceof Cercle) {
			((Ellipse) vue.getForme()).setRempli(this.lisRemplissage(noeud));
		} else if (vue.getForme() instanceof Etoile) {
			((Etoile) vue.getForme()).setRempli(this.lisRemplissage(noeud));
		}

		return vue;
	}

	/**
	 * Renvoie une nouvelle ellipse représentée par le noeud DOM donné.
	 * 
	 * @param noeud le noeud représentant l'ellipse
	 * @return l'ellipse stockée dans le noeud considéré
	 */
	public Ellipse lisEllipse(Node noeud) throws XPathExpressionException {
		// TODO initialiser correctement les 5 variables qui suivent en utilisant la
		// variable "xpath".
		// La 1ère initialisation est fournie.
		double cx = (double) xpath.evaluate("@cx", noeud, NUMBER);
		double cy = (double) xpath.evaluate("@cy", noeud, NUMBER);
		double rx = (double) xpath.evaluate("@rx", noeud, NUMBER);
		double ry = (double) xpath.evaluate("@ry", noeud, NUMBER);
		System.out.println(cx);
		Coordonnees position = new Coordonnees(cx - rx, cy - ry);
		return new Ellipse(position, 2 * rx, 2 * ry);
	}

	/**
	 * Renvoie un nouveau cercle représenté par le noeud DOM donné.
	 * 
	 * @param noeud le noeud représentant le cercle
	 * @return le cercle stocké dans le noeud considéré
	 */
	public Cercle lisCercle(Node noeud) throws XPathExpressionException {
		// TODO initialiser correctement les 3 variables qui suivent en utilisant la
		// variable "xpath".
		double cx = (double) xpath.evaluate("@cx", noeud, NUMBER);
		double cy = (double) xpath.evaluate("@cy", noeud, NUMBER);
		double r = (double) xpath.evaluate("@r", noeud, NUMBER);
		Coordonnees position = new Coordonnees(cx - r, cy - r);
		return new Cercle(position, 2 * r);
	}

	/**
	 * Renvoie la nouvelle ligne représentée par le noeud DOM donné.
	 * 
	 * @param noeud le noeud représentant la ligne
	 * @return la ligne stockée dans le noeud considéré
	 */
	public Ligne lisLigne(Node noeud) throws XPathExpressionException {
		// TODO initialiser correctement les 6 variables qui suivent en utilisant la
		// variable "path".
		double x1 = (double) xpath.evaluate("@x1", noeud, NUMBER);
		double y1 = (double) xpath.evaluate("@y1", noeud, NUMBER);
		double x2 = (double) xpath.evaluate("@x2", noeud, NUMBER);
		double y2 = (double) xpath.evaluate("@y2", noeud, NUMBER);

		Coordonnees p1 = new Coordonnees(x1, y1);
		Coordonnees p2 = new Coordonnees(x2, y2);
		Ligne ligne = new Ligne();
		ligne.setC1(p1);
		ligne.setC2(p2);
		return ligne;
	}

	/**
	 * Renvoie la nouvelle étoile représentée par le noeud DOM donné.
	 * 
	 * @param noeud le noeud représentant l'étoile
	 * @return l'étoile stockée dans le noeud considéré
	 */
	public Etoile lisEtoile(Node noeud) throws XPathExpressionException {
		// TODO initialiser correctement la variable qui suit en utilisant la variable
		// "xpath".
		String points = (String) xpath.evaluate("@points", noeud, STRING);
		System.out.println(points);
		StringTokenizer tokenizer = new StringTokenizer(points, ", ");
		List<Coordonnees> coordonnees = new ArrayList<>();
		while (tokenizer.hasMoreTokens()) {
			double x = Double.valueOf(tokenizer.nextToken());
			double y = Double.valueOf(tokenizer.nextToken());
			coordonnees.add(new Coordonnees(x, y));
		}
		// calcul de l'étoile :-)
		return calculeEtoile(coordonnees);
	}

	/**
	 * Renvoie une nouvelle étoile calculée à partir de la liste de ses coordonnées.
	 * 
	 * Il faut "un peu" réflechir et donc s'aider du trio "feuille, stylo, cerveau".
	 * 
	 * Indications : calculer les coordonnéeds du centre de l'étoile ; calculer
	 * le(s) rayon(s) en utilisant la méthode Coordonnees.distanceVers ; calculer
	 * le(s) angle(s) en utilisant la méthode Coordonnees.angleVers.
	 * 
	 * @param points La liste des coordonnées des points de l'étoile
	 * @return L'étoile calculée à partir de la liste de ses coordonnées
	 */
	public Etoile calculeEtoile(List<Coordonnees> points) {

		return null;
	}

	/**
	 * Convertis une couleur représentée par une chaîne de caractères en une couleur
	 * compatible avec l'API Java. La chaîne en question est au format "#RRVVBB" où
	 * RR représente la valeur héxadécimale de la composante rouge, VV celle de la
	 * composante verte et BB celle de la composante bleue.
	 * 
	 * @param couleur la couleur représentée par une chaîne au format "#RRVVBB"
	 * @return la couleur compatible avec l'API Java
	 */
	public Color lisCouleur(Node noeud) throws XPathExpressionException {
		// TODO initialiser correctement la variable qui suit en utilisant la variable
		// xpath.
		String couleur = (String) xpath.evaluate("@stroke", noeud, STRING);
		try {
			return Color.decode(couleur);
		} catch (NumberFormatException e) {
			return Forme.COULEUR_PAR_DEFAUT;
		}
	}

	public boolean lisRemplissage(Node noeud) throws XPathExpressionException {
		String remplissage = (String) xpath.evaluate("@fill", noeud, STRING);

		return !remplissage.equals("none");
	}

}
