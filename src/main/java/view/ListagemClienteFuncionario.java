package view;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JButton;

public class ListagemClienteFuncionario extends JanelaPadrao{
	private JTable table;
	private JButton novo;
	private JButton voltar;
	private JRadioButton todos;
	private JRadioButton cliente;
	private JRadioButton funcionarios;
	
	
	
	public ListagemClienteFuncionario() {
		criarJLabel();
		criarTabela();
		criarJBUtton();
		criarRadioButton();
		setVisible(true);
		
	}
	
	public void criarJLabel() {
		JLabel lblNewLabel = new JLabel("Clientes e Funcionários");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(231, 36, 450, 89);
		getContentPane().add(lblNewLabel);
	}
	
	public void criarTabela() {
		table = new JTable();		//Dentro botao de detalhar editar e deletar
		table.setBounds(94, 196, 718, 313);
		getContentPane().add(table);
	}
	
	public void criarJBUtton() {
		novo = new JButton("Novo\r\n");
		novo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		novo.setBounds(646, 534, 166, 41);
		getContentPane().add(novo);
		
		voltar = new JButton("Voltar");
		voltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		voltar.setBounds(453, 534, 166, 41);
		getContentPane().add(voltar);
	}
	
	public void criarRadioButton() {
		todos = new JRadioButton("Todos");
		todos.setForeground(Color.WHITE);
		todos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		todos.setBackground(new Color(31, 38, 107));
		todos.setBounds(94, 138, 79, 41);
		getContentPane().add(todos);
		
		cliente = new JRadioButton("Cliente");
		cliente.setForeground(Color.WHITE);
		cliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cliente.setBackground(new Color(31, 38, 107));
		cliente.setBounds(189, 138, 85, 41);
		getContentPane().add(cliente);
		
		funcionarios = new JRadioButton("Funcionário");
		funcionarios.setForeground(Color.WHITE);
		funcionarios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		funcionarios.setBackground(new Color(31, 38, 107));
		funcionarios.setBounds(295, 138, 129, 41);
		getContentPane().add(funcionarios);
	}

}
