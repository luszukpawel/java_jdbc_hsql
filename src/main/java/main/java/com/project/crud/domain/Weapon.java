package main.java.com.project.crud.domain;

public class Weapon
{
	private int id;
	private float cost;
	private String model;
	private String producer;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public float getCost()
	{
		return cost;
	}

	public void setCost(float cost)
	{
		this.cost = cost;

	}

	public String getProducer()
	{
		return producer;
	}

	public void setProducer(String producer)
	{
		this.producer = producer;
	}

	public String getModel()
	{
		return model;
	}

	public void setModel(String model)
	{
		this.model = model;
	}

	public Weapon(int id, float cost, String model, String producer)
	{
		super();
		this.id = id;
		this.cost = cost;
		this.model = model;
		this.producer = producer;
	}

	public Weapon(String _model)
	{
		this.model = _model;
	}

	public Weapon()
	{

	}
}
