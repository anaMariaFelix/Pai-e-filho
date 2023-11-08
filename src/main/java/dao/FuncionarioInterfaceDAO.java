package dao;

import java.util.ArrayList;

import dto.FuncionarioDTO;
import execoesPersonalizadas.FuncionarioExistenteException;
import execoesPersonalizadas.FuncionarioNaoEncontradoException;

public interface FuncionarioInterfaceDAO {

	void salvarFuncionario(FuncionarioDTO dto) throws FuncionarioExistenteException;
	
	FuncionarioDTO recuperarFuncionario(String email) throws FuncionarioNaoEncontradoException;
	
	ArrayList<FuncionarioDTO> recuperaTodosFuncionarios();
	
	void removerFuncionario(FuncionarioDTO funcionarioAntigo);
}
