package fr.console;

//main.java.fr.pizzeria.console.PizzeriaAdminConsoleApp
import java.util.Scanner;

import fr.dao.PizzaDaoTableau;
import fr.exception.DeletePizzaException;
import fr.exception.SavePizzaException;
import fr.exception.UpdatesPizzaException;
import fr.ihm.IhmUtil;
import fr.ihm.MainMenu;
import fr.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static Boolean Arret = false;

	public static void main(String[] args) {
		// initPizzas();
		// printMenu();

		IhmUtil ihmUtil = new IhmUtil(new Scanner(System.in), new PizzaDaoTableau());
		// IhmUtil ihmUtil = new IhmUtil(new Scanner(System.in), new
		// PizzaDaoFichier());
		MainMenu Core = new MainMenu(ihmUtil);

		/*****************************************************/
		/**
		 * Test pour voir si les dépendances des librairies sont respectees
		 */
		Pizza p1 = new Pizza();
		p1.setCode("MAR");
		Pizza p2 = new Pizza();
		p2.setCode("MAR");

		System.out.println("p1=p2  ?" + p1.equals(p2));
		/*****************************************************/
		// PizzaDaoFichier test = new PizzaDaoFichier();
		// System.out.println(test.findAll());

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