package view;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JProgressBar;

public class Servicos extends JanelaPadrao{
	private JTable table;
	private JButton voltar;
	private JButton novo;

	public Servicos() {
		criarJLabel();
		criarTabela();
		criarJButton();
		setVisible(true);
	}
	public void criarJLabel() {
		JLabel lblNewLabel = new JLabel("Serviços");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblNewLabel.setBounds(364, 34, 166, 67);
		getContentPane().add(lblNewLabel);
	}
	public void criarTabela() {
		table = new JTable();		//Dentro botão editar e remover
		table.setBounds(62, 137, 756, 313);
		getContentPane().add(table);
	}
	public void criarJButton() {
		voltar = new JButton("Voltar");
		voltar.setForeground(new Color(0, 0, 0));
		voltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		voltar.setBounds(455, 485, 166, 41);
		getContentPane().add(voltar);
		
		novo = new JButton("Novo\r\n");
		novo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		novo.setBounds(652, 485, 166, 41);
		getContentPane().add(novo);
	}
}
