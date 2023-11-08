package execoesPersonalizadas;

public class EmailJaCadastradoException extends Exception{

	public EmailJaCadastradoException() {
		super("Já existe um cliente com esse email\nPor favor informe outro email.");
	}
	
}
