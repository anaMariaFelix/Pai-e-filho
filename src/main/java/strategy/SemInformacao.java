package strategy;

import javax.swing.JOptionPane;

public class SemInformacao implements Strategy{

	@Override
	public void mostrarErro() {
		JOptionPane.showMessageDialog(null, "Deve ser digitado a informação");		
	}

}
