package batteryhealth;

/**
 * Enumeration for Breach types
 *
 */
public enum BreachType {

	NORMAL("Normal"), TOO_LOW("Low"), TOO_HIGH("High");

	private String type;

	private BreachType(String breachType) {
		this.type = breachType;
	}

	public String getBreachAsString() {
		return this.type;
	}
}
