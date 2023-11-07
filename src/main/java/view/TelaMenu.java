package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class TelaMenu extends JanelaPadrao{
	private static final long serialVersionUID = 1L;
	private JButton botaoCadastros;
	private JButton botaoservicos;
	private JButton botaolistagem;
	
	public TelaMenu() {
		criarLabel();
		criarBotao();
		setVisible(true);
	}
	
	
	public void criarBotao() {
		JButton botaoCadastros = new JButton("Cadastros");
		botaoCadastros.setFont(new Font("Tahoma", Font.PLAIN, 25));
		botaoCadastros.setBounds(531, 189, 265, 68);
		getContentPane().add(botaoCadastros);
		
		JButton botaoservicos = new JButton("Serviços");		//seviços vai ficar aqui ou na tela de listagens?
		botaoservicos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		botaoservicos.setBounds(531, 290, 265, 68);
		getContentPane().add(botaoservicos);
		
		JButton botaolistagem = new JButton("Listagem");
		botaolistagem.setFont(new Font("Tahoma", Font.PLAIN, 25));
		botaolistagem.setBounds(531, 397, 265, 68);
		getContentPane().add(botaolistagem);
	}
	
	public void criarLabel() {
		
//		ImageIcon imagem = new ImageIcon("Imagens/PartyHelper.png");
//		JLabel rotulo = new JLabel(imagem);
//		rotulo.setBounds(77, 189, 370, 256);
//		getContentPane().add(rotulo);
		
		JLabel img = new JLabel("");
		img.setIcon(new ImageIcon("Imagens/fotoLogin.png"));
		img.setBounds(77, 189, 370, 246);
		getContentPane().add(img);
		
		JLabel menu = new JLabel("Menu");
		menu.setForeground(Color.WHITE);
		menu.setFont(new Font("Times New Roman", Font.BOLD, 45));
		menu.setBounds(394, 50, 113, 76);
		getContentPane().add(menu);
	}
	

}
