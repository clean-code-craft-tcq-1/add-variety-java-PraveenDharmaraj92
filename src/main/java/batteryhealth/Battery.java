package batteryhealth;

/**
 * Model class with Battery information
 *
 */
public class Battery {

	private String coolingType;
	private final String brand;

	public Battery(final String coolingType, final String brand) {
		this.brand = brand;
		this.coolingType = coolingType;
	}

	public String getCoolingType() {
		return coolingType;
	}

	public String getBrand() {
		return brand;
	}

}
