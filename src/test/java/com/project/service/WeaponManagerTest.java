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

public class WeaponManagerTest {

	IWeaponManager WeaponManager = new WeaponManager();

	private static String MODEL = "AK-47";

	@Before
	public void clear_database(){
		WeaponManager.delete_all_Weapons();
	}

	@Test
	public void test_connection(){
		assertNotNull(((WeaponManager)WeaponManager).getConnection());
	}


}
