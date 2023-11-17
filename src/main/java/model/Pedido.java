package model;

import dto.PedidoDTO;

public class Pedido {

	private String nomeCliente;
	private String emailCliente;
	private String telefone;
	private String servico;
	private String descricao;
	private String valor;
	private String finalizado = "andamento";	

	public Pedido(PedidoDTO pedidoDTO) {
		this.nomeCliente = pedidoDTO.getNomeCliente();
		this.emailCliente = pedidoDTO.getEmailCliente();
		this.telefone = pedidoDTO.getTelefone();
		this.servico = pedidoDTO.getServico();
		this.descricao = pedidoDTO.getDescricao();
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
