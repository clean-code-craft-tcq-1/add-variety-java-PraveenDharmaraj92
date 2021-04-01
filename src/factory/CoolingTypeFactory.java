package factory;

import cooling.CoolingType;
import cooling.ICooling;

/**
 *Factory class for cooling
 *
 */
public class CoolingTypeFactory {

	private static final String PACKAGE_NAME = "cooling";

	private static CoolingTypeFactory instance;

	public ICooling getCoolingType(CoolingType coolingType) {
		try {
			Class<ICooling> coolingTypeClass = (Class<ICooling>) Class
					.forName(PACKAGE_NAME + "." + coolingType.getCoolingTypeAsString());
			return coolingTypeClass.newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static CoolingTypeFactory getInstance() {
		if (instance == null) {
			instance = new CoolingTypeFactory();
		}
		return instance;
	}

}
