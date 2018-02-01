	package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import DAO.ProduitDAO;
import DAO.ProduitDAORelationnel;
import metier.I_Produit;
import metier.Produit;

public class ProduitDAORelationnelTest {

	ProduitDAO prod;

	@Before
	public void setUp() {
		prod = ProduitDAORelationnel.getInstance();
	}

	@Test
	public void test_create() {
		I_Produit produit1 = new Produit("Jean-Jacque", 12.5, 12);

		assertTrue(prod.create(produit1));
	}

	@Test
	public void test_delete() {

		assertTrue(prod.delete("Bernard"));
	}

}
