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
		System.out.println("Veuillez entrer un num�ro de pizza � supprimer, s'il vous plait");
		int numPizzaSupprimee = ihmUtil.getScanner().nextInt();
		ihmUtil.getPizzaDao().supprime(numPizzaSupprimee);
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
