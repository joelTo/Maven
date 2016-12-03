package main.java.fr.pizzeria.ihm.action;

import main.java.fr.pizzeria.exception.DeletePizzaException;
import main.java.fr.pizzeria.ihm.IhmUtil;

public class DeletePizza extends Action {

	private IhmUtil ihmUtil;

	public DeletePizza(IhmUtil e) {
		super();
		this.setDescription("Supprimer une pizza");
		this.ihmUtil = e;
	}

	@Override
	public void doAction() throws DeletePizzaException {
		System.out.println("");
		System.out.println("Veuillez entrerle code <Alias de pizza a supprimer, s'il vous plait");
		String pizzaToDelete = ihmUtil.getScanner().next();
		ihmUtil.getPizzaDao().delete(pizzaToDelete);
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
