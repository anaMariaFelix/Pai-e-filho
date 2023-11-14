package relatorio;

import util.Constantes;

public class RelatorioFactory {

	public static Relatorio criaRelatorio(String tipo) {
		Relatorio relatorio = null;
		
		if(tipo.equalsIgnoreCase(Constantes.CLIENTE)) {
			relatorio = new RelatorioCliente();
			
		}else if(tipo.equals(Constantes.PEDIDO)) {
			relatorio = new RelatorioPedido();
		}
		
		return relatorio;
	}
}
