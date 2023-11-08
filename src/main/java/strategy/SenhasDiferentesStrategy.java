package strategy;

import javax.swing.JOptionPane;

public class SenhasDiferentesStrategy implements Strategy{

	@Override
	public void mostrarErro() {
		JOptionPane.showMessageDialog(null, "Confirmação de Senha inválida\nDigite novamente");
		
	}

}
