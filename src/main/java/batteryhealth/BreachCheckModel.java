package batteryhealth;

import cooling.CoolingLimit;

public class BreachCheckModel {

	private final CoolingLimit coolingLimit;

	private final double value;

	public BreachCheckModel(CoolingLimit coolingLimit, double value) {
		super();
		this.coolingLimit = coolingLimit;
		this.value = value;
	}

	public CoolingLimit getCoolingLimit() {
		return coolingLimit;
	}

	public double getValue() {
		return value;
	}

}
