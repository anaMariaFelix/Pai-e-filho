package view;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Listagem extends JanelaPadrao{
	private JButton pedido;
	private JButton clinteFuncionario;
	private JButton servico;
	
	
	public Listagem() {
		criarJLabel();
		criarJButton();
		setVisible(true);
		
	}
	
	public void criarJLabel() {
		JLabel listagem = new JLabel("Listagens");
		listagem.setForeground(new Color(255, 255, 255));
		listagem.setFont(new Font("Times New Roman", Font.BOLD, 45));
		listagem.setBounds(356, 69, 190, 53);
		getContentPane().add(listagem);
		
		JLabel img = new JLabel("");
		img.setIcon(new ImageIcon("Imagens/fotoLogin.png"));
		img.setBounds(74, 204, 394, 256);
		getContentPane().add(img);
		
	}
	
	public void criarJButton() {
		pedido = new JButton("Pedido");
		pedido.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pedido.setBounds(534, 219, 265, 68);
		getContentPane().add(pedido);
		
		clinteFuncionario = new JButton("Cliente/Funcionários");
		clinteFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		clinteFuncionario.setBounds(534, 317, 265, 68);
		getContentPane().add(clinteFuncionario);
		
		servico = new JButton("Serviços");
		servico.setFont(new Font("Tahoma", Font.PLAIN, 25));
		servico.setBounds(534, 412, 265, 68);
		getContentPane().add(servico);
	}
	
	
}
