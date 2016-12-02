package main.java.fr.pizzeria.dao;

import java.util.ArrayList;

import main.java.fr.pizzeria.exception.DeletePizzaException;
import main.java.fr.pizzeria.exception.SavePizzaException;
import main.java.fr.pizzeria.exception.UpdatesPizzaException;
import main.java.fr.pizzeria.model.CategoriePizza;
import main.java.fr.pizzeria.model.Pizza;

public interface PizzaDaoFactory {

	ArrayList<Pizza> findAll();

	void save(String code, String nom, CategoriePizza catPizza, Double prix) throws SavePizzaException;

	void supprime(int numPizzaSupprimee) throws DeletePizzaException;

	void update(String numPizza, String code, String nom, CategoriePizza catPizza, Double prix)
			throws UpdatesPizzaException;

}
