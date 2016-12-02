package main.java.fr.pizzeria.ihm.action;

import main.java.fr.pizzeria.ihm.IhmUtil;

public class ListPizzaGroupeCategorie extends Action {

	private IhmUtil ihmUtil;

	public ListPizzaGroupeCategorie(IhmUtil ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
		this.setDescription("Liste les pizza par groupe categorie");
	}

	@Override
	public void doAction() {
		System.out.println("Affichage des pizzas par cat�gories");
		// this.ihmUtil.getPizzaDao().findAll().stream().collect(Collectors.groupingBy(Pizza::getCatPizza))
		// .forEach(System.out::println);

		/**
		 * Bonne Methode
		 */
		// this.ihmUtil.getPizzaDao().findAll().stream().collect(Collections.groupingBy(Pizza
		// -> Pizza::getCatPizza));
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}
}
