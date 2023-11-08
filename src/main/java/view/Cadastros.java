package view;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cadastros extends JanelaPadrao {

	public Cadastros() {
		criarBotao();
		criarLabel();
		setVisible(true);
	}

	public void criarBotao() {
		JButton btnCliente = new JButton("Cliente");
		btnCliente.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnCliente.setBounds(531, 169, 265, 68);
		btnCliente.addActionListener(new OuvinteBotaoCliente(this));
		getContentPane().add(btnCliente);

		JButton btnFuncionario = new JButton("Funcionário");
		btnFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnFuncionario.setBounds(531, 272, 265, 68);
		btnFuncionario.addActionListener(new OuvinteBotaoFuncionario(this));
		getContentPane().add(btnFuncionario);

		JButton btnPedido = new JButton("Pedido");
		btnPedido.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnPedido.setBounds(531, 373, 265, 68);
		btnPedido.addActionListener(new OuvinteBotaoPedido(this));
		getContentPane().add(btnPedido);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnVoltar.setBounds(531, 474, 265, 68);
		btnVoltar.addActionListener(new OuvinteBotaoVoltar(this));
		getContentPane().add(btnVoltar);
	}

	public void criarLabel() {
		JLabel img = new JLabel("");
		img.setIcon(new ImageIcon("Imagens/fotoLogin.png"));
		img.setBounds(77, 189, 370, 246);
		getContentPane().add(img);

		JLabel cadastros = new JLabel("Cadastros");
		cadastros.setForeground(Color.WHITE);
		cadastros.setFont(new Font("Times New Roman", Font.BOLD, 45));
		cadastros.setBounds(355, 47, 196, 87);
		getContentPane().add(cadastros);

	}

	private class OuvinteBotaoCliente implements ActionListener {

		private Cadastros janela;

		public OuvinteBotaoCliente(Cadastros cadastros) {
			this.janela = cadastros;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			this.janela.dispose();
			new CadastroDoCliente();
		}

	}

	private class OuvinteBotaoFuncionario implements ActionListener {

		private Cadastros janela;

		public OuvinteBotaoFuncionario(Cadastros cadastros) {
			this.janela = cadastros;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			this.janela.dispose();
			new CadastroFuncionario();
		}

	}

	private class OuvinteBotaoPedido implements ActionListener {

		private Cadastros janela;

		public OuvinteBotaoPedido(Cadastros cadastros) {
			this.janela = cadastros;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			this.janela.dispose();
			new CadastrarPedido();
		}

	}

	private class OuvinteBotaoVoltar implements ActionListener {

		private Cadastros janela;

		public OuvinteBotaoVoltar(Cadastros cadastros) {
			this.janela = cadastros;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			this.janela.dispose();
			new TelaMenu();
		}
	}
}
