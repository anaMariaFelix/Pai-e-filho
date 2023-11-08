package dao;

import java.util.ArrayList;

import bancoDeDados.BancoDeDados;
import bancoDeDados.Persistencia;
import execoesPersonalizadas.ServicoExistenteException;
import iterator.ConcretIterator;
import iterator.Iterator;
import util.Constantes;

public class ServicoDAO implements ServicoDAOInterface{
	
	private volatile static ServicoDAO instance;
	
	private ServicoDAO() {
		
	}
	
	public static ServicoDAO getInstance() {
		if (instance == null) {
			synchronized (ServicoDAO.class) {
				if (instance == null) {
					instance = new ServicoDAO();
				}
			}
		}
		return instance;
	}
	

	@Override
	public ArrayList<String> recuperarServicos() {
		return BancoDeDados.getInstance().getTodosServicos();
	}

	@Override
	public void removerServico(int indice) {
		BancoDeDados.getInstance().getTodosServicos().remove(indice);
		Persistencia.getInstance().salvarBanco(BancoDeDados.getInstance(), Constantes.NOME_ARQUIVO_XML);
	}

	@Override
	public void adicionarServico(String novoServico) throws ServicoExistenteException {
		
		Iterator<String> servicos = new ConcretIterator(BancoDeDados.getInstance().getTodosServicos());
		
		while (servicos.hasNext()) {
			String servico = servicos.next();
			
			if (novoServico.equals(servico)) {
				throw new ServicoExistenteException();
			}
		}
		
		BancoDeDados.getInstance().getTodosServicos().add(novoServico);
		Persistencia.getInstance().salvarBanco(BancoDeDados.getInstance(), Constantes.NOME_ARQUIVO_XML);
		
	}

	public void editarServico(int indice, String servicoEditado) {
		String valorAntigo = BancoDeDados.getInstance().getTodosServicos().get(indice);
		BancoDeDados.getInstance().getTodosServicos().remove(valorAntigo);
		
		BancoDeDados.getInstance().getTodosServicos().add(indice,servicoEditado);
		Persistencia.getInstance().salvarBanco(BancoDeDados.getInstance(), Constantes.NOME_ARQUIVO_XML);
		
	}

}
