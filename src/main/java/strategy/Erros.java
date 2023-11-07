package strategy;

public class Erros {

	private static Strategy strategy;
	
	public static void setStrategy(Strategy st) {
		strategy = st;
	}
	
	public static void lancarErro() {
		strategy.mostrarErro();
	}
	
}
