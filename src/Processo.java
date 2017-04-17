
public class Processo {
	private int id;
	private String NomeReclamante;
	private String Telefone;
	private String Email;
	private String Content;
	
        public Processo(){
        }
        
        public Processo(int id,String NomeReclamante,String Telefone,String Email,
                String Content){
            this.id = id;
            this.NomeReclamante = NomeReclamante;
            this.Telefone = Telefone;
            this.Email = Email;
            this.Content = Content;
        }
        
	public String getNomeReclamante() {
		return NomeReclamante;
	}
	public void setNomeReclamante(String nomeReclamante) {
		NomeReclamante = nomeReclamante;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
}
