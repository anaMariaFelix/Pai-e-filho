package view;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class ListagemPedido extends JanelaPadrao{
	private JTable table;
	private JButton novo;
	private JButton voltar;
	private JRadioButton todos;
	private JRadioButton finalizado;
	private JRadioButton andamento;
	
	
	public ListagemPedido() {
		criarJLabel();
		criarTabela();
		criarJButoon();
		criarRadioButton();
		setVisible(true);
		
	}
	public void criarJLabel() {
		JLabel lblNewLabel = new JLabel("Pedidos");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(381, 32, 159, 59);
		getContentPane().add(lblNewLabel);
	}
	
	public void criarTabela() {
		table = new JTable();		//Dentro botao de relatório
		table.setBounds(84, 168, 718, 313);
		getContentPane().add(table);
	}
	
	public void criarJButoon() {
		novo = new JButton("Novo\r\n");
		novo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		novo.setBounds(636, 510, 166, 41);
		getContentPane().add(novo);
		
		voltar = new JButton("Voltar");
		voltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		voltar.setBounds(448, 510, 166, 41);
		getContentPane().add(voltar);
	}
	public void criarRadioButton() {
		todos = new JRadioButton("Todos");
		todos.setForeground(new Color(255, 255, 255));
		todos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		todos.setBackground(new Color(31, 38, 107));
		todos.setBounds(84, 118, 79, 41);
		getContentPane().add(todos);
		
		finalizado = new JRadioButton("Finalizados");
		finalizado.setForeground(Color.WHITE);
		finalizado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		finalizado.setBackground(new Color(31, 38, 107));
		finalizado.setBounds(190, 118, 123, 41);
		getContentPane().add(finalizado);
		
		andamento = new JRadioButton("Andamento");
		andamento.setForeground(Color.WHITE);
		andamento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		andamento.setBackground(new Color(31, 38, 107));
		andamento.setBounds(339, 118, 127, 41);
		getContentPane().add(andamento);
	}
	
}
