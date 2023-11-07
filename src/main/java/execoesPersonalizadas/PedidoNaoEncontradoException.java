package execoesPersonalizadas;

public class PedidoNaoEncontradoException extends Exception{

	public PedidoNaoEncontradoException() {
		super("Pedido não foi encontrado");
	}
}
