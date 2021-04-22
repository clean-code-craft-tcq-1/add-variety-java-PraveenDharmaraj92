package batteryhealth;

import alert.IAlerter;
import cooling.CoolingLimit;
import cooling.ICooling;

/**
 * Health checker class for checking breach
 *
 */
public class BatteryHealthChecker {

	public static BreachType classifyTemperatureBreach(ICooling cooling, BreachCheckerFunction breachChecker,double temperatureInC) {
		return inferBreach(temperatureInC, cooling.getCoolingLimit(),breachChecker);
	}

	public static BreachType inferBreach(double value, CoolingLimit limit, BreachCheckerFunction breachChecker) {
		return breachChecker.apply(new BreachCheckModel(limit, value));
	}
	
	public static void checkAndAlert(IAlerter alerter, ICooling cooling, BreachCheckerFunction breachChecker, double temperatureInC) {
		BreachType breachType = classifyTemperatureBreach(cooling, breachChecker,temperatureInC);
		alerter.alert(breachType);
	}

}
