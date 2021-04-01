package batteryhealth;

import alert.AlertTarget;
import alert.IAlerter;
import cooling.CoolingLimit;
import cooling.CoolingType;
import cooling.ICooling;
import factory.AlerterFactory;
import factory.CoolingTypeFactory;

/**
 * Health checker class for checking breach
 *
 */
public class BatteryHealthChecker {

	public static BreachType classifyTemperatureBreach(CoolingType coolingType, double temperatureInC) {
		ICooling iCooling = CoolingTypeFactory.getInstance().getCoolingType(coolingType);
		return inferBreach(temperatureInC, iCooling.getCoolingLimit());
	}

	public static BreachType inferBreach(double value, CoolingLimit limit) {
		if (value < limit.getLowerLimit()) {
			return BreachType.TOO_LOW;
		}
		if (value > limit.getUpperLimit()) {
			return BreachType.TOO_HIGH;
		}
		return BreachType.NORMAL;
	}

	public static void checkAndAlert(AlertTarget alertTarget, Battery battery, double temperatureInC) {
		BreachType breachType = classifyTemperatureBreach(battery.getCoolingType(), temperatureInC);
		IAlerter alerter = AlerterFactory.getInstance().getAlerter(alertTarget);
		alerter.alert(breachType);
	}

}
