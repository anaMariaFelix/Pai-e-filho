package execoesPersonalizadas;

public class ServicoExistenteException extends Exception{

	public ServicoExistenteException() {
		super("Serviço já existente");
	}
	
}
