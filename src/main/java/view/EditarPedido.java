package view;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import controller.PedidoController;
import dto.PedidoDTO;
import strategy.CamposNaoPreenchidosStrategy;
import strategy.EmailInvalidoStrategy;
import strategy.Erros;
import util.ValidaEmail;



public class EditarPedido {
	
	private PedidoDTO pedidoDTO;
	private CadastrarPedido telaCadastrarPedido;
	
	public EditarPedido (PedidoDTO pedidoDTO) {
		this.pedidoDTO = pedidoDTO;
		
		telaCadastrarPedido = new CadastrarPedido();
		
		telaCadastrarPedido.getCadastrarPedido().setText("Editar Pedido");
		
		telaCadastrarPedido.getButtonSalvar().removeActionListener(telaCadastrarPedido.getOuvinteBotaoSalvar());
		telaCadastrarPedido.getButtonVoltar().removeActionListener(telaCadastrarPedido.getOuvienteVoltar());
	
		
		telaCadastrarPedido.getCampoNomeCliente().setText(pedidoDTO.getNomeCliente());	
		telaCadastrarPedido.getCampoTelefone().setText(pedidoDTO.getTelefone());
		telaCadastrarPedido.getCampoEmail().setText(pedidoDTO.getEmailCliente());
		telaCadastrarPedido.getCampoValor().setText(pedidoDTO.getValor());
		telaCadastrarPedido.getDescricao().setText(pedidoDTO.getDescricao());
		telaCadastrarPedido.getComboBoxServico().getSelectedItem();
		
		
		telaCadastrarPedido.getButtonVoltar().addActionListener(new OuvinteBotaoVoltar(telaCadastrarPedido));
		telaCadastrarPedido.getButtonSalvar().addActionListener(new OuvinteBotaoSalvar(telaCadastrarPedido,pedidoDTO));
	}
	
	private class OuvinteBotaoVoltar implements ActionListener{
		private CadastrarPedido janela;
		
		public OuvinteBotaoVoltar(CadastrarPedido janela) {
			this.janela = janela;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == janela.getButtonVoltar()) {
				this.janela.dispose();
				new Cadastros();
		
			}
		}
	}
	
	protected class OuvinteBotaoSalvar implements ActionListener {
		private CadastrarPedido janela;
		private PedidoDTO pedidoAntigo;
		
		public OuvinteBotaoSalvar(CadastrarPedido janela,PedidoDTO pedidoAntigo) {
			this.janela = janela;
			this.pedidoAntigo = pedidoAntigo;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String nome = janela.getCampoNomeCliente().getText();
			String telefone = janela.getCampoTelefone().getText().replace("(", "").replace(")", "").replace("-", "").trim();
			String email = janela.getCampoEmail().getText();
			String valor = janela.getCampoValor().getText();
			String descricao = janela.getDescricao().getText();
			String servico = (String) janela.getComboBoxServico().getSelectedItem();

			
			
			if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty() || valor.isEmpty()
					|| descricao.isEmpty() || servico.isEmpty()) {
				Erros.setStrategy(new CamposNaoPreenchidosStrategy());
				Erros.lancarErro();

			} else if (!ValidaEmail.emailValidatorP(email)) {
				Erros.setStrategy(new EmailInvalidoStrategy());
				Erros.lancarErro();
			}
					
			else {
				PedidoDTO pedido = new PedidoDTO(nome,email,telefone,servico,descricao,valor);
				PedidoController.getInstance().removerPedido(pedidoAntigo);
				
				
				PedidoController.getInstance().salvarPedido(pedido);
				JOptionPane.showMessageDialog(janela, "Pedido Editado com sucesso!");
				janela.dispose();
				new Cadastros();
	
			} 

		}

			
	}
	
}
