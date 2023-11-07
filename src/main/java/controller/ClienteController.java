package controller;

import java.util.ArrayList;

import dao.ClienteDAO;
import dto.ClienteDTO;
import execoesPersonalizadas.ClienteExistenteException;
import execoesPersonalizadas.ClienteNaoEncontradoException;
import iterator.ConcretIterator;
import iterator.Iterator;
import model.Cliente;
import model.EmailObserver;

public class ClienteController {

	private volatile static ClienteController instance;

	private ClienteController() {

	}

	public static ClienteController getInstance() {
		if(instance == null) {
			synchronized (ClienteController.class) {
				if(instance == null) {
					instance = new ClienteController();
				}

			}
		}
		return instance;
	}


	public void salvarCliente(ClienteDTO clienteDTO) throws ClienteExistenteException{
		try {
			ClienteDAO.getInstance().salvarCliente(clienteDTO);
		}catch(ClienteExistenteException e) {
			throw new ClienteExistenteException();
		}

		if(clienteDTO.isNotificacao()) {
			EmailObserver.getInstance().adicionar(new Cliente(clienteDTO));
		}
	}

	public void recuperarArrayDeClientes() {
		ArrayList<ClienteDTO> clientes = ClienteDAO.getInstance().recuperaTodosClientes();

		Iterator<ClienteDTO> arrayClientes = new ConcretIterator(clientes);

		while(arrayClientes.hasNext()) {
			ClienteDTO cliente = arrayClientes.next();
			if(cliente.isNotificacao()) {
				EmailObserver.getInstance().adicionar(new Cliente(cliente));
			}
		}

	}

	public ClienteDTO recuperarCliente(ClienteDTO cliente) throws ClienteNaoEncontradoException  {
		ClienteDTO clienteDTO = ClienteDAO.getInstance().recuperarCliente(cliente.getEmail());
		if(clienteDTO != null) {
			return clienteDTO;
		}
		throw new ClienteNaoEncontradoException();

	}


}
