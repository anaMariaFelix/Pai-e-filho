package controller;

import java.util.ArrayList;

import dao.PedidoDAO;
import dto.PedidoDTO;
import execoesPersonalizadas.PedidoNaoEncontradoException;
import iterator.ConcretIterator;
import iterator.Iterator;

public class PedidoController {
	private volatile static PedidoController instance;
	
	private PedidoController() {
		
	}
	
	public static PedidoController getInstance() {
		if(instance == null) {
			synchronized (PedidoController.class) {
				if(instance == null) {
					instance = new PedidoController();
				}
			}
		}
		return instance;
	}
	
	public void salvarPedido(PedidoDTO pedidoDTO) {
		PedidoDAO.getInstance().salvarPedido(pedidoDTO);
	}
	
	public ArrayList<PedidoDTO> recuperarTodosPedidos() {
		return PedidoDAO.getInstance().recuperaTodosPedidos();
	}
	
	public PedidoDTO recuperarPedido(PedidoDTO pedidoDTO) throws PedidoNaoEncontradoException   {
		PedidoDTO pedido = PedidoDAO.getInstance().recuperarPedido(pedidoDTO.getEmailCliente());
		if(pedido != null) {
			return pedido;
		}
		throw new PedidoNaoEncontradoException();
				
	}
	
	
	public ArrayList<PedidoDTO> filtrarPorTipo(String tipo) {
		
		ArrayList<PedidoDTO> todosPedidos = recuperarTodosPedidos();
		ArrayList<PedidoDTO> filtrados = new ArrayList();
		
		Iterator<PedidoDTO> array = new ConcretIterator(todosPedidos);
		
		while(array.hasNext()) {
			PedidoDTO pedido = array.next();
			
			if (tipo.equals("finalizado")) {
				if (pedido.getFinalizado().equals("finalizado")) {
					filtrados.add(pedido);
				}	
			}else {
				if (pedido.getFinalizado().equals("andamento")) {
					filtrados.add(pedido);
				}
			}
		}
		
		
		return filtrados;

	}
	
	
	public ArrayList<String> pegaServicos(){
		return PedidoDAO.getInstance().pegaServicos();
	}
	
	
	public void removerPedido(PedidoDTO pedido) {
		PedidoDAO.getInstance().removerPedido(pedido);
	}
	
}
