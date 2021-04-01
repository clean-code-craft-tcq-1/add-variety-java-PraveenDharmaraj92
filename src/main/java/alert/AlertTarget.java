package alert;

/**
 * Enumeration for alerters - Email and controller
 *
 */
public enum AlertTarget {
	
	TO_CONTROLLER("Controller"),
    TO_EMAIL("Email");
	
	private String alertTarget;
	
	private AlertTarget(String alertTarget) {
		this.alertTarget = alertTarget;
	}
	
	public String getAlerterAsString(){
		return this.alertTarget;
	}
}
