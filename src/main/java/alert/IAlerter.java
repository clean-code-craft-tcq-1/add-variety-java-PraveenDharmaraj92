package alert;

import batteryhealth.BreachType;

/**
 * Interface for alert functionality
 *
 */
public interface IAlerter {
	
	/**
	 * @param breachType - LOW/HIGH/NORMAL
	 */
	public void alert(BreachType breachType);

}
