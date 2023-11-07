package model;

import dto.FuncionarioDTO;

public class Funcionario {

	private String nome;
	private String telefone;
	private String email; //id
	private String cpf;
	
	public Funcionario(FuncionarioDTO funcionarioDTO) {
		this.nome = funcionarioDTO.getNome();
		this.telefone = funcionarioDTO.getTelefone();
		this.email = funcionarioDTO.getEmail();
		this.cpf = funcionarioDTO.getCpf();
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
	
}
