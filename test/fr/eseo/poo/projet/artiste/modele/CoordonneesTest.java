
package fr.eseo.poo.projet.artiste.modele;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CoordonneesTest {

	private static double EPSILON = 1e-7d;

	@Test
	public void testConstructeurVide() {
		Coordonnees coordonnees = new Coordonnees();
		assertEquals(" X", 0, coordonnees.getAbscisse(), 0);
		assertEquals(" Y", 0, coordonnees.getOrdonnee(), 0);
	}

	@Test
	public void testConstructeurDoubleDouble() {
		Coordonnees coordonnees = new Coordonnees(1.111, 2.222);
		assertEquals(" X", 1.111, coordonnees.getAbscisse(), 0);
		assertEquals(" Y", 2.222, coordonnees.getOrdonnee(), 0);
	}

	@Test
	public void testGetAbscisse() {
		Coordonnees coordonnees = new Coordonnees(1.111, 2.222);
		assertEquals(" X", 1.111, coordonnees.getAbscisse(), 0);
	}

	@Test
	public void testGetOrdonnee() {
		Coordonnees coordonnees = new Coordonnees(1.111, 2.222);
		assertEquals(" Y", 2.222, coordonnees.getOrdonnee(), 0);
	}

	@Test
	public void testSetAbscisse() {
		Coordonnees coordonnees = new Coordonnees(1.111, 2.222);
		coordonnees.setAbscisse(4.22);
		assertEquals(" X", 4.22, coordonnees.getAbscisse(), 0);
	}

	@Test
	public void testSetOrdonnee() {
		Coordonnees coordonnees = new Coordonnees(1.111, 2.222);
		coordonnees.setOrdonnee(4.22);
		assertEquals(" Y", 4.22, coordonnees.getOrdonnee(), 0);
	}

	@Test
	public void testDeplacerDe() {
		Coordonnees coordonnees = new Coordonnees(1.111, 2.222);
		coordonnees.deplacerDe(1, 1);
		assertEquals(" X", 2.111, coordonnees.getAbscisse(), 0.001);
		assertEquals(" Y", 3.222, coordonnees.getOrdonnee(), 0.001);
	}

	@Test
	public void testDeplacerVers() {
		Coordonnees coordonnees = new Coordonnees(1.111, 2.222);
		coordonnees.deplacerVers(1, 1);
		assertEquals(" X", 1, coordonnees.getAbscisse(), 0.001);
		assertEquals(" Y", 1, coordonnees.getOrdonnee(), 0.001);

	}

	@Test
	public void testDistanceVers() {
		Coordonnees coordonnees1 = new Coordonnees(10, 2);
		Coordonnees coordonnees2 = new Coordonnees(4, 2);
		assertEquals("distance vers ", 6, coordonnees1.distanceVers(coordonnees2), EPSILON);
	}

	@Test
	public void testAngle() {
		Coordonnees coordonnees1 = new Coordonnees(0, 0);
		Coordonnees coordonnees2 = new Coordonnees(0, 0);
		assertEquals("angle ", 0, coordonnees1.angleVers(coordonnees2), EPSILON);
	}

	@Test
	public void testToString() {
		Coordonnees coordonnees = new Coordonnees();
		assertEquals("String ", "(0,0 , 0,0)", coordonnees.toString());
	}

}
