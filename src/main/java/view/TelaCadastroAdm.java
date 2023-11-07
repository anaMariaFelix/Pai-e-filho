package view;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class TelaCadastroAdm extends JanelaPadrao{
	private JTextField campoUsuario;
	private JTextField campoEmailUsuario;
	private JPasswordField campoSenha;
	private JButton botaoEntrar;
	
	public TelaCadastroAdm() {
		criarBotao();
		criarJlabel();
		criarTextField();
		criarPasswordField();
		setVisible(true);
	}
	
	
	
	public void criarTextField() {
		campoUsuario = new JTextField();
		campoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoUsuario.setColumns(10);
		campoUsuario.setBounds(548, 279, 232, 42);
		getContentPane().add(campoUsuario);
		
		campoEmailUsuario = new JTextField();
		campoEmailUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoEmailUsuario.setColumns(10);
		campoEmailUsuario.setBounds(548, 191, 232, 42);
		getContentPane().add(campoEmailUsuario);
	}
	
	
	public void criarPasswordField() {
		campoSenha = new JPasswordField();
		campoSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoSenha.setBounds(548, 366, 232, 42);
		getContentPane().add(campoSenha);
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
		
		
		
		JLabel cadastro = new JLabel("Cadastro");
		cadastro.setForeground(Color.WHITE);
		cadastro.setFont(new Font("Times New Roman", Font.BOLD, 45));
		cadastro.setBounds(348, 51, 183, 42);
		getContentPane().add(cadastro);
	}
	
	public void criarBotao() {
		
		botaoEntrar = new JButton("Entrar");
		botaoEntrar.setForeground(Color.BLACK);
		botaoEntrar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		botaoEntrar.setBounds(689, 417, 91, 36);
		getContentPane().add(botaoEntrar);
		
	}
	
}
