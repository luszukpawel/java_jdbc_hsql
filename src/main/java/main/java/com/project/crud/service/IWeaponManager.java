package main.java.com.project.crud.service;

import java.util.List;

import main.java.com.project.crud.domain.Ammunition;
import main.java.com.project.crud.domain.Weapon;

public interface IWeaponManager
{
	//dodanie do tabeli x
	public boolean add_Weapon(Weapon Weapon);

	//pobranie wszystkich y
	public List<Weapon> get_all_Weapons();

	public boolean update_Weapon(String old_name, String new_name);

	//TRANSACTION
	public boolean add_all_Weapons(List<Weapon> pharmacies);

	public void delete_all_Weapons();
	public int delete_Weapon(Weapon Weapon);

	// change ?
	public int select_id_from_Weapon(String name);
}