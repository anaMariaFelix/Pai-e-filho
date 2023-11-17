package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Listagem extends JanelaPadrao{
	
	public Listagem() {
		criarJLabel();
		criarJButton();
		setVisible(true);
		
	}
	
	public void criarJLabel() {
		JLabel listagem = new JLabel("Listagens");
		listagem.setForeground(new Color(255, 255, 255));
		listagem.setFont(new Font("Times New Roman", Font.BOLD, 45));
		listagem.setBounds(356, 32, 190, 53);
		getContentPane().add(listagem);
		
		JLabel img = new JLabel("");
		img.setIcon(new ImageIcon("Imagens/fotoLogin.png"));
		img.setBounds(77, 189, 394, 256);
		getContentPane().add(img);
		
	}
	
	public void criarJButton() {
		JButton pedido = new JButton("Pedido");
		pedido.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pedido.setBounds(531, 131, 265, 68);
		pedido.addActionListener(new OuvinteBotaoPedido(this));
		getContentPane().add(pedido);
		
		JButton clienteFuncionario = new JButton("Clientes");
		clienteFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		clienteFuncionario.setBounds(531, 427, 265, 68);
		clienteFuncionario.addActionListener(new OuvinteBotaoClientesFuncionario(this));
		getContentPane().add(clienteFuncionario);
		
		JButton servico = new JButton("Serviços");
		servico.setFont(new Font("Tahoma", Font.PLAIN, 25));
		servico.setBounds(531, 230, 265, 68);
		servico.addActionListener(new OuvinteBotaoServico(this));
		getContentPane().add(servico);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setToolTipText("Voltar para Tela de Menu");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnVoltar.setBounds(531, 523, 265, 68);
		btnVoltar.addActionListener(new OuvinteBotaoVoltar(this));
		getContentPane().add(btnVoltar);
		
		JButton botaoFuncionario = new JButton("Funcionário");
		botaoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		botaoFuncionario.setBounds(531, 330, 265, 68);
		botaoFuncionario.addActionListener(new OuvinteBotaoFuncionario(this));
		getContentPane().add(botaoFuncionario);
	}
	
	
	private class OuvinteBotaoPedido implements ActionListener{

		private Listagem janela;
		
		public OuvinteBotaoPedido(Listagem listagem) {
			this.janela = listagem;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			this.janela.dispose();
			new ListagemPedido();
		}
		
	}
	
	private class OuvinteBotaoFuncionario implements ActionListener{
		
		private Listagem janela;
		
		public OuvinteBotaoFuncionario(Listagem listagem) {
			this.janela = listagem;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			this.janela.dispose();
			new ListarFuncionario();
		}
		
	}
	
	
	private class OuvinteBotaoClientesFuncionario implements ActionListener{
		
		private Listagem janela;
		
		public OuvinteBotaoClientesFuncionario(Listagem listagem) {
			this.janela = listagem;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			this.janela.dispose();
			new ListagemCliente();
		}
		
	}
	
	
	private class OuvinteBotaoServico implements ActionListener{
		
		private Listagem janela;
		
		public OuvinteBotaoServico(Listagem listagem) {
			this.janela = listagem;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			this.janela.dispose();
			new Servicos();
		}
		
	}
	
	
	private class OuvinteBotaoVoltar implements ActionListener{
		
		private Listagem janela;
		
		public OuvinteBotaoVoltar(Listagem listagem) {
			this.janela = listagem;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			this.janela.dispose();
			new TelaMenu();
		}
		
	}
}
