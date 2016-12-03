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

	public void delete(String code) throws DeletePizzaException {
		if (codeIsValide(code)) {
			throw new DeletePizzaException();
		}
		Pizza piz = pizzas.stream().filter(p -> p.getCode().equals(code)).findFirst().get();
		pizzas.remove(piz);
	}

	private boolean codeIsValide(String code) {
		return pizzas.stream().filter(p -> p.getCode().equals(code)).findFirst().isPresent();
	}

	public void update(Pizza pizzaUdate, String oldCode)
			throws UpdatesPizzaException {

		if (isExisting(pizzaUdate, oldCode)) {
			throw new UpdatesPizzaException();
		}

		Pizza piz = pizzas.stream().filter(p -> p.getCode().equals(oldCode)).findFirst().get();
		Pizza pizzaModifiee = new Pizza(piz.getId(), pizzaUdate.getCode(), pizzaUdate.getNom(),
				pizzaUdate.getCatPizza(), pizzaUdate.getPrix());
		pizzas.set(piz.getId(), pizzaModifiee);

	}

	private boolean isExisting(Pizza pizzaUdate, String oldCode) {
		if (pizzas.stream().filter(p -> p.getCode().equals(oldCode)).findFirst().isPresent()) {
			// mise en place du logger à faire LOG.("Probleme le code entrez
			// n'existe pas ")
			return false;
		}
		return (pizzaUdate.getCode().isEmpty() && pizzaUdate.getNom().isEmpty() && pizzaUdate.getPrix() != 0);
	}

}