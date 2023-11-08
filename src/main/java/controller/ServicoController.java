package controller;

import java.util.ArrayList;

import dao.ServicoDAO;
import execoesPersonalizadas.ServicoExistenteException;

public class ServicoController {

	private volatile static ServicoController instance;

	private ServicoController() {

	}

	public static ServicoController getInstance() {
		if (instance == null) {
			synchronized (ServicoController.class) {
				if (instance == null) {
					instance = new ServicoController();
				}
			}
		}
		return instance;
	}

	public ArrayList<String> recuperarServicos() {
		return ServicoDAO.getInstance().recuperarServicos();
	}

	public void removerServico(int indice) {
		ServicoDAO.getInstance().removerServico(indice);
	}

	public void adicionarServico(String novoServico) throws ServicoExistenteException {
		try {
			ServicoDAO.getInstance().adicionarServico(novoServico);
		} catch (ServicoExistenteException e) {
			throw new ServicoExistenteException();
		}

	}

	public void editarServico(int indice, String servicoEditado) {
		ServicoDAO.getInstance().editarServico(indice, servicoEditado);

	}

}
