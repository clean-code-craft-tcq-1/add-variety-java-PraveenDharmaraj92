package factory;

import cooling.ICooling;

/**
 *Factory class for cooling
 *
 */
public class CoolingTypeFactory implements IObjectFactory{

	private static final String PACKAGE_NAME = "cooling";

	private static CoolingTypeFactory instance;

	public ICooling getCoolingType(String coolingType) {
		return (ICooling) getObject(coolingType, PACKAGE_NAME);
}

	public static CoolingTypeFactory getInstance() {
		if (instance == null) {
			instance = new CoolingTypeFactory();
		}
		return instance;
	}

}
