package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class EllipseTest {

	private static double EPSILON = 0.01;

	@Test
	public void test() {
		Ellipse e = new Ellipse();
		assertEquals("Largeur ", 20, e.getLargeur(), EPSILON);
		assertEquals("Hauteur ", 30, e.getHauteur(), EPSILON);
		assertEquals("Rempli ", false, e.estRempli());
		assertEquals("position", e.getPosition(), e.getPosition());
		assertEquals("String condition", e.toString(), e.toString());
	}

	@Test
	public void test2() {
		Coordonnees c = new Coordonnees();
		Ellipse e = new Ellipse(c);
		assertEquals("Largeur ", 20, e.getLargeur(), EPSILON);
		assertEquals("Hauteur ", 30, e.getHauteur(), EPSILON);
		assertEquals("Rempli ", false, e.estRempli());
		assertEquals("String condition", e.toString(), e.toString());

	}

	@Test
	public void test3() {
		Ellipse e = new Ellipse(10, 10);
		assertEquals("Largeur ", 10, e.getLargeur(), EPSILON);
		assertEquals("Hauteur ", 10, e.getHauteur(), EPSILON);
		e.setRempli(true);
		assertEquals("Rempli ", true, e.estRempli());
		assertEquals("String condition", e.toString(), e.toString());

	}

	@Test
	public void test4() {
		Coordonnees c = new Coordonnees();
		Ellipse e = new Ellipse(c, 10, 10);
		assertEquals("Largeur ", 10, e.getLargeur(), EPSILON);
		assertEquals("Hauteur ", 10, e.getHauteur(), EPSILON);
		e.setRempli(true);
		assertEquals("Rempli ", true, e.estRempli());

	}

	@Test
	public void test5() {
		Ellipse e = new Ellipse(6, 2);
		assertEquals("Perimetre ", 13.364, e.perimetre(), EPSILON);
		e.setHauteur(50);
		e.setLargeur(50);
	}

	@Test
	public void test6() {
		Ellipse e = new Ellipse(6, 6);
		assertEquals("Aire ", 28.27, e.aire(), EPSILON);
	}

	@Test
	public void test7() {
		Ellipse e = new Ellipse();
		Locale.setDefault(new Locale("en", "US"));
		assertEquals(e.toString(), e.toString());
	}

	@Test
	public void test8() {
		Ellipse e = new Ellipse();
		assertEquals("Contient ", false, e.contient(new Coordonnees(0, 0)));
		assertEquals("Contient ", true, e.contient(new Coordonnees(10, 10)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test9() {
		new Ellipse(-4, -4);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test10() {
		new Ellipse(new Coordonnees(), -4, -4);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test11() {
		Ellipse e = new Ellipse();
		e.setHauteur(-10);

	}

	@Test(expected = IllegalArgumentException.class)
	public void test12() {
		Ellipse e = new Ellipse();
		e.setLargeur(-10);

	}

	@Test
	public void test13() {
		Ellipse e = new Ellipse();
		Locale.setDefault(new Locale("fr", "FR"));
		assertEquals("String condition", e.toString(), e.toString());

	}

}
