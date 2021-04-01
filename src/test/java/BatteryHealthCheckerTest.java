package test;

import static org.junit.Assert.*;

import org.junit.Test;

import alert.AlertTarget;
import cooling.CoolingLimit;
import cooling.CoolingType;

/**
 * test class for Battery Health check class methods
 *
 */
public class BatteryHealthCheckerTest {

	@Test
	public void inferBreachHighTest() {
		CoolingLimit coolingLimit = new CoolingLimit(12, 20);
		assertTrue(BatteryHealthChecker.inferBreach(50, coolingLimit) == BreachType.TOO_HIGH);
	}

	@Test
	public void inferBreachLowTest() {
		CoolingLimit coolingLimit = new CoolingLimit(12, 20);
		assertTrue(BatteryHealthChecker.inferBreach(-5, coolingLimit) == BreachType.TOO_LOW);
	}

	@Test
	public void inferBreachNormalTest() {
		CoolingLimit coolingLimit = new CoolingLimit(12, 20);
		assertTrue(BatteryHealthChecker.inferBreach(15, coolingLimit) == BreachType.NORMAL);
	}

	@Test
	public void classifyTempBreachPassiveTest() {
		assertTrue(
				BatteryHealthChecker.classifyTemperatureBreach(CoolingType.PASSIVE_COOLING, 30) == BreachType.NORMAL);
	}

	@Test
	public void classifyTempBreachHighActiveTest() {
		assertTrue(
				BatteryHealthChecker.classifyTemperatureBreach(CoolingType.HI_ACTIVE_COOLING, 40) == BreachType.NORMAL);
	}

	@Test
	public void classifyTempBreachMediumActiveTest() {
		assertTrue(BatteryHealthChecker.classifyTemperatureBreach(CoolingType.MED_ACTIVE_COOLING,
				35) == BreachType.NORMAL);
	}

	@Test
	public void emailAlerterTest() {
		Battery battery = new Battery(CoolingType.PASSIVE_COOLING, "Luminous");
		BatteryHealthChecker.checkAndAlert(AlertTarget.TO_EMAIL, battery, 50);
	}

	@Test
	public void controllerAlerterTest() {
		Battery battery = new Battery(CoolingType.PASSIVE_COOLING, "Luminous");
		BatteryHealthChecker.checkAndAlert(AlertTarget.TO_CONTROLLER, battery, 50);
	}

}
