package relatorio;

public class RelatorioFactory {

	public static Relatorio criaPizzar(String tipo) {
		Relatorio relatorio = null;
		
		if(tipo.equalsIgnoreCase("cliente")) {
			relatorio = new RelatorioCliente();
			
		}else if(tipo.equals("pedido")) {
			relatorio = new RelatorioPedido();
		}
		
		return relatorio;
	}
}
