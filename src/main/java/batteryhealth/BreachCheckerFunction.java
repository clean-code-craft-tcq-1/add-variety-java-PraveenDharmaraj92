package batteryhealth;

import java.util.function.Function;

public class BreachCheckerFunction implements Function<BreachCheckModel, BreachType>{
	
	@Override
	public BreachType apply(BreachCheckModel model) {
		if (model.getValue() < model.getCoolingLimit().getLowerLimit()) {
			return BreachType.TOO_LOW;
		}
		if (model.getValue() > model.getCoolingLimit().getUpperLimit()) {
			return BreachType.TOO_HIGH;
		}
		return BreachType.NORMAL;
	}

}
