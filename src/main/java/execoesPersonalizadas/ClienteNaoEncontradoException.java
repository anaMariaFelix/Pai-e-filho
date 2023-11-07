package execoesPersonalizadas;

public class ClienteNaoEncontradoException extends Exception{

	public ClienteNaoEncontradoException() {
		super("Cliente não encontrado");
	}
	
}
