package main.java.fr.pizzeria.dao;

import java.util.ArrayList;

import main.java.fr.pizzeria.exception.DeletePizzaException;
import main.java.fr.pizzeria.exception.SavePizzaException;
import main.java.fr.pizzeria.exception.UpdatesPizzaException;
import main.java.fr.pizzeria.model.CategoriePizza;
import main.java.fr.pizzeria.model.Pizza;

public class PizzaDaoTableau implements PizzaDaoFactory {

	private ArrayList<Pizza> pizzas = new ArrayList<Pizza>() {
		{
			add(new Pizza(0, "MAR", "Margherita", CategoriePizza.VIANDE, 14));
			add(new Pizza(1, "ORI", "Oriental", CategoriePizza.VIANDE, 16));

		}
	};

	@Override
	public ArrayList<Pizza> findAll() {
		return pizzas;
	}

	@Override
	public void save(String code, String nom, CategoriePizza catPizza, Double prix) throws SavePizzaException {
		if (isValid(code, nom, prix)) {
			throw new SavePizzaException();
		}
		Pizza pizzaAjoutee = new Pizza(pizzas.size(), code, nom, catPizza, prix);
		pizzas.add(pizzaAjoutee);
	}

	private boolean isValid(String code, String nom, Double prix) {
		return code.isEmpty() && nom.isEmpty() && prix != 0;
	}

	public void supprime(int numPizzaSupprimee) throws DeletePizzaException {
		if (numIsValide(numPizzaSupprimee)) {
			throw new DeletePizzaException();
		}
		pizzas.remove(numPizzaSupprimee);
	}

	private boolean numIsValide(int numPizzaSupprimee) {
		return numPizzaSupprimee < pizzas.size();
	}

	public void update(String numPizza, String code, String nom, CategoriePizza catPizza, Double prix)
			throws UpdatesPizzaException {
		if (isExisting(numPizza, code, nom, prix)) {
			throw new UpdatesPizzaException();
		}
		Pizza pizzaModifiee = new Pizza(Integer.parseInt(numPizza), code, nom, catPizza, prix);
		pizzas.set(Integer.parseInt(numPizza), pizzaModifiee);

	}

	private boolean isExisting(String numPizza, String code, String nom, Double prix) {
		return numIsValide(Integer.parseInt(numPizza)) && code.isEmpty() && nom.isEmpty() && prix != 0;
	}

	public ArrayList<Pizza> listPizza() {
		return pizzas;
	}
}