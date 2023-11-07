package dao;

import java.util.ArrayList;

import dto.ClienteDTO;
import execoesPersonalizadas.ClienteExistenteException;
import execoesPersonalizadas.ClienteNaoEncontradoException;

public interface ClienteInterfaceDAO {

	void salvarCliente(ClienteDTO dto) throws ClienteExistenteException;
	
	ClienteDTO recuperarCliente(String email) throws ClienteNaoEncontradoException;
	
	ArrayList<ClienteDTO> recuperaTodosClientes();
}
