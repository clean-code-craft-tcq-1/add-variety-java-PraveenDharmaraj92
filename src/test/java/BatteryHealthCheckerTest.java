package batteryhealth;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import alert.IAlerter;
import cooling.CoolingLimit;
import cooling.ICooling;
import factory.AlerterFactory;
import factory.CoolingTypeFactory;

/**
 * test class for Battery Health check class methods
 *
 */
public class BatteryHealthCheckerTest {

	private static final BreachCheckerFunction BREACH_CHECKER = new BreachCheckerFunction();
	private static final String MEDIUM_ACTIVE_COOLING = "MediumActiveCooling";
	private static final String HIGH_ACTIVE_COOLING = "HighActiveCooling";
	private static final String PASSIVE_COOLING = "PassiveCooling";
	
	@Rule
	public final ExpectedException thrownException = ExpectedException.none();

	@Test
	public void inferBreachHighTest() {
		CoolingLimit coolingLimit = new CoolingLimit(12, 20);
		assertTrue(BatteryHealthChecker.inferBreach(50, coolingLimit,BREACH_CHECKER) == BreachType.TOO_HIGH);
	}

	@Test
	public void inferBreachLowTest() {
		CoolingLimit coolingLimit = new CoolingLimit(12, 20);
		assertTrue(BatteryHealthChecker.inferBreach(-5, coolingLimit,BREACH_CHECKER) == BreachType.TOO_LOW);
	}

	@Test
	public void inferBreachNormalTest() {
		CoolingLimit coolingLimit = new CoolingLimit(12, 20);
		assertTrue(BatteryHealthChecker.inferBreach(15, coolingLimit,BREACH_CHECKER) == BreachType.NORMAL);
	}

	@Test
	public void classifyTempBreachPassiveTest() throws Exception {
		ICooling iCooling = CoolingTypeFactory.getInstance().getCoolingType(PASSIVE_COOLING);
		assertTrue(
				BatteryHealthChecker.classifyTemperatureBreach(iCooling, BREACH_CHECKER,30) == BreachType.NORMAL);
	}

	@Test
	public void classifyTempBreachHighActiveTest() throws Exception {
		ICooling iCooling = CoolingTypeFactory.getInstance().getCoolingType(HIGH_ACTIVE_COOLING);
		assertTrue(
				BatteryHealthChecker.classifyTemperatureBreach(iCooling, BREACH_CHECKER,40) == BreachType.NORMAL);
	}

	@Test
	public void classifyTempBreachMediumActiveTest() throws Exception {
		ICooling iCooling = CoolingTypeFactory.getInstance().getCoolingType(MEDIUM_ACTIVE_COOLING);
		assertTrue(BatteryHealthChecker.classifyTemperatureBreach(iCooling,BREACH_CHECKER,
				35) == BreachType.NORMAL);
	}

	@Test
	public void breachCheckFunctionTest(){
		BreachCheckerFunction function = new BreachCheckerFunction();
		BreachCheckModel model = new BreachCheckModel(new CoolingLimit(5, 10), 11);
		assertTrue(function.apply(model)==BreachType.TOO_HIGH);
	}

	@Test
	public void emailAlerterTest() throws Exception {
		checkAndAlertTest("EmailAlerter",HIGH_ACTIVE_COOLING, BreachType.TOO_HIGH);
	}

	@Test
	public void controllerAlerterTest() throws Exception {
		checkAndAlertTest("ControllerAlerter",MEDIUM_ACTIVE_COOLING,BreachType.TOO_HIGH);
	}
	
	@Test
	public void consoleAlerterTest() throws Exception {
		checkAndAlertTest("ConsoleAlerter",PASSIVE_COOLING,BreachType.TOO_HIGH);
	}
	
	private void checkAndAlertTest(String alerter, String coolingType, BreachType breachType) throws Exception{
		ICooling cooling = CoolingTypeFactory.getInstance().getCoolingType(coolingType);
		IAlerter alerterSpy = Mockito.spy(AlerterFactory.getInstance().getAlerter(alerter));
		BatteryHealthChecker.checkAndAlert(alerterSpy, cooling,BREACH_CHECKER,50);
		Mockito.verify(alerterSpy).alert(breachType);
	}
	
}
