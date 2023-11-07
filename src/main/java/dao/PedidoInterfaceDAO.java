package dao;

import java.util.ArrayList;

import dto.PedidoDTO;
import execoesPersonalizadas.PedidoNaoEncontradoException;

public interface PedidoInterfaceDAO {

	void salvarPedido(PedidoDTO dto);
	PedidoDTO recuperarPedido(String emailCliente) throws PedidoNaoEncontradoException;
	ArrayList<PedidoDTO> recuperaTodosPedidos();
}
