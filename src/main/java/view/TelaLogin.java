package view;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;

public class TelaLogin extends JanelaPadrao{
	private JTextField campoUsuario;
	private JButton botaoEntrar;
	private JPasswordField passwordField;
	
	public TelaLogin() {
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().setForeground(new Color(255, 255, 255));
		
		criarLabel();
		criarButton();
		criarTextField();	
		setVisible(true);
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
		
		JLabel usuario = new JLabel("Usuario:");
		usuario.setForeground(new Color(255, 255, 255));
		usuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		usuario.setBounds(480, 195, 95, 25);
		getContentPane().add(usuario);
		
		JLabel login = new JLabel("Login");
		login.setForeground(new Color(255, 255, 255));
		login.setFont(new Font("Times New Roman", Font.BOLD, 50));
		login.setBounds(377, 47, 136, 61);
		getContentPane().add(login);
	}
	
	public void criarTextField() {
		campoUsuario = new JTextField();
		campoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoUsuario.setBounds(480, 231, 329, 61);
		getContentPane().add(campoUsuario);
		campoUsuario.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(480, 346, 329, 61);
		getContentPane().add(passwordField);
	}
	
	public void criarButton() {
		botaoEntrar = new JButton("Entrar");
		botaoEntrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		botaoEntrar.setBounds(646, 434, 163, 43);
		getContentPane().add(botaoEntrar);
	}
}
