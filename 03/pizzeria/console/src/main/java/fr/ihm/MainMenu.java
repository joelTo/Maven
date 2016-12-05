package main.java.fr.pizzeria.ihm;

import java.util.Map;
import java.util.TreeMap;

import main.java.fr.pizzeria.exception.DeletePizzaException;
import main.java.fr.pizzeria.exception.SavePizzaException;
import main.java.fr.pizzeria.exception.UpdatesPizzaException;
import main.java.fr.pizzeria.ihm.action.Action;
import main.java.fr.pizzeria.ihm.action.AddPizza;
import main.java.fr.pizzeria.ihm.action.DeletePizza;
import main.java.fr.pizzeria.ihm.action.ExitMenu;
import main.java.fr.pizzeria.ihm.action.ListPizza;
import main.java.fr.pizzeria.ihm.action.ListPizzaGroupeCategorie;
import main.java.fr.pizzeria.ihm.action.ListPizzaTarifEleve;
import main.java.fr.pizzeria.ihm.action.UpdatePizza;

public class MainMenu {
	private Map<Integer, Action> map = new TreeMap<Integer, Action>();
	private IhmUtil ihmUtil;

	public MainMenu(IhmUtil ihmUtil) {

		map.put(1, new ListPizza(ihmUtil));
		map.put(2, new AddPizza(ihmUtil));
		map.put(3, new UpdatePizza(ihmUtil));
		map.put(4, new DeletePizza(ihmUtil));
		map.put(5, new ListPizzaGroupeCategorie(ihmUtil));
		map.put(6, new ListPizzaTarifEleve(ihmUtil));
		map.put(99, new ExitMenu());
		this.ihmUtil = ihmUtil;
	}

	public void displayMenu() {
		map.forEach((i, a) -> System.out.println(i + " " + a.getDescription()));
	}

	public void parseAndExec()
			throws NumberFormatException, SavePizzaException, DeletePizzaException, UpdatesPizzaException {
		String input = ihmUtil.getScanner().next();
		this.map.get(Integer.parseInt(input)).doAction();

	}
}
