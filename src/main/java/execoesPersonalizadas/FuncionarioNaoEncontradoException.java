package execoesPersonalizadas;

public class FuncionarioNaoEncontradoException extends Exception{

	public FuncionarioNaoEncontradoException() {
		super("Funcionário não encontrado");
	}
}
