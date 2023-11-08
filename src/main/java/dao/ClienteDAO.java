package dao;

import java.util.ArrayList;

import bancoDeDados.BancoDeDados;
import bancoDeDados.Persistencia;
import dto.ClienteDTO;
import execoesPersonalizadas.EmailJaCadastradoException;
import execoesPersonalizadas.ClienteNaoEncontradoException;
import iterator.ConcretIterator;
import iterator.Iterator;
import util.Constantes;

public class ClienteDAO implements ClienteInterfaceDAO{

	private volatile static ClienteDAO instance;
	
	
	private ClienteDAO() {
		
	}
	
	public static ClienteDAO getInstance() {
		if (instance == null) {
			synchronized (ClienteDAO.class) {
				if (instance == null) {
					instance = new ClienteDAO();
				}
			}
		}
		return instance;
	}

	@Override
	public void salvarCliente(ClienteDTO clienteDTO) throws EmailJaCadastradoException {
		
		Iterator<ClienteDTO> clientes = new ConcretIterator(BancoDeDados.getInstance().getClientes());
		
		while(clientes.hasNext()) {
			ClienteDTO cliente = clientes.next();
			
			if(cliente.getEmail().equals(clienteDTO.getEmail())) {
				throw new EmailJaCadastradoException();
			}
		}
		
		BancoDeDados.getInstance().getClientes().add(clienteDTO);
		Persistencia.getInstance().salvarBanco(BancoDeDados.getInstance(), Constantes.NOME_ARQUIVO_XML);
			
	}

	@Override
	public ClienteDTO recuperarCliente(String email) throws ClienteNaoEncontradoException {
		ArrayList<ClienteDTO> array = BancoDeDados.getInstance().getClientes();
		
		Iterator<ClienteDTO> clientes = new ConcretIterator(array);
		
		while(clientes.hasNext()) {
			ClienteDTO cliente = clientes.next();
			if(cliente.getEmail().equals(email)) {
				return cliente;
			}
		}
		
		throw new ClienteNaoEncontradoException();
		
	}
	
	@Override
	public ArrayList<ClienteDTO> recuperaTodosClientes(){
		return BancoDeDados.getInstance().getClientes();
	}

	
	
}
