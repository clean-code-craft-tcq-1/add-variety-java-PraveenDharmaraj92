package alert;

import batteryhealth.BreachType;
import factory.MailSenderFactory;
import mail.IMailSender;

/**
 * Concrete class for email alert
 *
 */
public class EmailAlerter implements IAlerter{
	
	String recepient = "a.b@c.com";

	@Override
	public void alert(BreachType breachType) {
		IMailSender mailTemplate = MailSenderFactory.getInstance().getMailSender(breachType);
        mailTemplate.sendMail(recepient);
	}
	
}
