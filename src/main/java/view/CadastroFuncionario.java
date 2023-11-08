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
import util.ValidaEmail;
import util.ValidadorCPF;

public class CadastroFuncionario extends JanelaPadrao {

	private JTextField campoNome;
	private JTextField campoTelefone;
	private JTextField campoEmail;
	private JTextField campoCPF;

	public CadastroFuncionario() {

		criarJbutton();
		criarJTextField();
		criarJLabel();
		setVisible(true);
	}

	public void criarJbutton() {
		JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonVoltar.setBounds(282, 501, 166, 41);
		buttonVoltar.addActionListener(new OuvinteBotaoVoltar(this));
		getContentPane().add(buttonVoltar);

		JButton buttonSalvar = new JButton("Salvar");
		buttonSalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonSalvar.setBounds(460, 501, 166, 41);
		buttonSalvar.addActionListener(new OuvinteBotaoSalvar(this));
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
		JLabel CadastrarFuncionário = new JLabel("Cadastrar Funcionário");
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
				
			}else if (!ValidaEmail.emailValidatorP(email)) {
				Erros.setStrategy(new EmailInvalidoStrategy());
				Erros.lancarErro();
				
			}else if (!ValidadorCPF.isCPF(cpf)) {
				Erros.setStrategy(new CPFInvalido());
				Erros.lancarErro();
				
			}else {
				
				FuncionarioDTO funcionario = new FuncionarioDTO(nome, telefone, email, cpf);
				
				try {
					FuncionarioController.getInstance().salvarFuncionario(funcionario);
					JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
					//JOptions de sucesso tambèm vão ser entregues com o strategy??
					
					janela.dispose();
					new TelaMenu(); //Ao cadastrar é melhor ir pra tela de cadastros ou de menu??
					
				} catch (FuncionarioExistenteException e1) {
					Erros.setStrategy(new FuncionarioExistenteStrategy());
					Erros.lancarErro();
				}
				
				
				
			}
			

		}

	}
	

	private class OuvinteBotaoVoltar implements ActionListener {

		private CadastroFuncionario janela;

		public OuvinteBotaoVoltar(CadastroFuncionario cadastro) {
			this.janela = cadastro;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			this.janela.dispose();
			new Cadastros();
		}

	}
}
