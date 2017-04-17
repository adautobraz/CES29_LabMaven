
public class EmailSender implements SenderInterface {
	private DefaultSender mail;
	
	EmailSender(){
		mail = new DefaultSender();
	}
	
	public void send (Processo proc, boolean statusProcesso){
		if (statusProcesso)
		{
			mail.defineContent(proc.getContent());
			mail.defineSender("default_sender");
			mail.sendEmail("juiz@ita.com");
		}
		else
		{
			mail.defineContent("Erro");
			mail.defineSender("default_sender");
			mail.sendEmail(proc.getEmail());
		}
	}
}
