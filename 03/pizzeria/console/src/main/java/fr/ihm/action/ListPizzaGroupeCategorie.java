package main.java.fr.pizzeria.ihm.action;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import main.java.fr.pizzeria.ihm.IhmUtil;
import main.java.fr.pizzeria.model.CategoriePizza;
import main.java.fr.pizzeria.model.Pizza;

public class ListPizzaGroupeCategorie extends Action {

	private IhmUtil ihmUtil;

	public ListPizzaGroupeCategorie(IhmUtil ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
		this.setDescription("Liste les pizza par groupe categorie");
	}

	@Override
	public void doAction() {
		System.out.println("Affichage des pizzas par categories");
		Map<CategoriePizza, List<Pizza>> map = this.ihmUtil.getPizzaDao().findAll().stream()
				.collect(Collectors.groupingBy(pizza -> pizza.getCatPizza()));
		map.entrySet().stream().forEach(System.out::println);
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}
}
