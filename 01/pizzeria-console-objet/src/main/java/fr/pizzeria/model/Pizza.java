package main.java.fr.pizzeria.model;

public class Pizza {

	private int id;
	private String code;
	private String nom;
	private Double prix;
	private CategoriePizza catPizza;

	public CategoriePizza getCatPizza() {
		return catPizza;
	}

	public void setCatPizza(CategoriePizza catPizza) {
		this.catPizza = catPizza;
	}

	private static int nbPizzas;

	public Pizza(int id, String code, String nom, CategoriePizza catPizza, double prix) {
		super();
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.catPizza = catPizza;
		nbPizzas++;
	}

	public Pizza() {
		super();
		nbPizzas++;
		// TODO Auto-generated constructor stub
	}

	public int getNbPizzas() {
		return nbPizzas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", code=" + code + ", nom=" + nom + ", prix=" + prix + "]";
	}

}
