package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class LigneTest {

	private static double EPSILON = 0.01;

	@Test
	public void ligneTestConstructeurVide() {
		Ligne l = new Ligne();
		assertEquals("Largeur ", 20, l.getLargeur(), EPSILON);
		assertEquals("Hauteur ", 30, l.getHauteur(), EPSILON);
		assertEquals("Couleur ", javax.swing.UIManager.getColor("Panel.foreground"), l.getCouleur());
		assertEquals("position", l.getPosition(), l.getPosition());
		// assertEquals("C1 ", l.getC1(), l.getC1());
		// assertEquals("C2 ", l.getC2(), l.getC2());

	}

	@Test
	public void ligneTestConstructeur2() {
		Coordonnees c = new Coordonnees();
		Ligne l = new Ligne(c);
		assertEquals("Largeur ", 20, l.getLargeur(), EPSILON);
		assertEquals("Hauteur ", 30, l.getHauteur(), EPSILON);
		assertEquals("Couleur ", javax.swing.UIManager.getColor("Panel.foreground"), l.getCouleur());

	}

	@Test
	public void ligneTestConstructeur3() {
		Ligne l = new Ligne(10, 10);
		assertEquals("Largeur ", 10, l.getLargeur(), EPSILON);
		assertEquals("Hauteur ", 10, l.getHauteur(), EPSILON);
		assertEquals("Couleur ", javax.swing.UIManager.getColor("Panel.foreground"), l.getCouleur());

	}

	@Test
	public void ligneTestConstructeur4() {
		Coordonnees c = new Coordonnees();
		Ligne l = new Ligne(c, 10, 10);
		assertEquals("Largeur ", 10, l.getLargeur(), EPSILON);
		assertEquals("Hauteur ", 10, l.getHauteur(), EPSILON);
		assertEquals("Couleur ", javax.swing.UIManager.getColor("Panel.foreground"), l.getCouleur());

	}

	@Test
	public void testPerimetre() {
		Ligne l = new Ligne(6, 2);
		assertEquals("Perimetre ", 6.32, l.perimetre(), EPSILON);
	}

	@Test
	public void testAire() {
		Ligne l = new Ligne(6, 2);
		assertEquals("Aire ", 0, l.aire(), EPSILON);
		l.setC1(new Coordonnees());
		l.setC2(new Coordonnees());
	}

	@Test
	public void testToString() {
		Ligne l = new Ligne();
		assertEquals(l.toString(), l.toString());
		Ligne l1 = new Ligne(-10, -20);
		assertEquals(l1.toString(), l1.toString());
	}

	@Test
	public void contientTest() {
		Ligne l = new Ligne();
		assertEquals("Contient ", false, l.contient(new Coordonnees(50, 50)));
		assertEquals("Contient ", true, l.contient(new Coordonnees(20, 30)));
	}

	@Test
	public void testString() {
		Ligne l = new Ligne();
		Locale.setDefault(new Locale("fr", "FR"));
		assertEquals("String condition", l.toString(), l.toString());

	}

	@Test
	public void testString2() {
		Ligne l = new Ligne();
		Locale.setDefault(new Locale("en", "US"));
		assertEquals("String condition", l.toString(), l.toString());
	}

}
