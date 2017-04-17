
public class SenderFactory {
	SenderInterface build(String type){
		if(type == "CARTA")
			return new LetterSender();
		else
			return new EmailSender();
	}
	

}
