package view;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class CadastroFuncionario extends JanelaPadrao{
	private JTextField campoNome;
	private JTextField campoTelefone;
	private JTextField campoEmail;
	private JTextField CPF;
	
	private JButton buttonVoltar;
	private JButton buttonSalvar;
	
	public CadastroFuncionario() {
		
		criarJbutton();
		criarJTextField();
		criarJLabel();
		setVisible(true);
	}
	
	public void criarJbutton() {
		buttonVoltar = new JButton("Voltar");
		buttonVoltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonVoltar.setBounds(282, 501, 166, 41);
		getContentPane().add(buttonVoltar);
		
		buttonSalvar = new JButton("Salvar");
		buttonSalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonSalvar.setBounds(460, 501, 166, 41);
		getContentPane().add(buttonSalvar);
	}
	
	public void criarJTextField() {
		campoNome = new JTextField();
		campoNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoNome.setColumns(10);
		campoNome.setBounds(282, 163, 344, 47);
		getContentPane().add(campoNome);
		
		campoTelefone = new JTextField();
		campoTelefone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoTelefone.setColumns(10);
		campoTelefone.setBounds(282, 251, 344, 47);
		getContentPane().add(campoTelefone);
		
		campoEmail = new JTextField();
		campoEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoEmail.setColumns(10);
		campoEmail.setBounds(282, 336, 344, 47);
		getContentPane().add(campoEmail);
		
		CPF = new JTextField();
		CPF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		CPF.setColumns(10);
		CPF.setBounds(282, 428, 344, 47);
		getContentPane().add(CPF);
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
}
