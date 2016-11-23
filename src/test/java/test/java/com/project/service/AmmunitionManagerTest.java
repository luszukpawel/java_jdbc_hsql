package test.java.com.project.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import main.java.com.project.crud.domain.Ammunition;
import main.java.com.project.crud.domain.Weapon;
import main.java.com.project.crud.service.IAmmunitionManager;
import main.java.com.project.crud.service.AmmunitionManager;
import main.java.com.project.crud.service.WeaponManager;

import org.junit.Before;
import org.junit.Test;

public class AmmunitionManagerTest
{
	WeaponManager weaponManager = new WeaponManager();
	IAmmunitionManager AmmunitionManager = new AmmunitionManager();

	@Before
	public void clear_database()
	{
		weaponManager.delete_all_Weapons();
		AmmunitionManager.delete_all_Ammunitions();
	}

	private final static String NAME = "TRACER";

	@Test
	public void test_connection()
	{
		assertNotNull(((AmmunitionManager) AmmunitionManager).getConnection());
	}

	@Test
	public void test_insert()
	{
		weaponManager.add_Weapon(new Weapon("Weapon1"));
		Ammunition Ammunition = new Ammunition(NAME, 20, 10, weaponManager.select_id_from_Weapon("Weapon1"));
		assertEquals(true, AmmunitionManager.add_Ammunition(Ammunition));

		List<Ammunition> Ammunitions = AmmunitionManager.get_all_Ammunitions();
		Ammunition AmmunitionRetrieved = Ammunitions.get(0);
		assertEquals(NAME, AmmunitionRetrieved.getName());
	}

	@Test
	public void test_update()
	{
		weaponManager.add_Weapon(new Weapon("Ammunition"));
		weaponManager.add_Weapon(new Weapon("Ammunition2"));
		// Adding for test :
		int ammo_id1 = weaponManager.select_id_from_Weapon("Ammunition");
		int ammo_id2 = weaponManager.select_id_from_Weapon("Ammunition2");
		Ammunition Ammunition = new Ammunition(NAME, 10, 30, ammo_id1);
		AmmunitionManager.add_Ammunition(Ammunition);

		Ammunition AmmunitionNew = new Ammunition(NAME, 99, 4, ammo_id2);
		assertEquals(true, AmmunitionManager.update_Ammunition(Ammunition, AmmunitionNew));
	}

	@Test
	public void test_get_Ammunitions()
	{
		weaponManager.add_Weapon(new Weapon("Test Ammunition"));
		// Adding for test :
		int Weapon_id = weaponManager.select_id_from_Weapon("Test Ammunition");
		for (int i = 0; i < 10; i++)
		{
			Ammunition Ammunition = new Ammunition("Ammunition " + i, i, 23, Weapon_id);
			AmmunitionManager.add_Ammunition(Ammunition);
		}
		List<Ammunition> Ammunitions = AmmunitionManager.get_all_Ammunitions();
		assertEquals(10, Ammunitions.size());
	}

	@Test
	public void test_delete_one()
	{
		weaponManager.add_Weapon(new Weapon("Ammunition"));
		int Weapon_id = weaponManager.select_id_from_Weapon("Ammunition");
		Ammunition Ammunition = new Ammunition(NAME, 1, 1, Weapon_id);
		AmmunitionManager.add_Ammunition(Ammunition);
		Ammunition Ammunition2 = new Ammunition("Ammunition2", 2, 2, Weapon_id);
		AmmunitionManager.add_Ammunition(Ammunition2);

		AmmunitionManager.delete_Ammunition(Ammunition);
		List<Ammunition> Ammunitions = AmmunitionManager.get_all_Ammunitions();
		assertEquals(1, Ammunitions.size());
		Ammunition check = Ammunitions.get(0);
		
		assertEquals("Ammunition2", check.getName());
	}

	@Test
	public void test_delete()
	{

		weaponManager.add_Weapon(new Weapon("Weapon2"));
		int Weapon_id = weaponManager.select_id_from_Weapon("Weapon2");
		Ammunition Ammunition = new Ammunition(NAME, 11, 1, Weapon_id);
		AmmunitionManager.add_Ammunition(Ammunition);
		AmmunitionManager.delete_all_Ammunitions();
		List<Ammunition> Ammunitions = AmmunitionManager.get_all_Ammunitions();
		assertEquals(0, Ammunitions.size());
	}

}
