package dao;

import java.util.ArrayList;

import execoesPersonalizadas.ServicoExistenteException;

public interface ServicoDAOInterface {

	ArrayList<String> recuperarServicos();
	
	void removerServico(int indice);
	
	void adicionarServico(String novoServico) throws ServicoExistenteException;
}
