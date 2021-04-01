package cooling;

/**
 * Enumeration for cooling types - Passive, Hiactive, MedACtive
 *
 */
public enum CoolingType {
	
	PASSIVE_COOLING("PassiveCooling"), HI_ACTIVE_COOLING("HighActiveCooling"), MED_ACTIVE_COOLING("MediumActiveCooling");
	
	private String coolingType;
	
	private CoolingType(String coolingType) {
		this.coolingType = coolingType;
	}
	
	public String getCoolingTypeAsString(){
		return this.coolingType;
	}
	
	
	
}
