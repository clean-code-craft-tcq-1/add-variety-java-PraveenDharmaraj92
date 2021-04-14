package batteryhealth;

import cooling.CoolingLimit;

public class BreachCheckModel {
	
	public BreachCheckModel(CoolingLimit coolingLimit, double value) {
		super();
		this.coolingLimit = coolingLimit;
		this.value = value;
	}

	private CoolingLimit coolingLimit;
	
	private double value;

	public CoolingLimit getCoolingLimit() {
		return coolingLimit;
	}

	public void setCoolingLimit(CoolingLimit coolingLimit) {
		this.coolingLimit = coolingLimit;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	

}
