
public interface ServiceMail {
	boolean sendEmail(String address);
	boolean sendMail(String address);
	String defineSubject(String subject);
	String defineContent(String content);
	String defineSender(String sender);
	String definePassword(String password);
}
