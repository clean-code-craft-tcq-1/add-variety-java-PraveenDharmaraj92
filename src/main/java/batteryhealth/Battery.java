package batteryhealth;

import cooling.CoolingType;

/**
 * Model class with Battery information
 *
 */
public class Battery {

	private final CoolingType coolingType;
	private final String brand;

	public Battery(final CoolingType coolingType, final String brand) {
		this.brand = brand;
		this.coolingType = coolingType;
	}

	public CoolingType getCoolingType() {
		return coolingType;
	}

	public String getBrand() {
		return brand;
	}

}
