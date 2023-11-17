package view;


import java.awt.Color;

import javax.swing.JFrame;


public class JanelaPadrao extends JFrame {

	private static final long serialVersionUID = 1L;

	public JanelaPadrao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 685);
		getContentPane().setBackground(new Color(31, 38, 107));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);		
	
	}
}
