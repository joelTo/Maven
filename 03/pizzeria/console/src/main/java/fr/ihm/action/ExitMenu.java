package main.java.fr.pizzeria.ihm.action;

public class ExitMenu extends Action {

	public ExitMenu() {
		super();
		this.setDescription("Sortir");
	}

	@Override
	public void doAction() {
		System.out.println("AU REVOIR :'(");
		main.java.fr.pizzeria.console.PizzeriaAdminConsoleApp.Arret = true;
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
