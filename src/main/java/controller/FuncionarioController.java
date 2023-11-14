package controller;

import java.util.ArrayList;


import dao.FuncionarioDAO;
import dto.FuncionarioDTO;
import execoesPersonalizadas.FuncionarioExistenteException;
import execoesPersonalizadas.FuncionarioNaoEncontradoException;

public class FuncionarioController {

	private volatile static FuncionarioController instance;

	private FuncionarioController() {

	}

	public static FuncionarioController getInstance() {
		if(instance == null) {
			synchronized (FuncionarioController.class) {
				if(instance == null) {
					instance = new FuncionarioController();				}

			}
		}
		return instance;
	}


	public void salvarFuncionario(FuncionarioDTO funcionarioDTO) throws FuncionarioExistenteException{
		try {
			FuncionarioDAO.getInstance().salvarFuncionario(funcionarioDTO);
		}catch(FuncionarioExistenteException e) {
			throw new FuncionarioExistenteException();
		}

	}


	public FuncionarioDTO recuperarFuncionario(FuncionarioDTO funcionarioDTO) throws FuncionarioNaoEncontradoException  {
		FuncionarioDTO funcionario = FuncionarioDAO.getInstance().recuperarFuncionario(funcionarioDTO.getEmail());

		if(funcionario != null) {
			return funcionario;
		}
		throw new FuncionarioNaoEncontradoException();		
	}


	public ArrayList<FuncionarioDTO> recuperarTodosFuncionarios() {
		return FuncionarioDAO.getInstance().recuperaTodosFuncionarios();

	}

	public void removerFuncionario(FuncionarioDTO funcionarioAntigo) {
		FuncionarioDAO.getInstance().removerFuncionario(funcionarioAntigo);
		
	}



}
