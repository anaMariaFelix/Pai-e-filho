package view;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.ClienteController;
import dto.ClienteDTO;
import execoesPersonalizadas.EmailJaCadastradoException;
import strategy.CPFInvalido;
import strategy.CamposNaoPreenchidosStrategy;
import strategy.EmailInvalidoStrategy;
import strategy.EmailJaExistenteStrategy;
import strategy.Erros;
import util.ValidaEmail;
import util.ValidadorCPF;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;

public class CadastroDoCliente extends JanelaPadrao{
	private JTextField campoNome;
	private JTextField campoTelefone;
	private JTextField campoEmail;
	private JTextField campoCPF;

	private JButton botaoVoltar;
	private JButton botaoSalvar;

	private JRadioButton radioButonSim;
	private JRadioButton radioButonNao;
	
	private JLabel cadastrarCliente;
	
	private OuvinteBotaoVoltar ouvinteVoltar;
	private OuvinteBotaoSalvar ouvinteSalvar;


	public CadastroDoCliente() {
		criarBotao();
		criarLabel();
		criarTextField();
		JRadioButton();
		setVisible(true);
	}


	public JLabel getCadastrarCliente() {
		return cadastrarCliente;
	}

	public void setCadastrarCliente(JLabel cadastrarCliente) {
		this.cadastrarCliente = cadastrarCliente;
	}

	public JButton getBotaoVoltar() {
		return botaoVoltar;
	}


	public void setBotaoVoltar(JButton botaoVoltar) {
		this.botaoVoltar = botaoVoltar;
	}


	public JButton getBotaoSalvar() {
		return botaoSalvar;
	}


	public void setBotaoSalvar(JButton botaoSalvar) {
		this.botaoSalvar = botaoSalvar;
	}


	public void setRadioButonSim(JRadioButton radioButonSim) {
		this.radioButonSim = radioButonSim;
	}


	public void setRadioButonNao(JRadioButton radioButonNao) {
		this.radioButonNao = radioButonNao;
	}


	public JTextField getCampoNome() {
		return campoNome;
	}

	public void setCampoNome(JTextField campoNome) {
		this.campoNome = campoNome;
	}

	public JTextField getCampoTelefone() {
		return campoTelefone;
	}

	public void setCampoTelefone(JTextField campoTelefone) {
		this.campoTelefone = campoTelefone;
	}

	public JTextField getCampoEmail() {
		return campoEmail;
	}

	public void setCampoEmail(JTextField campoEmail) {
		this.campoEmail = campoEmail;
	}

	public JTextField getCampoCPF() {
		return campoCPF;
	}

	public void setCampoCPF(JTextField campoCPF) {
		this.campoCPF = campoCPF;
	}

	public JRadioButton getRadioButonSim() {
		return radioButonSim;
	}

	public JRadioButton getRadioButonNao() {
		return radioButonNao;
	}

	public OuvinteBotaoVoltar getOuvinteVoltar() {
		return ouvinteVoltar;
	}

	public void setOuvinteVoltar(OuvinteBotaoVoltar ouvinteVoltar) {
		this.ouvinteVoltar = ouvinteVoltar;
	}

	public OuvinteBotaoSalvar getOuvinteSalvar() {
		return ouvinteSalvar;
	}

	public void setOuvinteSalvar(OuvinteBotaoSalvar ouvinteSalvar) {
		this.ouvinteSalvar = ouvinteSalvar;
	}

	public void criarLabel() {
		JLabel telefone = new JLabel("Telefone");
		telefone.setForeground(Color.WHITE);
		telefone.setFont(new Font("Tahoma", Font.BOLD, 20));
		telefone.setBounds(276, 207, 92, 22);
		getContentPane().add(telefone);

		JLabel email = new JLabel("E-mail");
		email.setForeground(Color.WHITE);
		email.setFont(new Font("Tahoma", Font.BOLD, 20));
		email.setBounds(276, 296, 92, 22);
		getContentPane().add(email);

		JLabel CPF = new JLabel("CPF");
		CPF.setForeground(Color.WHITE);
		CPF.setFont(new Font("Tahoma", Font.BOLD, 20));
		CPF.setBounds(276, 385, 92, 22);
		getContentPane().add(CPF);

		cadastrarCliente = new JLabel("Cadastrar Cliente");
		cadastrarCliente.setForeground(Color.WHITE);
		cadastrarCliente.setFont(new Font("Times New Roman", Font.BOLD, 45));
		cadastrarCliente.setBounds(273, 36, 359, 47);
		getContentPane().add(cadastrarCliente);

		JLabel nome = new JLabel("Nome");
		nome.setForeground(new Color(255, 255, 255));
		nome.setFont(new Font("Tahoma", Font.BOLD, 20));
		nome.setBounds(276, 118, 92, 22);
		getContentPane().add(nome);

		JLabel imagen = new JLabel("");
		imagen.setIcon(new ImageIcon("Imagens/marca.png"));
		imagen.setBounds(699, 501, 176, 104);
		getContentPane().add(imagen);

		JLabel notificacaoes = new JLabel("Deseja Receber  Notificações:");
		notificacaoes.setForeground(Color.WHITE);
		notificacaoes.setFont(new Font("Tahoma", Font.BOLD, 20));
		notificacaoes.setBounds(276, 475, 309, 22);
		getContentPane().add(notificacaoes);
	}

