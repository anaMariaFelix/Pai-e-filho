package execoesPersonalizadas;

public class FuncionarioExistenteException extends Exception{

	public FuncionarioExistenteException() {
		super("Funcionário já existe");
	}
	
}
