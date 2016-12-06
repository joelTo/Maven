package main.java.fr.pizzeria.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import main.java.fr.pizzeria.exception.DeletePizzaException;
import main.java.fr.pizzeria.exception.SavePizzaException;
import main.java.fr.pizzeria.exception.UpdatesPizzaException;
import main.java.fr.pizzeria.model.Pizza;

public class PizzaDaoFichier implements PizzaDaoFactory {
	private File file = new File("PizzaFiles");

	@Override
	public ArrayList<Pizza> findAll() {
		List<String> codeList = listCodesPizza();
		Collection<String> t = new ArrayList<String>();
		codeList.stream().forEach(codeFile -> t.add(readFile(codeFile)));
		/* INSERTION de la liste dans un tableau mieux manipulable */
		String[] y = t.toArray(new String[0]);
		for (String string : y) {
			String str[] = string.split(";");

		}
		return null;
	}


	@Override
	public void save(Pizza newPizza) throws SavePizzaException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String pizzaToDelete) throws DeletePizzaException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Pizza pizzaUdate, String oldCode) throws UpdatesPizzaException {
		// TODO Auto-generated method stub

	}
	// ****************************************************//
	// ****************************************************//
	/**
	 ** Liste la liste nom des fichiers <Pizza > au sein du dossier PizzaFiles **
	 * 
	 * @return Liste des fichiers
	 */
	private List<String> listCodesPizza() {
		String[] paths = file.list();
		List<String> stringList = new ArrayList<String>(Arrays.asList(paths));
		return stringList;
	}

	private String readFile(String codeFile) {
		String fileName = "PizzaFiles/" + codeFile;
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			ArrayList<String> t = new ArrayList<String>();
			stream.forEach(a -> t.add(a));
			return t.get(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}

