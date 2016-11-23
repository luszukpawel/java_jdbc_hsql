package main.java.com.project.crud.service;

import java.util.List;

import main.java.com.project.crud.domain.Ammunition;
import main.java.com.project.crud.domain.Weapon;

public interface IAmmunitionManager
{
	// dodanie do tabeli x
	public boolean add_Ammunition(Ammunition Ammunition);

	public boolean add_all_Ammunitions(List<Ammunition> ammunitions);

	// UPDATE
	public boolean update_Ammunition(Ammunition old_ammunition, Ammunition new_ammunition);

	// DELETE
	public int delete_Ammunition(Ammunition Ammunition);

	public void delete_all_Ammunitions();

	// SELECT
	public List<Ammunition> get_all_Ammunitions();

	// OTHER
	public void set_Weapon_for_Ammunition(Ammunition Ammunition, String Weapon_name);

	// pobranie x należących do y
	public List<Ammunition> get_all_Ammunitions_for_Weapons(String name);

	//change ?
	public boolean move_to_another_Weapon(Ammunition which, Weapon new_ph);
}
