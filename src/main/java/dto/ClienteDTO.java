package dto;

public class ClienteDTO{

	private String nome;
	private String telefone;
	private String email;
	private String cpf;
	private boolean notificacao;
	
	public ClienteDTO(String nome, String telefone, String email, String cpf,boolean notificacao) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cpf = cpf;
		this.notificacao = notificacao;
	}
	
	//Ana feia
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public boolean isNotificacao() {
		return notificacao;
	}

	public void setNotificacao(boolean notificacao) {
		this.notificacao = notificacao;
	}

	
	
	
}
