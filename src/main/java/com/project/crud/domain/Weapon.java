package main.java.com.project.crud.domain;

public class Weapon {
	private int id;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String model;

	public String getModel() {
		return model;
	}

	public void setName(String model) {
		this.model = model;
	}	
	
	public Weapon(String _model) {
		this.model = _model;
	}
	
	public Weapon(){
	
	}
}
