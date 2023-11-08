package strategy;

import javax.swing.JOptionPane;

public class SenhaInvalidaMenorQue8Strategy implements Strategy{

	@Override
	public void mostrarErro() {
		JOptionPane.showMessageDialog(null, "A Senha deve ter no minimo 8 caracteres","ERRO", JOptionPane.ERROR_MESSAGE);
		
	}

}
