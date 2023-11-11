package view;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;

public class ListarFuncionario extends JanelaPadrao{
	
	
	public ListarFuncionario() {
		
		JLabel labelFuncionario = new JLabel("Funcionários");
		labelFuncionario.setForeground(new Color(255, 255, 255));
		labelFuncionario.setFont(new Font("Times New Roman", Font.BOLD, 45));
		labelFuncionario.setBounds(316, 33, 253, 77);
		getContentPane().add(labelFuncionario);
		
		JTable tabbedPane = new JTable();
		tabbedPane.setBounds(68, 144, 769, 357);
		getContentPane().add(tabbedPane);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNovo.setBounds(671, 535, 166, 41);
		getContentPane().add(btnNovo);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVoltar.setBounds(463, 535, 166, 41);
		getContentPane().add(btnVoltar);
		
		setVisible(true);
	}
}
