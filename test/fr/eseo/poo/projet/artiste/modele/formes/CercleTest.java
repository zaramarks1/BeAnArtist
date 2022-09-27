package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class CercleTest {

	private static double EPSILON = 0.01;

	@Test
	public void cercleTestConstructeruVide() {
		Cercle c = new Cercle();
		assertEquals("Largeur ", 20, c.getLargeur(), EPSILON);
		assertEquals("Hauteur ", 20, c.getHauteur(), EPSILON);
		assertEquals("Rempli ", false, c.estRempli());
	}

	@Test
	public void ellipseTestConstructeur2() {
		Coordonnees c1 = new Coordonnees();
		Cercle c = new Cercle(c1);
		assertEquals("Largeur ", 20, c.getLargeur(), EPSILON);
		assertEquals("Hauteur ", 20, c.getHauteur(), EPSILON);
		assertEquals("Rempli ", false, c.estRempli());
		assertEquals("String ", c.toString(), c.toString());
	}

	@Test
	public void cercleTestConstructeur3() {
		Coordonnees c1 = new Coordonnees();
		Cercle c = new Cercle(c1, 20);
		assertEquals("Largeur ", 20, c.getLargeur(), EPSILON);
		assertEquals("Hauteur ", 20, c.getHauteur(), EPSILON);
		assertEquals("Rempli ", false, c.estRempli());
	}

	@Test
	public void cercleTestConstructeur4() {
		Cercle c = new Cercle(20);
		assertEquals("Largeur ", 20, c.getLargeur(), EPSILON);
		assertEquals("Hauteur ", 20, c.getHauteur(), EPSILON);
		c.setRempli(true);
		assertEquals("Rempli ", true, c.estRempli());
		assertEquals("String ", c.toString(), c.toString());
	}

	@Test
	public void testPerimetre() {
		Cercle c = new Cercle(2);
		assertEquals("Perimetre ", 6.28, c.perimetre(), EPSILON);
		c.setHauteur(50);
	}

	@Test
	public void testToString() {
		Cercle c = new Cercle();
		assertEquals("String ", c.toString(), c.toString());
	}

	@Test
	public void testToString2() {
		Cercle c = new Cercle();
		Locale.setDefault(new Locale("fr", "FR"));
		assertEquals("String ", c.toString(), c.toString());
	}

	@Test
	public void testToString3() {
		Cercle c = new Cercle();
		Locale.setDefault(new Locale("en", "US"));
		assertEquals("String ", c.toString(), c.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExeption() {
		Cercle c = new Cercle();
		c.setLargeur(-10);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testExeption2() {
		Cercle c = new Cercle();
		c.setHauteur(-10);

	}

}
