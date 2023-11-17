package model;

import dto.ClienteDTO;
import email.Mensageiro;
import observer.Observer;

public class Cliente implements Observer{

	private String nome;
	private String telefone;
	private String email;
	private String cpf;
	private boolean notificacao;
	
	
	public Cliente(ClienteDTO clienteDTO) {
		this.nome = clienteDTO.getNome();
		this.telefone = clienteDTO.getTelefone();
		this.email = clienteDTO.getEmail();
		this.cpf = clienteDTO.getCpf();
		this.notificacao = clienteDTO.isNotificacao();
	}
	
	@Override
	public void update(EmailObserver emailObserver) {
		Mensageiro.getInstance().setMensagem(emailObserver.getMensagem());
		Mensageiro.getInstance().setEmailCliente(email);
		Mensageiro.getInstance().start();
	}
	
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
