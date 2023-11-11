package dao;

import java.util.ArrayList;
import bancoDeDados.BancoDeDados;
import bancoDeDados.Persistencia;
import dto.PedidoDTO;
import execoesPersonalizadas.PedidoNaoEncontradoException;
import iterator.ConcretIterator;
import iterator.Iterator;
import util.Constantes;

public class PedidoDAO implements PedidoInterfaceDAO{

	private volatile static PedidoDAO instance;
	
	private PedidoDAO() {
		
	}
	
	public static PedidoDAO getInstance() {
		if (instance == null) {
			synchronized (PedidoDAO.class) {
				if (instance == null) {
					instance = new PedidoDAO();
				}
			}
		}
		return instance;
	}
	
	@Override
	public void salvarPedido(PedidoDTO pedidoDTO) {
		BancoDeDados.getInstance().getPedidos().add(pedidoDTO);
		Persistencia.getInstance().salvarBanco(BancoDeDados.getInstance(), Constantes.NOME_ARQUIVO_XML);
	}

	@Override
	public PedidoDTO recuperarPedido(String emailCliente) throws PedidoNaoEncontradoException{
		ArrayList<PedidoDTO> array = BancoDeDados.getInstance().getPedidos();
		
		Iterator<PedidoDTO> pedidos = new ConcretIterator(array);
		
		while(pedidos.hasNext()) {
			PedidoDTO pedido = pedidos.next();
			
			if(pedido.getEmailCliente().equals(emailCliente)) {
				return pedido;
			}
		}
			
		throw new PedidoNaoEncontradoException();
	}
	
	@Override
	public ArrayList<PedidoDTO> recuperaTodosPedidos(){
		return BancoDeDados.getInstance().getPedidos();
	}

	@Override
	public ArrayList<String> pegaServicos() {
		return BancoDeDados.getInstance().getTodosServicos();
	}
	
	@Override
	public void removerPedido(PedidoDTO pedido) {
		BancoDeDados.getInstance().getPedidos().remove(pedido);
		Persistencia.getInstance().salvarBanco(BancoDeDados.getInstance(),  Constantes.NOME_ARQUIVO_XML);
	}

	
	 

}
