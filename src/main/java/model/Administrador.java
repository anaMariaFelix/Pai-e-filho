package model;

import dto.AdministradorDTO;

public class Administrador {

	private String nome;
	private String email; //id
	private String senha;
	
	public Administrador(AdministradorDTO admDTO) {
		this.nome = admDTO.getNome();
		this.email = admDTO.getEmail();
		this.senha = admDTO.getSenha();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
