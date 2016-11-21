package main.java.com.project.crud.domain;

public class Ammunition
{
	private int id;

	private String name;
	private float caliber;
	private int cost;
	private int Weapon_id;

	public Ammunition()
	{
	}

	Ammunition(String name, int cost, float caliber)
	{
		super();
		this.name = name;
		this.cost = cost;
		this.caliber = caliber;
	}

	public Ammunition(String name, int cost, float caliber, int Weapon_id)
	{
		super();
		this.name = name;
		this.cost = cost;
		this.caliber = caliber;
		this.Weapon_id = Weapon_id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}

	public int getWeapon_id()
	{
		return Weapon_id;
	}

	public void setWeapon_id(int Weapon_id)
	{
		this.Weapon_id = Weapon_id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getCost()
	{
		return cost;
	}

	public void setCost(int cost)
	{
		this.cost = cost;
	}

	public float getcaliber()
	{
		return caliber;
	}

	public void setcaliber(float caliber)
	{
		this.caliber = caliber;
	}
}
