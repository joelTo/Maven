package main.java.fr.pizzeria.ihm.action;

import java.util.stream.Stream;

import main.java.fr.pizzeria.exception.UpdatesPizzaException;
import main.java.fr.pizzeria.ihm.IhmUtil;
import main.java.fr.pizzeria.model.CategoriePizza;

public class UpdatePizza extends Action {

	private IhmUtil ihmUtil;

	public UpdatePizza(IhmUtil e) {
		super();
		this.setDescription("Mettre � jour une pizza");
		this.ihmUtil = e;
	}

	@Override
	public void doAction() throws UpdatesPizzaException {
		System.out.println("");
		System.out.println("Quelle pizza voulez-vous modifier ? ");
		String numPizzaModiffier = ihmUtil.getScanner().next();

		System.out.println("Veuillez entrer la modification de l'Alias de votre Pizza");
		String saisieAlias = ihmUtil.getScanner().next();

		System.out.println("Veuillez entrer la modification  du nom de votre Pizza");
		String saisieNom = ihmUtil.getScanner().next();

		System.out.println("Veuillez entrer la modification  du prix de votre Pizza");
		Double saisiePrix = ihmUtil.getScanner().nextDouble();

		System.out.println("Veuillez entrer le Cat�gorie de la nouvelle pizza s'il vous plait");
		Stream.of(CategoriePizza.values())
				.forEach(System.out::println); /* Lister les enum cr�� */

		String catPizza = ihmUtil.getScanner().next();

		ihmUtil.getPizzaDao().update(numPizzaModiffier, saisieAlias, saisieNom, CategoriePizza.valueOf(catPizza),
				saisiePrix);
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
