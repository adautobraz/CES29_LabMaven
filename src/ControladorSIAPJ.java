
public class ControladorSIAPJ{
	private ValidadorProcesso validator = new ValidadorProcesso();
	private Database database;
	
	public void setDatabaseConnection(Database db){
		database = db;
	}
	
	public boolean initProcesso(Processo proc){
		return initProcesso(proc, false);
	}
	
	public boolean initProcesso(Processo proc, boolean useLetter)
	{
		SenderInterface msgSender;
		SenderFactory factory = new SenderFactory();
		if(useLetter)
			msgSender = factory.build("CARTA");
		else
			msgSender = factory.build("EMAIL");
		
		if(!checkProcesso(proc)){	
			msgSender.send(proc, false);
			return false;
		}
		if(persistProcesso(proc))
			msgSender.send(proc, true);
		
		return true;
	}
	
	private boolean checkProcesso(Processo proc){
		return validator.validateProcess(proc);
	}
	
	private boolean persistProcesso(Processo proc){
		return database.persist(proc);
	}
}
