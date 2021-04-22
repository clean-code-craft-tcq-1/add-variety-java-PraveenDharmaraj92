package alert;

import java.util.ArrayList;
import java.util.List;

import batteryhealth.BreachType;

/**
 * Composite Alerter
 *
 */
public class CompositeAlerter implements IAlerter {

	private final List<IAlerter> alerters = new ArrayList<>();

	public void addAlerter(IAlerter alerter) {
		alerters.add(alerter);
	}

	@Override
	public void alert(BreachType breachType) {
		alerters.forEach(alerter->alerter.alert(breachType));
	}

}
