package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.ModuleLayer.Controller;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.ClienteController;
import controller.PedidoController;
import dto.PedidoDTO;
import model.Pedido;
import strategy.CamposNaoPreenchidosStrategy;
import strategy.ClienteNaoExistenteStrategy;
import strategy.EmailInvalidoStrategy;
import strategy.Erros;
import util.Constantes;
import util.ValidaEmail;

public class CadastrarPedido extends JanelaPadrao {

	private JTextField campoNomeCliente;
	private JComboBox comboBoxServico;
	private JTextArea descricao;

	private JButton buttonVoltar;
	private JButton buttonSalvar;

	private JTextField campoEmail;
	private JTextField campoTelefone;
	private JTextField campoValor;

	private JLabel CadastrarPedido;

	private OuvinteBotaoVoltar ouvienteVoltar;
	private OuvinteBotaoSalvar ouvinteBotaoSalvar;

	private String telaAnterior;

	public CadastrarPedido(String telaAnterior) {
		this.telaAnterior = telaAnterior;

		criarJTextField();
		criarJcomboBox();
		criarJbutton();
		criarJlabel();
		criarJTextArea();
		setVisible(true);
	}

	public OuvinteBotaoVoltar getOuvienteVoltar() {
		return ouvienteVoltar;
	}

	public void setOuvienteVoltar(OuvinteBotaoVoltar ouvienteVoltar) {
		this.ouvienteVoltar = ouvienteVoltar;
	}

	public OuvinteBotaoSalvar getOuvinteBotaoSalvar() {
		return ouvinteBotaoSalvar;
	}

	public void setOuvinteBotaoSalvar(OuvinteBotaoSalvar ouvinteBotaoSalvar) {
		this.ouvinteBotaoSalvar = ouvinteBotaoSalvar;
	}

	public JLabel getCadastrarPedido() {
		return CadastrarPedido;
	}

	public void setCadastrarPedido(JLabel cadastrarPedido) {
		CadastrarPedido = cadastrarPedido;
	}

	public JButton getButtonVoltar() {
		return buttonVoltar;
	}

	public void setButtonVoltar(JButton buttonVoltar) {
		this.buttonVoltar = buttonVoltar;
	}

	public JButton getButtonSalvar() {
		return buttonSalvar;
	}

	public void setButtonSalvar(JButton buttonSalvar) {
		this.buttonSalvar = buttonSalvar;
	}

	public JComboBox getComboBoxServico() {
		return comboBoxServico;
	}

	public void setComboBoxServico(JComboBox comboBoxServico) {
		this.comboBoxServico = comboBoxServico;
	}

	public JTextField getCampoNomeCliente() {
		return campoNomeCliente;
	}

	public void setCampoNomeCliente(JTextField campoNomeCliente) {
		this.campoNomeCliente = campoNomeCliente;
	}

	public JTextField getCampoEmail() {
		return campoEmail;
	}

	public void setCampoEmail(JTextField campoEmail) {
		this.campoEmail = campoEmail;
	}

	public JTextField getCampoTelefone() {
		return campoTelefone;
	}

	public void setCampoTelefone(JTextField campoTelefone) {
		this.campoTelefone = campoTelefone;
	}

	public JTextField getCampoValor() {
		return campoValor;
	}

	public void setCampoValor(JTextField campoValor) {
		this.campoValor = campoValor;
	}

	public JTextArea getDescricao() {
		return descricao;
	}

	public void setDescricao(JTextArea descricao) {
		this.descricao = descricao;
	}

