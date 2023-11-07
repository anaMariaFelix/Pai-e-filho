package view;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cadastros extends JanelaPadrao{
	
	private JButton btnCliente;
	private JButton btnFuncionrio;
	private JButton btnPedido_2;
	
	public Cadastros() {
		criarBotao();
		criarLabel();	
		setVisible(true);
	}
	
	public void criarBotao() {
		btnCliente = new JButton("Cliente");
		btnCliente.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnCliente.setBounds(531, 195, 265, 68);
		getContentPane().add(btnCliente);
		
		btnFuncionrio = new JButton("Funcionário");
		btnFuncionrio.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnFuncionrio.setBounds(531, 292, 265, 68);
		getContentPane().add(btnFuncionrio);
		
		btnPedido_2 = new JButton("Pedido");
		btnPedido_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnPedido_2.setBounds(531, 395, 265, 68);
		getContentPane().add(btnPedido_2);
	}

	public void criarLabel() {
		JLabel img = new JLabel("");
		img.setIcon(new ImageIcon("Imagens/fotoLogin.png"));
		img.setBounds(70, 206, 370, 246);
		getContentPane().add(img);
		
		JLabel cadastros = new JLabel("Cadastros");
		cadastros.setForeground(Color.WHITE);
		cadastros.setFont(new Font("Times New Roman", Font.BOLD, 45));
		cadastros.setBounds(355, 47, 196, 87);
		getContentPane().add(cadastros);
	}
}
