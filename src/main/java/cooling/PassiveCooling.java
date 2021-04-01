package cooling;

public class PassiveCooling implements ICooling {

	@Override
	public CoolingLimit getCoolingLimit() {
		return new CoolingLimit(0, 35);
	}

}
