package view;


import java.awt.Color;

import javax.swing.JFrame;


public class JanelaPadrao extends JFrame {

	private static final long serialVersionUID = 1L;
	//private JPanel contentPane;


	public JanelaPadrao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 685);
//		contentPane = new JPanel();
		getContentPane().setBackground(new Color(31, 38, 107));
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);		
		//setBackground(new Color(255, 255, 255));
	
	}
}
