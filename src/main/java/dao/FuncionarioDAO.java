package dao;

import java.util.ArrayList;

import bancoDeDados.BancoDeDados;
import bancoDeDados.Persistencia;
import dto.ClienteDTO;
import dto.FuncionarioDTO;
import execoesPersonalizadas.ClienteExistenteException;
import execoesPersonalizadas.FuncionarioExistenteException;
import execoesPersonalizadas.FuncionarioNaoEncontradoException;
import iterator.ConcretIterator;
import iterator.Iterator;
import util.Constantes;

public class FuncionarioDAO implements FuncionarioInterfaceDAO{

	private volatile static FuncionarioDAO instance;
	
	private FuncionarioDAO() {
		
	}
	
	public static FuncionarioDAO getInstance() {
		if (instance == null) {
			synchronized (FuncionarioDAO.class) {
				if (instance == null) {
					instance = new FuncionarioDAO();
				}
			}
		}
		return instance;
	}

	@Override
	public void salvarFuncionario(FuncionarioDTO funcionarioDTO) throws FuncionarioExistenteException{
		
		Iterator<FuncionarioDTO> funcionarios = new ConcretIterator(BancoDeDados.getInstance().getFuncionarios());
		
		while(funcionarios.hasNext()) {
			FuncionarioDTO funcionario = funcionarios.next();
			
			if(funcionario.getEmail().equals(funcionarioDTO.getEmail())) {
				throw new FuncionarioExistenteException();
			}
		}
		
		BancoDeDados.getInstance().getFuncionarios().add(funcionarioDTO);
		Persistencia.getInstance().salvarBanco(BancoDeDados.getInstance(), Constantes.NOME_ARQUIVO_XML);
	}

	@Override
	public FuncionarioDTO recuperarFuncionario(String email) throws FuncionarioNaoEncontradoException {
		ArrayList<FuncionarioDTO> array = BancoDeDados.getInstance().getFuncionarios();
		
		Iterator<FuncionarioDTO> funcionarios = new ConcretIterator(array);
		
		while(funcionarios.hasNext()) {
			FuncionarioDTO funcionario = funcionarios.next();
			
			if(funcionario.getEmail().equals(email)) {
				return funcionario;
			}
		}
			
		throw new FuncionarioNaoEncontradoException();
	}
	
	@Override
	public ArrayList<FuncionarioDTO> recuperaTodosFuncionarios(){
		return BancoDeDados.getInstance().getFuncionarios();
	}
	
	
}
