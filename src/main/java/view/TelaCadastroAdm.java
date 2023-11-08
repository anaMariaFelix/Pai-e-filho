package view;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;

import controller.AdministradorController;
import dto.AdministradorDTO;
import model.Administrador;
import strategy.CamposNaoPreenchidosStrategy;
import strategy.EmailInvalidoStrategy;
import strategy.Erros;
import strategy.SenhaInvalidaMenorQue8Strategy;
import strategy.SenhasDiferentesStrategy;
import strategy.Strategy;
import util.ValidaEmail;

import javax.swing.JPasswordField;
import javax.swing.JButton;

public class TelaCadastroAdm extends JanelaPadrao{
	private JTextField campoUsuario;
	private JTextField campoEmailUsuario;
	private JPasswordField campoSenha;
	private JButton botaoEntrar;
	private JPasswordField campoConfirmaSenha;
	
	public TelaCadastroAdm() {
		criarBotao();
		criarJlabel();
		criarTextField();
		criarPasswordField();
		setVisible(true);
	}
	
	public JTextField getCampoUsuario() {
		return campoUsuario;
	}
	
	public void setCampoUsuario(JTextField campoUsuario) {
		this.campoUsuario = campoUsuario;
	}

	public JTextField getCampoEmailUsuario() {
		return campoEmailUsuario;
	}

	public void setCampoEmailUsuario(JTextField campoEmailUsuario) {
		this.campoEmailUsuario = campoEmailUsuario;
	}

	public JPasswordField getCampoSenha() {
		return campoSenha;
	}

	public void setCampoSenha(JPasswordField campoSenha) {
		this.campoSenha = campoSenha;
	}

	public JButton getBotaoEntrar() {
		return botaoEntrar;
	}

	public void setBotaoEntrar(JButton botaoEntrar) {
		this.botaoEntrar = botaoEntrar;
	}
	
	public JPasswordField getCampoConfirmaSenha() {
		return campoConfirmaSenha;
	}

	public void setCampoConfirmaSenha(JPasswordField campoConfirmaSenha) {
		this.campoConfirmaSenha = campoConfirmaSenha;
	}

	public void criarTextField() {
		campoEmailUsuario = new JTextField();
		campoEmailUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoEmailUsuario.setColumns(10);
		campoEmailUsuario.setBounds(548, 279, 232, 42);
		getContentPane().add(campoEmailUsuario);
		
		campoUsuario = new JTextField();
		campoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoUsuario.setColumns(10);
		campoUsuario.setBounds(548, 191, 232, 42);
		getContentPane().add(campoUsuario);
	}
	
	
	public void criarPasswordField() {
		campoSenha = new JPasswordField();
		campoSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoSenha.setBounds(548, 366, 232, 42);
		getContentPane().add(campoSenha);
		
		campoConfirmaSenha = new JPasswordField();
		campoConfirmaSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoConfirmaSenha.setBounds(548, 454, 232, 42);
		getContentPane().add(campoConfirmaSenha);
	}
	
	public void criarJlabel() {
		
		JLabel img = new JLabel("");
		img.setIcon(new ImageIcon("Imagens/fotoLogin.png"));
		img.setBounds(83, 133, 393, 297);
		getContentPane().add(img);
		
		JLabel usuario = new JLabel("Usuário");
		usuario.setForeground(Color.WHITE);
		usuario.setFont(new Font("Tahoma", Font.BOLD, 17));
		usuario.setBounds(548, 152, 91, 42);
		getContentPane().add(usuario);
		
		JLabel email = new JLabel("E-mail");
		email.setForeground(Color.WHITE);
		email.setFont(new Font("Tahoma", Font.BOLD, 17));
		email.setBounds(548, 243, 63, 36);
		getContentPane().add(email);
		
		JLabel senha = new JLabel("Senha");
		senha.setForeground(Color.WHITE);
		senha.setFont(new Font("Tahoma", Font.BOLD, 17));
		senha.setBounds(548, 331, 63, 36);
		getContentPane().add(senha);
		
		JLabel cadastro = new JLabel("Cadastrar Administrador");
		cadastro.setForeground(Color.WHITE);
		cadastro.setFont(new Font("Times New Roman", Font.BOLD, 45));
		cadastro.setBounds(207, 52, 503, 42);
		getContentPane().add(cadastro);
		
		JLabel campoConfirmarSenha = new JLabel("Confirmar Senha");
		campoConfirmarSenha.setForeground(Color.WHITE);
		campoConfirmarSenha.setFont(new Font("Tahoma", Font.BOLD, 17));
		campoConfirmarSenha.setBounds(548, 419, 152, 36);
		getContentPane().add(campoConfirmarSenha);
	}
	
	public void criarBotao() {
		OuvinteBotaoEntrar ouvinte = new OuvinteBotaoEntrar(this);
		
		botaoEntrar = new JButton("Entrar");
		botaoEntrar.setForeground(Color.BLACK);
		botaoEntrar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		botaoEntrar.setBounds(689, 507, 91, 36);
		botaoEntrar.addActionListener(ouvinte);
		getContentPane().add(botaoEntrar);
		
	}
	
	public class OuvinteBotaoEntrar implements ActionListener {
		private TelaCadastroAdm janela;
		

		public OuvinteBotaoEntrar(TelaCadastroAdm janela) {
			this.janela = janela;
			

		}

		public void actionPerformed(ActionEvent e) {
			
			String usuario = janela.getCampoUsuario().getText();
			String email = janela.getCampoEmailUsuario().getText();
			String senha = new String(janela.getCampoSenha().getPassword());
			String confirmaSenha = new String(janela.getCampoConfirmaSenha().getPassword());

			if (usuario.isEmpty() || senha.isEmpty() || email.isEmpty() || confirmaSenha.isEmpty()) {
				Erros.setStrategy(new CamposNaoPreenchidosStrategy());
				Erros.lancarErro();

			} else if (!ValidaEmail.emailValidatorP(email)) {
				Erros.setStrategy(new EmailInvalidoStrategy());
				Erros.lancarErro();
				
			}else if(senha.length() < 8){
				Erros.setStrategy(new SenhaInvalidaMenorQue8Strategy());
				Erros.lancarErro();
				
			}else if(!confirmaSenha.equals(senha)){
				Erros.setStrategy(new SenhasDiferentesStrategy());
				Erros.lancarErro();
				
			}else {
				AdministradorDTO administrador = new AdministradorDTO(usuario,email,senha);
				
				AdministradorController.getInstance().salvarAdministrador(administrador);
				
				JOptionPane.showMessageDialog(janela, "Administrador cadastrado com sucesso","Cadastramento", JOptionPane.INFORMATION_MESSAGE);
				janela.dispose();
				
				new TelaLogin();
				
			}
			

		}

	}
}
