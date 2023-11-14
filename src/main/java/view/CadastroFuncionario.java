package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.FuncionarioController;
import dto.FuncionarioDTO;
import execoesPersonalizadas.FuncionarioExistenteException;
import strategy.CPFInvalido;
import strategy.CamposNaoPreenchidosStrategy;
import strategy.EmailInvalidoStrategy;
import strategy.Erros;
import strategy.FuncionarioExistenteStrategy;
import util.Constantes;
import util.ValidaEmail;
import util.ValidadorCPF;

public class CadastroFuncionario extends JanelaPadrao {

	private JTextField campoNome;
	private JTextField campoTelefone;
	private JTextField campoEmail;
	private JTextField campoCPF;

	private JButton buttonVoltar;
	private JButton buttonSalvar;

	private JLabel CadastrarFuncionário;

	private OuvinteBotaoSalvar ouvinteSalvar;
	private OuvinteBotaoVoltar ouvinteVoltar;

	private String janelaAntiga;

	public CadastroFuncionario(String janelaAntiga) {
		this.janelaAntiga = janelaAntiga;

		criarJbutton();
		criarJTextField();
		criarJLabel();
		setVisible(true);
	}

	public void criarJbutton() {
		ouvinteVoltar = new OuvinteBotaoVoltar(this, janelaAntiga);

		buttonVoltar = new JButton("Voltar");
		buttonVoltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonVoltar.setBounds(282, 501, 166, 41);
		buttonVoltar.addActionListener(ouvinteVoltar);
		getContentPane().add(buttonVoltar);

		ouvinteSalvar = new OuvinteBotaoSalvar(this);

		buttonSalvar = new JButton("Salvar");
		buttonSalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonSalvar.setBounds(460, 501, 166, 41);
		buttonSalvar.addActionListener(ouvinteSalvar);
		getContentPane().add(buttonSalvar);
	}

	public void criarJTextField() {
		campoNome = new JTextField();
		campoNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoNome.setColumns(10);
		campoNome.setBounds(282, 163, 344, 47);
		getContentPane().add(campoNome);

		try {
			MaskFormatter mascaraDeData = new MaskFormatter("(##) #####-####");
			campoTelefone = new JFormattedTextField(mascaraDeData);
			campoTelefone.setFont(new Font("Tahoma", Font.PLAIN, 18));
			campoTelefone.setBounds(282, 251, 344, 47);

			getContentPane().add(campoTelefone);
		} catch (ParseException e) {

			e.printStackTrace();
		}

		campoEmail = new JTextField();
		campoEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoEmail.setColumns(10);
		campoEmail.setBounds(282, 336, 344, 47);
		getContentPane().add(campoEmail);

		MaskFormatter mascaraDeCPF;
		try {
			mascaraDeCPF = new MaskFormatter("###.###.###-##");
			campoCPF = new JFormattedTextField(mascaraDeCPF);
			campoCPF.setFont(new Font("Tahoma", Font.PLAIN, 18));
			((JFormattedTextField) campoCPF).setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
			campoCPF.setBounds(282, 428, 344, 47);
			getContentPane().add(campoCPF);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public void criarJLabel() {
		CadastrarFuncionário = new JLabel("Cadastrar Funcionário");
		CadastrarFuncionário.setForeground(Color.WHITE);
		CadastrarFuncionário.setFont(new Font("Times New Roman", Font.BOLD, 45));
		CadastrarFuncionário.setBounds(236, 39, 443, 47);
		getContentPane().add(CadastrarFuncionário);

		JLabel Nome = new JLabel("Nome");
		Nome.setForeground(Color.WHITE);
		Nome.setFont(new Font("Tahoma", Font.BOLD, 20));
		Nome.setBounds(282, 131, 92, 22);
		getContentPane().add(Nome);

		JLabel Telefone = new JLabel("Telefone");
		Telefone.setForeground(Color.WHITE);
		Telefone.setFont(new Font("Tahoma", Font.BOLD, 20));
		Telefone.setBounds(282, 219, 92, 22);
		getContentPane().add(Telefone);

		JLabel email = new JLabel("E-mail");
		email.setForeground(Color.WHITE);
		email.setFont(new Font("Tahoma", Font.BOLD, 20));
		email.setBounds(282, 304, 92, 22);
		getContentPane().add(email);

		JLabel CPF = new JLabel("CPF");
		CPF.setForeground(Color.WHITE);
		CPF.setFont(new Font("Tahoma", Font.BOLD, 20));
		CPF.setBounds(282, 393, 75, 25);
		getContentPane().add(CPF);

		JLabel img = new JLabel("");
		img.setIcon(new ImageIcon("Imagens/marca.png"));
		img.setBounds(711, 503, 166, 135);
		getContentPane().add(img);
	}

	public OuvinteBotaoSalvar getOuvinteSalvar() {
		return ouvinteSalvar;
	}

	public OuvinteBotaoVoltar getOuvinteVoltar() {
		return ouvinteVoltar;
	}

	public JTextField getCampoNome() {
		return campoNome;
	}

	public JTextField getCampoTelefone() {
		return campoTelefone;
	}

	public JTextField getCampoEmail() {
		return campoEmail;
	}

	public JTextField getCampoCPF() {
		return campoCPF;
	}

	public JButton getButtonVoltar() {
		return buttonVoltar;
	}

	public JButton getButtonSalvar() {
		return buttonSalvar;
	}

	public JLabel getCadastrarFuncionário() {
		return CadastrarFuncionário;
	}

	private class OuvinteBotaoSalvar implements ActionListener {

		private CadastroFuncionario janela;

		public OuvinteBotaoSalvar(CadastroFuncionario cadastroFuncionario) {
			this.janela = cadastroFuncionario;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			String nome = campoNome.getText();
			String telefone = campoTelefone.getText().replace("(", "").replace(")", "").replace("-", "").trim();
			String email = campoEmail.getText();
			String cpf = campoCPF.getText().replace("-", "").replace(".", "").trim();

			if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty() || cpf.isEmpty()) {
				Erros.setStrategy(new CamposNaoPreenchidosStrategy());
				Erros.lancarErro();

			} else if (!ValidaEmail.emailValidatorP(email)) {
				Erros.setStrategy(new EmailInvalidoStrategy());
				Erros.lancarErro();

			} else if (!ValidadorCPF.isCPF(cpf)) {
				Erros.setStrategy(new CPFInvalido());
				Erros.lancarErro();

			} else {

				FuncionarioDTO funcionario = new FuncionarioDTO(nome, telefone, email, cpf);

				try {
					FuncionarioController.getInstance().salvarFuncionario(funcionario);
					JOptionPane.showMessageDialog(janela, "Funcionário cadastrado com sucesso!");

					janela.dispose();
					
					if (janelaAntiga.equals(Constantes.CADASTROS)) {
						new Cadastros();
					} else {
						new ListarFuncionario();
					}

				} catch (FuncionarioExistenteException e1) {
					Erros.setStrategy(new FuncionarioExistenteStrategy());
					Erros.lancarErro();
				}

			}

		}

	}

	private class OuvinteBotaoVoltar implements ActionListener {

		private CadastroFuncionario janela;
		private String janelaAntiga;

		public OuvinteBotaoVoltar(CadastroFuncionario cadastro, String janelaAntiga) {
			this.janela = cadastro;
			this.janelaAntiga = janelaAntiga;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			this.janela.dispose();

			if (janelaAntiga.equals(Constantes.CADASTROS)) {
				new Cadastros();
			} else {
				new ListarFuncionario();
			}

		}

	}
}
