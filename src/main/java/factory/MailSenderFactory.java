package factory;

import batteryhealth.BreachType;
import mail.IMailSender;

public class MailSenderFactory {

	private static final String PACKAGE_NAME = "mail";

	private static MailSenderFactory instance;

	public IMailSender getMailSender(BreachType breachType) {
		try {
			Class<IMailSender> mailSender = (Class<IMailSender>) Class
					.forName(PACKAGE_NAME + "." + breachType.getBreachAsString()+"BreachMailSender");
			return mailSender.newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static MailSenderFactory getInstance() {
		if (instance == null) {
			instance = new MailSenderFactory();
		}
		return instance;
	}

}
