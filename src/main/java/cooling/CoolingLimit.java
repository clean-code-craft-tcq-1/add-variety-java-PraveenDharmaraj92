package cooling;

/**
 * Model class for cooling limit
 *
 */
public class CoolingLimit {

	private final double lowerLimit;

	private final double upperLimit;

	public CoolingLimit(final double lowerLimit, final double upperLimit) {
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
	}

	public double getLowerLimit() {
		return lowerLimit;
	}

	public double getUpperLimit() {
		return upperLimit;
	}

}
