package view;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CadastrarPedido extends JanelaPadrao{
	private JTextField campoNomeCliente;
	private JTextField campoCPF;
	private JTextField campoTelefone;
	private JComboBox comboBoxServico;
	private JTextArea descricao;
	
	private JButton ButtonVoltar;
	private JButton ButtonSalvar;
	
	public CadastrarPedido() {
		
		criarJTextField();
		criarJcomboBox();
		criarJbutton();
		criarJlabel();
		criarJTextArea();
		setVisible(true);
	}
	
	public void criarJTextField() {
		campoNomeCliente = new JTextField();
		campoNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoNomeCliente.setColumns(10);
		campoNomeCliente.setBounds(275, 120, 344, 47);
		getContentPane().add(campoNomeCliente);
		
		campoCPF = new JTextField();
		campoCPF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoCPF.setColumns(10);
		campoCPF.setBounds(275, 209, 344, 47);
		getContentPane().add(campoCPF);
		
		campoTelefone = new JTextField();
		campoTelefone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoTelefone.setColumns(10);
		campoTelefone.setBounds(275, 298, 344, 47);
		getContentPane().add(campoTelefone);
		
	}
	
	public void criarJcomboBox() {
		comboBoxServico = new JComboBox();
		comboBoxServico.setBounds(275, 388, 344, 45);
		getContentPane().add(comboBoxServico);
	}
	
	public void criarJbutton() {
		ButtonVoltar = new JButton("Voltar");
		ButtonVoltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ButtonVoltar.setBounds(275, 545, 166, 41);
		getContentPane().add(ButtonVoltar);
		
		ButtonSalvar = new JButton("Salvar");
		ButtonSalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ButtonSalvar.setBounds(453, 545, 166, 41);
		getContentPane().add(ButtonSalvar);
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
		DescriçãoServiço.setBounds(275, 444, 228, 22);
		getContentPane().add(DescriçãoServiço);
		
		JLabel CPF = new JLabel("Email Cliente");
		CPF.setForeground(Color.WHITE);
		CPF.setFont(new Font("Tahoma", Font.BOLD, 20));
		CPF.setBounds(275, 177, 133, 22);
		getContentPane().add(CPF);
		
		JLabel Telefone = new JLabel("Telefone");
		Telefone.setForeground(Color.WHITE);
		Telefone.setFont(new Font("Tahoma", Font.BOLD, 20));
		Telefone.setBounds(275, 266, 92, 22);
		getContentPane().add(Telefone);
		
		JLabel SelecionarServiço = new JLabel("Selecionar  Serviço");
		SelecionarServiço.setForeground(Color.WHITE);
		SelecionarServiço.setFont(new Font("Tahoma", Font.BOLD, 20));
		SelecionarServiço.setBounds(275, 355, 228, 22);
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
		
		
	}
	
	public void criarJTextArea() {
		descricao = new JTextArea();
		descricao.setFont(new Font("Monospaced", Font.PLAIN, 18));
		descricao.setBounds(275, 476, 344, 59);
		getContentPane().add(descricao);
	}
}
