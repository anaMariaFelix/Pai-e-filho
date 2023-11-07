package execoesPersonalizadas;

public class ClienteExistenteException extends Exception{

	public ClienteExistenteException() {
		super("Cliente já existe");
	}
	
}
