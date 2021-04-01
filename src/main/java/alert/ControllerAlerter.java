package alert;

import batteryhealth.BreachType;

/**
 * Concrete class for Controller alert
 *
 */
public class ControllerAlerter implements IAlerter {

	@Override
	public void alert(BreachType breachType) {
		sendToController(breachType);
	}

	private static void sendToController(BreachType breachType) {
		double header = 0xfeed;
		System.out.printf("%f : %s\n", header, breachType);
	}

}
