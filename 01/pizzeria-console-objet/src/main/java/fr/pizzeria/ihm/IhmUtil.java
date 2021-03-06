package main.java.fr.pizzeria.ihm;

import java.util.Scanner;

import main.java.fr.pizzeria.dao.PizzaDaoFactory;

public class IhmUtil {

	private Scanner scanner;
	private PizzaDaoFactory pizzaDao;

	public IhmUtil(Scanner scanner, PizzaDaoFactory pizzaDao) {
		super();
		this.scanner = scanner;
		this.pizzaDao = pizzaDao;
	}

	public Scanner getScanner() {
		return this.scanner;
	}

	public PizzaDaoFactory getPizzaDao() {
		return this.pizzaDao;
	}

}
