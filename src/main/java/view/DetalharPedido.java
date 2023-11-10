package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dto.PedidoDTO;

public class DetalharPedido {

	private PedidoDTO pedidoDTO;
	
	public DetalharPedido(PedidoDTO pedidoDTO) {
		this.pedidoDTO = pedidoDTO;
		
		CadastrarPedido telaCadastroPedido = new CadastrarPedido();
		telaCadastroPedido.getCampoValor().setLocation(275, 529);
		
		telaCadastroPedido.getCadastrarPedido().setText("Detalhar Pedido");
		
		
		telaCadastroPedido.getButtonSalvar().removeActionListener(telaCadastroPedido.getOuvinteBotaoSalvar());
		telaCadastroPedido.getButtonSalvar().setVisible(false);
		
		telaCadastroPedido.getButtonVoltar().removeActionListener(telaCadastroPedido.getOuvienteVoltar());
		telaCadastroPedido.getButtonVoltar().setLocation(474, 587);
		
		
		telaCadastroPedido.getCampoNomeCliente().setText(pedidoDTO.getNomeCliente());
		telaCadastroPedido.getCampoNomeCliente().disable();
		
		telaCadastroPedido.getCampoEmail().setText(pedidoDTO.getEmailCliente());
		telaCadastroPedido.getCampoEmail().disable();
		
		telaCadastroPedido.getCampoTelefone().setText(pedidoDTO.getTelefone());
		telaCadastroPedido.getCampoTelefone().disable();
		
		telaCadastroPedido.getDescricao().setText(pedidoDTO.getDescricao());
		telaCadastroPedido.getDescricao().disable();
		
		
		telaCadastroPedido.getCampoValor().setText(pedidoDTO.getValor());
		telaCadastroPedido.getCampoValor().disable();
		
		telaCadastroPedido.getComboBoxServico().getSelectedItem();
		telaCadastroPedido.getComboBoxServico().disable();
		
		telaCadastroPedido.getButtonVoltar().addActionListener(new OuvinteBotaoVoltar(telaCadastroPedido));
		
		
	}
	
	private class OuvinteBotaoVoltar implements ActionListener {

		private CadastrarPedido janela;

		public OuvinteBotaoVoltar(CadastrarPedido cadastro) {
			this.janela = cadastro;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			this.janela.dispose();
			new ListagemPedido();
		}

	}
	
}
