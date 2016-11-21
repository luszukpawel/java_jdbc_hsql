package main.java.com.project.crud.domain;

public class Ammunition {
	private int id;
	
	private String name;
	private int cost;
	private int toxicity;
	private int Weapon_id;
	
	public Ammunition(String name, int cost, int toxicity) {
		super();
		this.name = name;
		this.cost = cost;
		this.toxicity = toxicity;
	}

	public Ammunition(String name, int cost, int toxicity, int Weapon_id) {
		super();
		this.name = name;
		this.cost = cost;
		this.toxicity = toxicity;
		this.Weapon_id = Weapon_id;
	}
	
	public Ammunition(){}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWeapon_id() {
		return Weapon_id;
	}
	public void setWeapon_id(int Weapon_id) {
		this.Weapon_id = Weapon_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getToxicity() {
		return toxicity;
	}
	public void setToxicity(int toxicity) {
		this.toxicity = toxicity;
	}
}
