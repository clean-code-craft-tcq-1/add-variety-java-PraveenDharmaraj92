package alert;

import batteryhealth.BreachType;

/**
 * Concrete class for email alert
 *
 */
public class EmailAlerter implements IAlerter{

	@Override
	public void alert(BreachType breachType) {
		sendToEmail(breachType);
	}
	
    private void sendToEmail(BreachType breachType) {
        String recepient = "a.b@c.com";
        switch(breachType) {
          case TOO_LOW:
            System.out.printf("To: %s\n", recepient);
            System.out.println("Hi, the temperature is too low\n");
            break;
          case TOO_HIGH:
            System.out.printf("To: %s\n", recepient);
            System.out.println("Hi, the temperature is too high\n");
            break;
          case NORMAL:
            break;
        }
      }

}
