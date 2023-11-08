package view;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JSpinner;
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
	
	public CadastroDoCliente() {
		criarBotao();
		criarLabel();
		criarTextField();	
		setVisible(true);
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

	public void setRadioButonSim(JRadioButton radioButonSim) {
		this.radioButonSim = radioButonSim;
	}

	public JRadioButton getRadioButonNao() {
		return radioButonNao;
	}

	public void setRadioButonNao(JRadioButton radioButonNao) {
		this.radioButonNao = radioButonNao;
	}


	public void criarLabel() {
		JLabel lblNewLabel_1_1 = new JLabel("Telefone");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(276, 207, 92, 22);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("E-mail");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(276, 296, 92, 22);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("CPF");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(276, 385, 92, 22);
		getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("Cadastrar Cliente");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblNewLabel_2_1.setBounds(273, 36, 370, 47);
		getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(276, 118, 92, 22);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Imagens/marca.png"));
		lblNewLabel.setBounds(699, 501, 176, 104);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1_4 = new JLabel("Deseja Receber  Notificações:");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(276, 475, 309, 22);
		getContentPane().add(lblNewLabel_1_3);
	}
	
	public void criarTextField() {
		campoNome = new JTextField();
		campoNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoNome.setBounds(276, 150, 344, 47);
		getContentPane().add(campoNome);
		campoNome.setColumns(10);
		
		campoTelefone = new JTextField();
		campoTelefone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoTelefone.setColumns(10);
		campoTelefone.setBounds(276, 239, 344, 47);
		getContentPane().add(campoTelefone);
		
		campoEmail = new JTextField();
		campoEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoEmail.setColumns(10);
		campoEmail.setBounds(276, 328, 344, 47);
		getContentPane().add(campoEmail);
		
		campoCPF = new JTextField();
		campoCPF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoCPF.setColumns(10);
		campoCPF.setBounds(276, 417, 344, 47);
		getContentPane().add(campoCPF);
		
	}
	 
	public void JRadioButton() {
		
		JRadioButton radioButonSim = new JRadioButton("Sim");
		radioButonSim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		radioButonSim.setForeground(new Color(255, 255, 255));
		radioButonSim.setBackground(new Color(31, 38, 107));
		radioButonSim.setBounds(276, 512, 59, 23);
		getContentPane().add(radioButonSim);
		
		JRadioButton radioButonNao = new JRadioButton("Não");
		radioButonNao.setForeground(new Color(255, 255, 255));
		radioButonNao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		radioButonNao.setBackground(new Color(31, 38, 107));
		radioButonNao.setBounds(353, 512, 76, 23);
		getContentPane().add(radioButonNao);
		
	}
	
	public void criarBotao() {
		botaoVoltar = new JButton("Voltar");
		botaoVoltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botaoVoltar.setBounds(276, 550, 166, 41);
		getContentPane().add(botaoVoltar);
		
		botaoSalvar = new JButton("Salvar");
		botaoSalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botaoSalvar.setBounds(452, 550, 166, 41);
		getContentPane().add(botaoSalvar);
	}
}
