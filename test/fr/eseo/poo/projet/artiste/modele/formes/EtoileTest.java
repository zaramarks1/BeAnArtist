package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class EtoileTest {

	@Test
	public void test() {
		Etoile etoile = new Etoile();
		assertEquals("area ", 120, etoile.aire(), 0.001);
		assertEquals("longeur  ", 20, etoile.getLargeur(), 0.001);
		assertEquals("position", etoile.getPosition(), etoile.getPosition());
		assertEquals("perimetre  ", 82.020, etoile.perimetre(), 0.001);
		assertEquals("list", etoile.getCoordonnees(), etoile.getCoordonnees());
		assertEquals("string", etoile.toString(), etoile.toString());
		assertEquals("contient ", true, etoile.contient(new Coordonnees(10, 10)));
		assertEquals("rempli  ", false, etoile.estRempli());
	}

	@Test
	public void test2() {
		Etoile etoile = new Etoile(20);
		assertEquals("area ", 120, etoile.aire(), 0.001);
		assertEquals("longeur  ", 20, etoile.getLargeur(), 0.001);
		assertEquals("position", etoile.getPosition(), etoile.getPosition());
		assertEquals("perimetre  ", 82.020, etoile.perimetre(), 0.001);
		assertEquals("list", etoile.getCoordonnees(), etoile.getCoordonnees());

		etoile.setRempli(true);
		assertEquals("rempli  ", true, etoile.estRempli());
		assertEquals("String ", etoile.toString(), etoile.toString());

	}

	@Test
	public void test3() {
		Etoile etoile = new Etoile(new Coordonnees(50, 50));
		assertEquals("area ", 120, etoile.aire(), 0.001);
		assertEquals("longeur  ", 20, etoile.getLargeur(), 0.001);
		assertEquals("position", etoile.getPosition(), etoile.getPosition());
		assertEquals("perimetre  ", 82.020, etoile.perimetre(), 0.001);
		assertEquals("list", etoile.getCoordonnees(), etoile.getCoordonnees());

	}

	@Test
	public void test4() {
		Etoile etoile = new Etoile(new Coordonnees(50, 50), 20);
		assertEquals("area ", 120, etoile.aire(), 0.001);
		assertEquals("longeur  ", 20, etoile.getLargeur(), 0.001);
		assertEquals("position", etoile.getPosition(), etoile.getPosition());
		assertEquals("perimetre  ", 82.020, etoile.perimetre(), 0.001);
		assertEquals("list", etoile.getCoordonnees(), etoile.getCoordonnees());

	}

	@Test
	public void test5() {
		Etoile etoile = new Etoile(new Coordonnees(50, 50), 20, 5, 1.2, 0.3);
		assertEquals("area ", 205.724, etoile.aire(), 0.001);
		assertEquals("longeur  ", 20, etoile.getLargeur(), 0.001);
		assertEquals("position", etoile.getPosition(), etoile.getPosition());
		assertEquals("perimetre  ", 59.78, etoile.perimetre(), 0.001);
		assertEquals("list", etoile.getCoordonnees(), etoile.getCoordonnees());

	}

	@Test
	public void test6() {
		Etoile etoile = new Etoile(new Coordonnees(50, 50), 20, 5, 1.2, 0.3);

		etoile.setPosition(new Coordonnees(10, 10));
		etoile.setAnglePremiereBranche(0.2);
		etoile.setHauteur(50);
		etoile.setLargeur(50);
		etoile.setNombreBranches(5);
		etoile.setLongueurBranche(0.5);

		assertEquals("longeur  ", 50, etoile.getLargeur(), 0.001);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testExeption() {
		Etoile e = new Etoile();
		e.setLargeur(-10);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testExeption2() {
		Etoile e = new Etoile();
		e.setHauteur(-10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExeption3() {
		Etoile e = new Etoile();
		e.setAnglePremiereBranche(-50);
		e.setAnglePremiereBranche(50);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExeption4() {
		Etoile e = new Etoile();
		e.setLongueurBranche(-50);
		e.setLongueurBranche(50);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExeption5() {
		Etoile e = new Etoile();
		e.setNombreBranches(-50);
		e.setNombreBranches(50);

	}

	@Test
	public void testToString2() {
		Etoile e = new Etoile();
		Locale.setDefault(new Locale("fr", "FR"));
		assertEquals("String ", e.toString(), e.toString());
	}

	@Test
	public void testToString3() {
		Etoile e = new Etoile();
		Locale.setDefault(new Locale("en", "US"));
		assertEquals("String ", e.toString(), e.toString());
	}

}
