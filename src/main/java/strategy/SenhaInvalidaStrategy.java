package strategy;

import javax.swing.JOptionPane;

public class SenhaInvalidaStrategy implements Strategy{

	@Override
	public void mostrarErro() {
		JOptionPane.showMessageDialog(null, "Senha inválida\nDigite novamente");
	}

}
