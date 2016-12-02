package main.java.fr.pizzeria.ihm.action;

import java.util.stream.Stream;

import main.java.fr.pizzeria.ihm.IhmUtil;

public class ListPizza extends Action {

	private IhmUtil ihmUtil;

	public ListPizza(IhmUtil ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
		this.setDescription("Lister les pizzas");
	}

	@Override
	public void doAction() {
		System.out.println("JE LISTE LES PIZZAS :D");
		Stream.of(this.ihmUtil.getPizzaDao().findAll()).forEach(System.out::println);
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
