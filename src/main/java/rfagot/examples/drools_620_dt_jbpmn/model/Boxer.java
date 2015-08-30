package rfagot.examples.drools_620_dt_jbpmn.model;

public class Boxer {
	private String nom;
	private int age;
	private int poids;
	private CategorieAge ageCat;
	private CategoriePoids poidsCat;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPoids() {
		return poids;
	}
	public void setPoids(int poids) {
		this.poids = poids;
	}
	public CategorieAge getAgeCat() {
		return ageCat;
	}
	public void setAgeCat(CategorieAge ageCat) {
		this.ageCat = ageCat;
	}
	public CategoriePoids getPoidsCat() {
		return poidsCat;
	}
	public void setPoidsCat(CategoriePoids poidsCat) {
		this.poidsCat = poidsCat;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
