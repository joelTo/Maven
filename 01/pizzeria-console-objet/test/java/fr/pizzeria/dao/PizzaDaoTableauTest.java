package java.fr.pizzeria.dao;

import org.junit.Assert;
import org.junit.Test;

import main.java.fr.pizzeria.dao.PizzaDaoTableau;
import main.java.fr.pizzeria.exception.SavePizzaException;
import main.java.fr.pizzeria.model.CategoriePizza;
import main.java.fr.pizzeria.model.Pizza;

public class PizzaDaoTableauTest {

	@Test
	public void testSave() throws SavePizzaException {
		// Prérequis --> Instanciation de la Classe
		PizzaDaoTableau tableau = new PizzaDaoTableau();

		// Execute code à tester --> Appel la méthode
		tableau.save("PIT", "PYTHON", CategoriePizza.VIANDE, 14.00);

		// Verifie le résultat --> On teste
		// recupere la pizza ajouté
		Pizza piz = tableau.findAll().stream().filter(p -> p.getCode().equals("PIT")).findFirst().get();
		Assert.assertEquals("PIT", piz.getCode());
		Assert.assertEquals("PYTHON", piz.getNom());
		Assert.assertEquals(CategoriePizza.VIANDE, piz.getCatPizza());
		/// Assert.assertEquals(14.52, piz.getPrix().doubleValue());
		Assert.assertTrue("", piz.getPrix().equals(14.0));
		Assert.assertEquals(piz.getPrix(), Double.valueOf(14.0));
	}

}
