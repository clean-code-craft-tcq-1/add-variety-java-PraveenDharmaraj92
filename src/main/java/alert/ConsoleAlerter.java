package alert;

import batteryhealth.BreachType;

public class ConsoleAlerter implements IAlerter {

	@Override
	public void alert(BreachType breachType) {
		System.out.println("Breach alert - "+breachType);

	}

}
