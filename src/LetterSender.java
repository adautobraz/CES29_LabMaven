
public class LetterSender implements SenderInterface {
	private DefaultSender mail;
	
	LetterSender(){
		mail = new DefaultSender();
	}
	
	public void send(Processo proc, boolean statusProcesso){
		if (statusProcesso)
		{
			mail.defineContent(proc.getContent());
			mail.defineSender("default_sender");
			mail.sendMail("Juiz");
		}
		else
		{
			mail.defineContent("Erro");
			mail.defineSender("default_sender");
			mail.sendMail(proc.getNomeReclamante());
		}
	}

}
