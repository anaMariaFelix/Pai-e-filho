package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;

import dto.PedidoDTO;

public class DetalharPedido {

	private PedidoDTO pedidoDTO;
	
	public DetalharPedido(PedidoDTO pedidoDTO) {
		this.pedidoDTO = pedidoDTO;
		
		CadastrarPedido telaCadastroPedido = new CadastrarPedido("listagem");
		telaCadastroPedido.getCampoValor().setLocation(275, 529);
		
		telaCadastroPedido.getCadastrarPedido().setText("Detalhar Pedido");
		
		
		telaCadastroPedido.getButtonSalvar().removeActionListener(telaCadastroPedido.getOuvinteBotaoSalvar());
		telaCadastroPedido.getButtonSalvar().setVisible(false);
		
		telaCadastroPedido.getButtonVoltar().removeActionListener(telaCadastroPedido.getOuvienteVoltar());
		telaCadastroPedido.getButtonVoltar().setLocation(474, 587);
		
		
		telaCadastroPedido.getCampoNomeCliente().setText(pedidoDTO.getNomeCliente());
		telaCadastroPedido.getCampoNomeCliente().setEnabled(false);
		
		telaCadastroPedido.getCampoEmail().setText(pedidoDTO.getEmailCliente());
		telaCadastroPedido.getCampoEmail().setEnabled(false);
		
		telaCadastroPedido.getCampoTelefone().setText(pedidoDTO.getTelefone());
		telaCadastroPedido.getCampoTelefone().setEnabled(false);
		
		telaCadastroPedido.getDescricao().setText(pedidoDTO.getDescricao());
		telaCadastroPedido.getDescricao().setEnabled(false);
		
		
		telaCadastroPedido.getCampoValor().setText(pedidoDTO.getValor());
		telaCadastroPedido.getCampoValor().setEnabled(false);
		
		telaCadastroPedido.getComboBoxServico().getSelectedItem();
		telaCadastroPedido.getComboBoxServico().setEnabled(false);
		
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
