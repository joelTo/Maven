package main.java.fr.pizzeria.dao;

import java.io.File;
import java.util.ArrayList;

import main.java.fr.pizzeria.exception.DeletePizzaException;
import main.java.fr.pizzeria.exception.SavePizzaException;
import main.java.fr.pizzeria.exception.UpdatesPizzaException;
import main.java.fr.pizzeria.model.CategoriePizza;
import main.java.fr.pizzeria.model.Pizza;

public class PizzaDaoFichier implements PizzaDaoFactory {
	private File filePizzas;

	public ArrayList<Pizza> findAll() {

		return null;
	}

	public void save(String code, String nom, CategoriePizza catPizza, Double prix) throws SavePizzaException {
		Pizza pizza = new Pizza(10, code, nom, catPizza, prix);
		// saveFile();
	}

	public void delete(String pizzaToDelete) throws DeletePizzaException {
		return;
	}

	public void update(Pizza pizzaUdate, String oldCode)
			throws UpdatesPizzaException {
		return;
	}

}
