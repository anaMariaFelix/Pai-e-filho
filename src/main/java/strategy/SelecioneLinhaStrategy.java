package strategy;

import javax.swing.JOptionPane;

public class SelecioneLinhaStrategy implements Strategy{

	@Override
	public void mostrarErro() {
		JOptionPane.showMessageDialog(null, "Selecione uma linha");	
	}

}
