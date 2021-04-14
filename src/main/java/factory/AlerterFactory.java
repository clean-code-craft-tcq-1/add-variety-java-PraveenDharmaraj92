package factory;

import alert.IAlerter;

/**
 * Factory class for alerter
 *
 */
public class AlerterFactory implements IObjectFactory{

	private static final String PACKAGE_NAME = "alert";

	private static AlerterFactory instance;

	public IAlerter getAlerter(String alerterType) {
		return (IAlerter) getObject(alerterType, PACKAGE_NAME);
	}

	public static AlerterFactory getInstance() {
		if (instance == null) {
			instance = new AlerterFactory();
		}
		return instance;
	}

}
