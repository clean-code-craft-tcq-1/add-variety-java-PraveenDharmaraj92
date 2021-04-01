package factory;

import alert.AlertTarget;
import alert.IAlerter;

/**
 * Factory class for alerter
 *
 */
public class AlerterFactory {

	private static final String CLASS_NAME = "Alerter";

	private static final String PACKAGE_NAME = "alert";

	private static AlerterFactory instance;

	public IAlerter getAlerter(AlertTarget alertTarget) {
		try {
			Class<IAlerter> breachChecker = (Class<IAlerter>) Class
					.forName(PACKAGE_NAME + "." + alertTarget.getAlerterAsString() + CLASS_NAME);
			return breachChecker.newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static AlerterFactory getInstance() {
		if (instance == null) {
			instance = new AlerterFactory();
		}
		return instance;
	}

}
