package controller;

import java.util.ArrayList;

import dao.ClienteDAO;
import dto.ClienteDTO;
import iterator.ConcretIterator;
import iterator.Iterator;
import model.Cliente;
import model.EmailObserver;
import observer.Observer;

public class EmailObserverController {
	
	private volatile static EmailObserverController instance;
	
	private EmailObserverController() {
		
	}
	
	public static EmailObserverController getInstance() {
		if (instance == null) {
			synchronized (EmailObserverController.class) {
				if (instance == null) {
					instance = new EmailObserverController();
				}
			}
		}
		return instance;
	}
	

	public void preencherArrayNotificados() {
		ArrayList<ClienteDTO> clientes = ClienteDAO.getInstance().recuperaTodosClientes();

		Iterator<ClienteDTO> arrayClientes = new ConcretIterator(clientes);

		while(arrayClientes.hasNext()) {
			ClienteDTO cliente = arrayClientes.next();
			if(cliente.isNotificacao()) {
				EmailObserver.getInstance().adicionar(new Cliente(cliente));
			}
		}
	}
	
	public void removerNotificado(ClienteDTO cliente) {
		EmailObserver.getInstance().remover(cliente.getEmail());
	}
	
	
	public void setMensagem(String mensagem) {
		EmailObserver.getInstance().setMensagem(mensagem);
	}
	
}
