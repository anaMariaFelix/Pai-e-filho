package strategy;

import javax.swing.JOptionPane;

public class EmailInvalidoStrategy implements Strategy{

	@Override
	public void mostrarErro() {
		JOptionPane.showMessageDialog(null, "Email Inválido\nDigite novamente");
	}

}
