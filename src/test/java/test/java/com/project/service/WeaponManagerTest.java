package test.java.com.project.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import main.java.com.project.crud.domain.Ammunition;
import main.java.com.project.crud.domain.Weapon;
import main.java.com.project.crud.service.IAmmunitionManager;
import main.java.com.project.crud.service.IWeaponManager;
import main.java.com.project.crud.service.AmmunitionManager;
import main.java.com.project.crud.service.WeaponManager;

import org.junit.Before;
import org.junit.Test;

public class WeaponManagerTest
{
	IWeaponManager WeaponManager = new WeaponManager();

	private static String model = "AK-47";
	

		
	
	@Before
	public void clear_database()
	{
		WeaponManager.delete_all_Weapons();
	}

	@Test
	public void test_connection()
	{
		assertNotNull(((WeaponManager) WeaponManager).getConnection());
	}

	@Test
	public void test_insert()
	{
		Weapon Weapon = new Weapon(model);
		assertEquals(true, WeaponManager.add_Weapon(Weapon));
		List<Weapon> weapons = WeaponManager.get_all_Weapons();
		// ?????
		Weapon personRetrieved = weapons.get(0);
		assertEquals(model, personRetrieved.getModel());
	}

	@Test
	public void test_delete_one()
	{
		WeaponManager.delete_all_Weapons();
		Weapon Weapon = new Weapon(model);
		WeaponManager.add_Weapon(Weapon);

		assertEquals(1, ((WeaponManager) WeaponManager).delete_Weapon(Weapon));
	}

	@Test
	public void test_delete_all()
	{
		// Adding :

		List<Weapon> test_weapons = new ArrayList<Weapon>();
		Weapon p1 = new Weapon("MP5");
		Weapon p2 = new Weapon("RPG-7");
		Weapon p3 = new Weapon("UZI");
		Weapon p4 = new Weapon("Remington");
		test_weapons.add(p1);
		test_weapons.add(p2);
		test_weapons.add(p3);
		test_weapons.add(p4);

		WeaponManager.delete_all_Weapons();

		WeaponManager.add_all_Weapons(test_weapons);

		// Delete :

		((WeaponManager) WeaponManager).delete_all_Weapons();
		List<Weapon> weapons = WeaponManager.get_all_Weapons();
		assertEquals(0, weapons.size());
	}

	@Test
	public void test_insert_all()
	{
		List<Weapon> test_weapons = new ArrayList<Weapon>();
		Weapon p1 = new Weapon("MP5");
		Weapon p2 = new Weapon("RPG-7");
		Weapon p3 = new Weapon("UZI");
		Weapon p4 = new Weapon("Remington");
		test_weapons.add(p1);
		test_weapons.add(p2);
		test_weapons.add(p3);
		test_weapons.add(p4);

		WeaponManager.delete_all_Weapons();

		WeaponManager.add_all_Weapons(test_weapons);

		List<Weapon> all = WeaponManager.get_all_Weapons();
		assertEquals(4, all.size());
	}

	@Test
	public void test_update()
	{
		WeaponManager.delete_all_Weapons();
		Weapon Weapon = new Weapon(model);
		WeaponManager.add_Weapon(Weapon);
		assertEquals(true, WeaponManager.update_Weapon(Weapon.getModel(), "test1"));
		WeaponManager.delete_all_Weapons();
	}

	@Test
	public void test_Ammunitions_from_Weapon()
	{

		IAmmunitionManager ammunitionManager = new AmmunitionManager();
		ammunitionManager.delete_all_Ammunitions();
		WeaponManager.add_Weapon(new Weapon("M4A1"));

		int ammo_id = WeaponManager.select_id_from_Weapon("M4A1");

		ammunitionManager.add_Ammunition(new Ammunition("DUMMY", 1, 1, ammo_id));
		ammunitionManager.add_Ammunition(new Ammunition("TRACER", 1, 1, ammo_id));
		ammunitionManager.add_Ammunition(new Ammunition("BUMBUM", 1, 1, ammo_id));

		List<Ammunition> ammunitions = ammunitionManager.get_all_Ammunitions_for_Weapons("M4A1");
		assertEquals(3, ammunitions.size());
		ammunitionManager.delete_all_Ammunitions();
	}
	@Test
	public void first_test()
	{
		List<Weapon> test_weapons = new ArrayList<Weapon>();
		Weapon p1 = new Weapon("MP5");
		Weapon p2 = new Weapon("RPG-7");
		Weapon p3 = new Weapon("UZI");
		Weapon p4 = new Weapon("Remington");
		test_weapons.add(p1);
		test_weapons.add(p2);
		test_weapons.add(p3);
		test_weapons.add(p4);
		WeaponManager.add_all_Weapons(test_weapons);
	}

}
