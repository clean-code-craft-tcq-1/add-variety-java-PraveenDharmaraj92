package cooling;

public class HighActiveCooling implements ICooling {

	@Override
	public CoolingLimit getCoolingLimit() {
		return new CoolingLimit(0, 45);
	}

}
