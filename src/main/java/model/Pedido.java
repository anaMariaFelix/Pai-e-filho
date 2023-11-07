package model;

import dto.PedidoDTO;

public class Pedido {

	private String nomeCliente;
	private String emailCliente; //id
	private String telefone;
	private String servico;
	private String descricao;
	
	public Pedido(PedidoDTO pedidoDTO) {
		this.nomeCliente = pedidoDTO.getNomeCliente();
		this.emailCliente = pedidoDTO.getEmailCliente();
		this.telefone = pedidoDTO.getTelefone();
		this.servico = pedidoDTO.getServico();
		this.descricao = pedidoDTO.getDescricao();
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
