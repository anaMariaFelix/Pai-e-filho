package dto;

public class PedidoDTO{

	private String nomeCliente;
	private String emailCliente; //id
	private String telefone;
	private String servico;
	private String descricao;
	private String valor;
	private String finalizado;
	
	public PedidoDTO(String nome, String emailCliente, String telefone, String servico, String descricao, String valor,String finalizado) {
		this.nomeCliente = nome;
		this.emailCliente = emailCliente;
		this.telefone = telefone;
		this.servico = servico;
		this.descricao = descricao;
		this.valor = valor;
		this.finalizado = finalizado;
	}
	
	public String getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(String finalizado) {
		this.finalizado = finalizado;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
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

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	
}
