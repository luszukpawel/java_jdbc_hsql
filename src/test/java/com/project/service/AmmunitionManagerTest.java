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

 static String NAME = "TRACER";

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

}
