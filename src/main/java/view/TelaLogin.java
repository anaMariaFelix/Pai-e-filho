package view;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import controller.AdministradorController;
import dto.AdministradorDTO;
import strategy.CamposNaoPreenchidosStrategy;
import strategy.EmailInvalidoStrategy;
import strategy.Erros;
import strategy.SenhaInvalidaMenorQue8Strategy;
import strategy.SenhaInvalidaStrategy;
import strategy.Strategy;
import util.ValidaEmail;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JPasswordField;

public class TelaLogin extends JanelaPadrao{
	private JTextField campoEmail;
	private JButton botaoEntrar;
	private JPasswordField campoSenha;
	
	public TelaLogin() {
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().setForeground(new Color(255, 255, 255));
		
		criarLabel();
		criarButton();
		criarTextField();	
		setVisible(true);
	}
	
	public JTextField getCampoEmail() {
		return campoEmail;
	}

	public void setCampoEmail(JTextField campoEmail) {
		this.campoEmail = campoEmail;
	}

	public JPasswordField getCampoSenha() {
		return campoSenha;
	}

	public void setCampoSenha(JPasswordField campoSenha) {
		this.campoSenha = campoSenha;
	}

	public void criarLabel() {
		JLabel img = new JLabel("");
		img.setIcon(new ImageIcon("Imagens/fotoLogin.png"));
		img.setBounds(64, 195, 406, 255);
		getContentPane().add(img);
		
		JLabel senha = new JLabel("Senha:");
		senha.setForeground(new Color(255, 255, 255));
		senha.setBackground(new Color(240, 240, 240));
		senha.setFont(new Font("Tahoma", Font.BOLD, 20));
		senha.setBounds(480, 303, 78, 31);
		getContentPane().add(senha);
		
		JLabel email = new JLabel("Email:");
		email.setForeground(new Color(255, 255, 255));
		email.setFont(new Font("Tahoma", Font.BOLD, 20));
		email.setBounds(480, 195, 95, 25);
		getContentPane().add(email);
		
		JLabel login = new JLabel("Login");
		login.setForeground(new Color(255, 255, 255));
		login.setFont(new Font("Times New Roman", Font.BOLD, 50));
		login.setBounds(377, 47, 136, 61);
		getContentPane().add(login);
	}
	
	public void criarTextField() {
		campoEmail = new JTextField();
		campoEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoEmail.setBounds(480, 231, 329, 61);
		getContentPane().add(campoEmail);
		campoEmail.setColumns(10);
		
		campoSenha = new JPasswordField();
		campoSenha.setBounds(480, 346, 329, 61);
		getContentPane().add(campoSenha);
	}
	
	public void criarButton() {
		OuvinteBotaoEntrar ouvinte = new OuvinteBotaoEntrar(this);
		
		botaoEntrar = new JButton("Entrar");
		botaoEntrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		botaoEntrar.setBounds(646, 434, 163, 43);
		botaoEntrar.addActionListener(ouvinte);
		getContentPane().add(botaoEntrar);
	}
	
	public class OuvinteBotaoEntrar implements ActionListener {
		private TelaLogin janela;
		

		public OuvinteBotaoEntrar(TelaLogin janela) {
			this.janela = janela;
			

		}

		public void actionPerformed(ActionEvent e) {
			AdministradorDTO administrador = AdministradorController.getInstance().recuperarAdministrador();
			
			String email = janela.getCampoEmail().getText();
			String senha = new String(janela.getCampoSenha().getPassword());

			if (senha.isEmpty() || email.isEmpty()) {
				Erros.setStrategy(new CamposNaoPreenchidosStrategy());
				Erros.lancarErro();
				
			}else if(!administrador.getSenha().equals(senha)){
				Erros.setStrategy(new SenhaInvalidaStrategy());
				Erros.lancarErro();
				
			}else if(!administrador.getEmail().equals(email)){
				Erros.setStrategy(new EmailInvalidoStrategy());
				Erros.lancarErro();
				
			}else {
				janela.dispose();
				
				new TelaMenu();
				
			}
			

		}

	}
}
