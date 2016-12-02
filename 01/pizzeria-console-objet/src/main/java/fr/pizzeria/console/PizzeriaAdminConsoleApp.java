package main.java.fr.pizzeria.console;

import java.util.Scanner;

import main.java.fr.pizzeria.dao.PizzaDaoTableau;
import main.java.fr.pizzeria.dao.TraitementFichiers;
import main.java.fr.pizzeria.exception.DeletePizzaException;
import main.java.fr.pizzeria.exception.SavePizzaException;
import main.java.fr.pizzeria.exception.UpdatesPizzaException;
import main.java.fr.pizzeria.ihm.IhmUtil;
import main.java.fr.pizzeria.ihm.MainMenu;

public class PizzeriaAdminConsoleApp {

	public static Boolean Arret = false;

	public static void main(String[] args) {
		// initPizzas();
		// printMenu();

		IhmUtil ihmUtil = new IhmUtil(new Scanner(System.in), new PizzaDaoTableau());
		MainMenu Core = new MainMenu(ihmUtil);

		TraitementFichiers t = new TraitementFichiers();
		t.printlistFile();

		while (Arret == false) {
			Core.displayMenu();
			try {
				Core.parseAndExec();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SavePizzaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DeletePizzaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UpdatesPizzaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}