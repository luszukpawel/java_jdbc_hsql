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

public class AmmunitionManagerTest {
	WeaponManager weaponManager = new WeaponManager();
	IAmmunitionManager AmmunitionManager = new AmmunitionManager();

	@Before
	public void clear_database(){
		weaponManager.delete_all_Weapons();
		AmmunitionManager.delete_all_Ammunitions();
	}

	private final static String NAME_1 = "TRACER";

	@Test
	public void test_connection(){
		assertNotNull(((AmmunitionManager)AmmunitionManager).getConnection());
	}
	@Test
	public void test_add(){
		weaponManager.add_Weapon(new Weapon("Test Ammunition"));
		Ammunition Ammunition = new Ammunition(NAME_1, 20, 10, weaponManager.select_id_from_Weapon("Test Ammunition"));
		assertEquals(true,AmmunitionManager.add_Ammunition(Ammunition));

		List<Ammunition> Ammunitions = AmmunitionManager.get_all_Ammunitions();
		Ammunition AmmunitionRetrieved = Ammunitions.get(0);
		assertEquals(NAME_1, AmmunitionRetrieved.getName());
	}
	/*
	@Test
	public void test_add_all_ok(){
		weaponManager.add_Weapon(new Weapon("TestAddAll"));
		List<Ammunition> ammunitions_test = new ArrayList<Ammunition>();
		int Weapon_id = weaponManager.select_id_from_Weapon("TestAddAll");
		Ammunition ammo1 = new Ammunition("SRTA", 20, 81, Weapon_id);
		Ammunition ammo2 = new Ammunition("BLANK", 20, 81, Weapon_id);
		Ammunition ammo3 = new Ammunition("DUMMY", 20, 81, Weapon_id);
		Ammunition ammo4 = new Ammunition("DUMMY", 20, 81, Weapon_id);
		ammunitions_test.add(ammo1);
		ammunitions_test.add(ammo2);
		ammunitions_test.add(ammo3);
		ammunitions_test.add(ammo4);

		AmmunitionManager.add_all_Ammunitions(ammunitions_test);

		List<Ammunition> all = AmmunitionManager.get_all_Ammunitions();
		assertEquals(4, all.size());
	}
	*/
	@Test
	public void test_add_all_bad(){
	}

	@Test
	public void test_update(){
	}

	@Test
	public void test_get_Ammunitions(){
	}

	@Test
	public void test_delete_one(){
	}

	@Test
	public void test_delete(){
	}

	@Test
	public void test_move_to_another_Weapon(){
}
