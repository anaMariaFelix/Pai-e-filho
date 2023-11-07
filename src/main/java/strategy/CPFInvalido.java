package strategy;

import javax.swing.JOptionPane;

public class CPFInvalido implements Strategy{

	@Override
	public void mostrarErro() {
		JOptionPane.showMessageDialog(null, "CPF inválido\nDigite novamente");
	}

}
