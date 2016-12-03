package main.java.fr.pizzeria.ihm.action;

import java.util.stream.Stream;

import main.java.fr.pizzeria.exception.SavePizzaException;
import main.java.fr.pizzeria.ihm.IhmUtil;
import main.java.fr.pizzeria.model.CategoriePizza;
import main.java.fr.pizzeria.model.Pizza;

public class AddPizza extends Action {

	private IhmUtil ihmUtil;

	public AddPizza(IhmUtil ihmUtil) {
		super();
		this.setDescription("Ajouter une nouvelle pizza");
		this.ihmUtil = ihmUtil;
	}

	@Override
	public void doAction() throws SavePizzaException {

		System.out.println("");
		System.out.println("Veuillez entrer l'alias de la nouvelle pizza s'il vous plait");
		String code = ihmUtil.getScanner().next();
		System.out.println("Veuillez entrer le nom de la nouvelle pizza s'il vous plait");
		String nom = ihmUtil.getScanner().next();
		System.out.println("Veuillez entrer le Cat�gorie de la nouvelle pizza s'il vous plait");
		Stream.of(CategoriePizza.values())
				.forEach(System.out::println); /* Lister les enum cr�� */

		String catPizza = ihmUtil.getScanner().next();

		System.out.println("Veuillez entrer le prix de la nouvelle pizza s'il vous plait");
		Double prix = ihmUtil.getScanner().nextDouble();

		ihmUtil.getPizzaDao().save(new Pizza(code, nom, CategoriePizza.valueOf(catPizza), prix));

	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
