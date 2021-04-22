package mail;

public class LowBreachMailSender implements IMailSender {

	@Override
	public void sendMail(String recepient) {
		System.out.printf("To: %s\n", recepient);
        System.out.println("Hi, the temperature is too low\n");
	}

}
