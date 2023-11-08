package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.PedidoController;
import dto.PedidoDTO;
import strategy.CamposNaoPreenchidosStrategy;
import strategy.EmailInvalidoStrategy;
import util.ValidaEmail;


public class CadastrarPedido extends JanelaPadrao{
	private JTextField campoNomeCliente;
	private JComboBox comboBoxServico;
	private JTextArea descricao;
	
	private JButton ButtonVoltar;
	private JButton salvar;
	
	private JTextField campoEmail;
	private JTextField campoTelefone;
	private JTextField campoValor;
	
	
	private OuvinteBotaoSalvar ouvinteBotaoSalvar;
	
	public CadastrarPedido() {
		
		criarJTextField();
		criarJcomboBox();
		criarJbutton();
		criarJlabel();
		criarJTextArea();
		setVisible(true);
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
			MaskFormatter mascaraDeData = new MaskFormatter("(##) #####-####");
			campoTelefone = new JFormattedTextField(mascaraDeData);
			campoTelefone.setBounds(275, 275, 344, 36);

			getContentPane().add(campoTelefone);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		
		campoValor = new JTextField();
		campoValor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoValor.setColumns(10);
		campoValor.setBounds(275, 529, 344, 34);
		getContentPane().add(campoValor);
	}
	
	public void criarJcomboBox() {
		comboBoxServico = new JComboBox();
		comboBoxServico.setBounds(275, 354, 344, 34);
		getContentPane().add(comboBoxServico);
		
	}
	
	public void criarJbutton() {
		ButtonVoltar = new JButton("Voltar");
		ButtonVoltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ButtonVoltar.setBounds(275, 587, 145, 34);
		getContentPane().add(ButtonVoltar);
		
		ouvinteBotaoSalvar = new OuvinteBotaoSalvar(this);
		salvar = new JButton("Salvar");
		salvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		salvar.setBounds(474, 587, 145, 34);
		salvar.addActionListener(ouvinteBotaoSalvar);
		getContentPane().add(salvar);
		
		
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
		
		JLabel CadastrarPedido = new JLabel("Cadastrar Pedido");
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
		descricao.setBounds(275, 432, 344, 59);
		getContentPane().add(descricao);
		
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
			String telefone = janela.getCampoTelefone().getText().replace("(", "").replace(")", "").replace("-", "").trim();
			String email = janela.getCampoEmail().getText();
			String valor = janela.getCampoValor().getText();
			String descricao = janela.getDescricao().getText();

			
			
			if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty() || valor.isEmpty()
					|| descricao.isEmpty()) {
				CamposNaoPreenchidosStrategy camposNaoPreenchidosStrategy = new CamposNaoPreenchidosStrategy();
				camposNaoPreenchidosStrategy.mostrarErro();

			} else if (!ValidaEmail.emailValidatorP(email)) {
				EmailInvalidoStrategy emailInvalido = new EmailInvalidoStrategy();
				emailInvalido.mostrarErro();
			}
					
			else {
				pedido = new PedidoDTO(nome,email,telefone,descricao,valor);
				PedidoController.getInstance().salvarPedido(pedido);
				JOptionPane.showMessageDialog(janela, "Cliente cadastrado com sucesso!");
				janela.dispose();
				TelaMenu telaMenu = new TelaMenu();
			} 

		}

			
	}
	
	
	
}
