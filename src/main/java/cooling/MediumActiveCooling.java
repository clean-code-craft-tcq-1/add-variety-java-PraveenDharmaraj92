package cooling;

public class MediumActiveCooling implements ICooling{

	@Override
	public CoolingLimit getCoolingLimit() {
		return new CoolingLimit(0, 40);
	}

}
