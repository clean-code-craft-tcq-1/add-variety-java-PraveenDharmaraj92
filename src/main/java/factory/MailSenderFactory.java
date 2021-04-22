package factory;

import batteryhealth.BreachType;
import mail.IMailSender;

public class MailSenderFactory implements IObjectFactory {

	private static final String PACKAGE_NAME = "mail";

	private static MailSenderFactory instance;

	public IMailSender getMailSender(BreachType breachType) throws Exception {
		return (IMailSender) getObject(breachType.getBreachAsString()+"BreachMailSender", PACKAGE_NAME);
	}

	public static MailSenderFactory getInstance() {
		if (instance == null) {
			instance = new MailSenderFactory();
		}
		return instance;
	}

}
