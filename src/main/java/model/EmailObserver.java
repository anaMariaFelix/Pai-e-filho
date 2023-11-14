package model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import iterator.ConcretIterator;
import iterator.Iterator;
import observer.Observer;

public class EmailObserver {
	
	private volatile static EmailObserver instance;
	
	private ArrayList<Observer> clientesObserver = new ArrayList();
	private String mensagem;
	
	private EmailObserver() {
		
	}
	
	public static EmailObserver getInstance() {
		if(instance == null) {
			synchronized (EmailObserver.class) {
				if(instance == null) {
					instance = new EmailObserver();
				}
			}
		}
		return instance;
	}
	
	public void adicionar(Observer cliente) {
		clientesObserver.add(cliente);
	}
	
	public void notificacao() {
		Iterator<Observer> clientes = new ConcretIterator(clientesObserver);
		while(clientes.hasNext()) {
			Cliente elemento = (Cliente) clientes.next();
			elemento.update(this);
		}
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
		notificacao();
	}

	public ArrayList<Observer> getClientesObserver() {
		return clientesObserver;
	}

	public void setClientesObserver(ArrayList<Observer> clientesObserver) {
		this.clientesObserver = clientesObserver;
	}
	
	
	
}