	public void criarTextField() {
		OuvinteDoNome ouvinte = new OuvinteDoNome();
		campoNome = new JTextField();
		campoNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoNome.setBounds(276, 150, 344, 47);
		campoNome.addKeyListener(ouvinte);
		getContentPane().add(campoNome);
		campoNome.setColumns(10);


		try {
			MaskFormatter mascaraDeData = new MaskFormatter("(##)#####-####");
			campoTelefone = new JFormattedTextField(mascaraDeData);
			campoTelefone.setColumns(10);
			campoTelefone.setBounds(276, 239, 344, 47);
			getContentPane().add(campoTelefone);

		} catch (ParseException e) {

			e.printStackTrace();
		}

		campoEmail = new JTextField();
		campoEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoEmail.setColumns(10);
		campoEmail.setBounds(276, 328, 344, 47);
		getContentPane().add(campoEmail);


		try {

			MaskFormatter mascaraDeCPF = new MaskFormatter("###.###.###-##");
			campoCPF = new JFormattedTextField(mascaraDeCPF);
			campoCPF.setColumns(10);
			campoCPF.setBounds(276, 417, 344, 47);
			getContentPane().add(campoCPF);

		} catch (ParseException e1) {
			e1.printStackTrace();
		}

	}

	public void JRadioButton() {

		radioButonSim = new JRadioButton("Sim");
		radioButonSim.setSelected(true);
		radioButonSim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		radioButonSim.setForeground(new Color(255, 255, 255));
		radioButonSim.setBackground(new Color(31, 38, 107));
		radioButonSim.setBounds(276, 512, 59, 23);
		getContentPane().add(radioButonSim);

		radioButonNao = new JRadioButton("Não");
		radioButonNao.setForeground(new Color(255, 255, 255));
		radioButonNao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		radioButonNao.setBackground(new Color(31, 38, 107));
		radioButonNao.setBounds(353, 512, 76, 23);
		getContentPane().add(radioButonNao);

		ButtonGroup bg = new ButtonGroup();
		bg.add(radioButonSim);
		bg.add(radioButonNao); 
		
	}

	public void criarBotao() {
		ouvinteVoltar = new OuvinteBotaoVoltar();
		botaoVoltar = new JButton("Voltar");
		botaoVoltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botaoVoltar.setBounds(276, 550, 166, 41);
		botaoVoltar.addActionListener(ouvinteVoltar);
		getContentPane().add(botaoVoltar);

		
		ouvinteSalvar = new OuvinteBotaoSalvar(this);
		botaoSalvar = new JButton("Salvar");
		botaoSalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botaoSalvar.setBounds(452, 550, 166, 41);
		botaoSalvar.addActionListener(ouvinteSalvar);
		getContentPane().add(botaoSalvar);
	}

	private class OuvinteDoNome implements KeyListener {

		public void keyPressed(KeyEvent e) {
			char c = e.getKeyChar();
			if (!Character.isLetter(c) && c != ' ') {

			}
		}

		public void keyReleased(KeyEvent e) {

		}

		public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar();

			if (!Character.isLetter(c) && c != ' ') {
				e.consume();
			}
		}
	}

	private class OuvinteBotaoVoltar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			dispose();
			new TelaMenu();

		}

	}

	public String removerMacaraCampoCPF(JTextField cpf) {
		return cpf.getText().replace(".", "").replace("-", "").trim();
	}

	protected class OuvinteBotaoSalvar implements ActionListener {
		private CadastroDoCliente janela;

		public OuvinteBotaoSalvar(CadastroDoCliente janela) {
			this.janela = janela;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			String nome = janela.getCampoNome().getText();
			String telefone = janela.getCampoTelefone().getText().replace("(", "").replace(")", "").replace("-", "").trim();
			String email = janela.getCampoEmail().getText();
			String cpf = removerMacaraCampoCPF(janela.getCampoCPF());
			boolean notificacao = false;

			if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty() || cpf.isEmpty()) {
				Erros.setStrategy(new CamposNaoPreenchidosStrategy());
				Erros.lancarErro();

			} else if (!ValidaEmail.emailValidatorP(email)) {
				Erros.setStrategy(new EmailInvalidoStrategy());
				Erros.lancarErro();

			} else if (!ValidadorCPF.isCPF(cpf)) {
				Erros.setStrategy(new CPFInvalido());
				Erros.lancarErro();

			}else {
				
				if (radioButonSim.isSelected()) {
					notificacao = true;

				}
				
				ClienteDTO cliente = new ClienteDTO(nome,telefone,email,cpf,notificacao);

				try {
					ClienteController.getInstance().salvarCliente(cliente);
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso.");
					dispose();
					new DetalharCliente(cliente);

				} catch (EmailJaCadastradoException e1) {
					Erros.setStrategy(new EmailJaExistenteStrategy());
					Erros.lancarErro();
					e1.getMessage();
				}


			}

		}

	}
}
