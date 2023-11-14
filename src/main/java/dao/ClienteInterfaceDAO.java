package dao;

import java.util.ArrayList;

import dto.ClienteDTO;
import execoesPersonalizadas.EmailJaCadastradoException;
import execoesPersonalizadas.ClienteNaoEncontradoException;

public interface ClienteInterfaceDAO {

	void salvarCliente(ClienteDTO dto) throws EmailJaCadastradoException;
	
	ClienteDTO recuperarCliente(String email) throws ClienteNaoEncontradoException;
	
	ArrayList<ClienteDTO> recuperaTodosClientes();
	
	void removerClienteEditado(ClienteDTO clienteDTO);
	
	boolean verificaSeClienteExiste(String email);
}