	public void criarJTextField() {
		campoNomeCliente = new JTextField();
		campoNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoNomeCliente.setColumns(10);
		campoNomeCliente.setBounds(275, 120, 344, 34);
		getContentPane().add(campoNomeCliente);

		campoEmail = new JTextField();
		campoEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoEmail.setColumns(10);
		campoEmail.setBounds(275, 198, 344, 34);
		getContentPane().add(campoEmail);

		try {
			MaskFormatter mascaraTelefone = new MaskFormatter("(##) #####-####");
			campoTelefone = new JFormattedTextField(mascaraTelefone);
			campoTelefone.setBounds(275, 275, 344, 36);

			getContentPane().add(campoTelefone);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		
		OuvinteCampoTamanhoEValor ouviente = new OuvinteCampoTamanhoEValor();
		campoValor = new JTextField();
		campoValor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoValor.setColumns(10);
		campoValor.setBounds(275, 529, 344, 34);
		campoValor.addKeyListener(ouviente);
		getContentPane().add(campoValor);
		
	}
	

	public void criarJcomboBox() {

		Object[] servico = PedidoController.getInstance().pegaServicos().toArray();
		comboBoxServico = new JComboBox(servico);
		comboBoxServico.setBounds(275, 354, 344, 34);
		getContentPane().add(comboBoxServico);
	}

	public void criarJbutton() {
		ouvienteVoltar = new OuvinteBotaoVoltar();
		buttonVoltar = new JButton("Voltar");
		buttonVoltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonVoltar.setBounds(275, 587, 145, 34);
		buttonVoltar.addActionListener(ouvienteVoltar);
		getContentPane().add(buttonVoltar);

		ouvinteBotaoSalvar = new OuvinteBotaoSalvar(this);
		buttonSalvar = new JButton("Salvar");
		buttonSalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonSalvar.setBounds(474, 587, 145, 34);
		buttonSalvar.addActionListener(ouvinteBotaoSalvar);
		getContentPane().add(buttonSalvar);
	}

	public void criarJlabel() {
		JLabel NomeCliente = new JLabel("Nome do Cliente");
		NomeCliente.setForeground(Color.WHITE);
		NomeCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
		NomeCliente.setBounds(275, 88, 166, 22);
		getContentPane().add(NomeCliente);

		JLabel DescriçãoServiço = new JLabel("Descrição do Serviço");
		DescriçãoServiço.setForeground(Color.WHITE);
		DescriçãoServiço.setFont(new Font("Tahoma", Font.BOLD, 20));
		DescriçãoServiço.setBounds(275, 399, 228, 22);
		getContentPane().add(DescriçãoServiço);

		JLabel CPF = new JLabel("Email Cliente");
		CPF.setForeground(Color.WHITE);
		CPF.setFont(new Font("Tahoma", Font.BOLD, 20));
		CPF.setBounds(275, 165, 133, 22);
		getContentPane().add(CPF);

		JLabel Telefone = new JLabel("Telefone");
		Telefone.setForeground(Color.WHITE);
		Telefone.setFont(new Font("Tahoma", Font.BOLD, 20));
		Telefone.setBounds(275, 243, 92, 22);
		getContentPane().add(Telefone);

		JLabel SelecionarServiço = new JLabel("Selecionar  Serviço");
		SelecionarServiço.setForeground(Color.WHITE);
		SelecionarServiço.setFont(new Font("Tahoma", Font.BOLD, 20));
		SelecionarServiço.setBounds(275, 321, 228, 22);
		getContentPane().add(SelecionarServiço);

		JLabel img = new JLabel("");
		img.setIcon(new ImageIcon("Imagens/marca.png"));
		img.setBounds(718, 492, 173, 146);
		getContentPane().add(img);

		CadastrarPedido = new JLabel("Cadastrar Pedido");
		CadastrarPedido.setForeground(Color.WHITE);
		CadastrarPedido.setFont(new Font("Times New Roman", Font.BOLD, 45));
		CadastrarPedido.setBounds(275, 22, 344, 47);
		getContentPane().add(CadastrarPedido);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setForeground(Color.WHITE);
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblValor.setBounds(275, 500, 228, 22);
		getContentPane().add(lblValor);

	}

	public void criarJTextArea() {
		descricao = new JTextArea();
		descricao.setFont(new Font("Monospaced", Font.PLAIN, 18));
		descricao.setLineWrap(true);

		JScrollPane scroll = new JScrollPane(descricao);
		scroll.setBounds(275, 432, 344, 59);
		this.getContentPane().add(scroll);

	}
	
	public class OuvinteCampoTamanhoEValor implements KeyListener {

		public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar();
			if (Character.isLetter(e.getKeyChar()) && c != ' ') {
				e.consume();
			}
		}

		public void keyPressed(KeyEvent e) {
			char c = e.getKeyChar();
			if (Character.isLetter(e.getKeyChar()) && c != ' ')
				;

		}

		public void keyReleased(KeyEvent e) {

		}
	}

	private class OuvinteBotaoVoltar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == buttonVoltar) {
				dispose();

				if (telaAnterior.equals("cadastros")) {
					new Cadastros();
				} else {
					new ListagemPedido();
				}

			}
		}
	}

	protected class OuvinteBotaoSalvar implements ActionListener {
		private CadastrarPedido janela;
		private PedidoDTO pedido;

		public OuvinteBotaoSalvar(CadastrarPedido janela) {
			this.janela = janela;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			String nome = janela.getCampoNomeCliente().getText();
			String telefone = janela.getCampoTelefone().getText().replace("(", "").replace(")", "").replace("-", "")
					.trim();
			String email = janela.getCampoEmail().getText();
			String valor = janela.getCampoValor().getText();
			String descricao = janela.getDescricao().getText();
			String servico = (String) janela.getComboBoxServico().getSelectedItem();

			if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty() || valor.isEmpty() || descricao.isEmpty()
					|| servico.isEmpty()) {
				Erros.setStrategy(new CamposNaoPreenchidosStrategy());
				Erros.lancarErro();

			} else if (!ValidaEmail.emailValidatorP(email)) {
				Erros.setStrategy(new EmailInvalidoStrategy());
				Erros.lancarErro();

			} else if (!ClienteController.getInstance().existeCliente(email)) {
				Erros.setStrategy(new ClienteNaoExistenteStrategy());
				Erros.lancarErro();
				
			} else {
				pedido = new PedidoDTO(nome, email, telefone, servico, descricao, valor, Constantes.ANDAMENTO);
				PedidoController.getInstance().salvarPedido(pedido);
				JOptionPane.showMessageDialog(janela, "Pedido cadastrado com sucesso!");
				janela.dispose();

				if (telaAnterior.equals("cadastros")) {
					new Cadastros();
				} else {
					new ListagemPedido();
				}
			}

		}

	}

}
