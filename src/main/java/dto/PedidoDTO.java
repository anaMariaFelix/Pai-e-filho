package dto;

public class PedidoDTO{

	private String nomeCliente;
	private String emailCliente; //id
	private String telefone;
	private String servico;
	private String descricao;
	
	public PedidoDTO(String nome, String emailCliente, String telefone, String servico, String descricao) {
		this.nomeCliente = nome;
		this.emailCliente = emailCliente;
		this.telefone = telefone;
		this.servico = servico;
		this.descricao = descricao;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeClitente(String nome) {
		this.nomeCliente = nome;
	}
	public String getEmailCliente() {
		return emailCliente;
	}
	public void setEmailCliente(String cpf) {
		this.emailCliente = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getServico() {
		return servico;
	}
	public void setServico(String servico) {
		this.servico = servico;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
