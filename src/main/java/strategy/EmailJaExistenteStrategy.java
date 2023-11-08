package strategy;

import javax.swing.JOptionPane;

public class EmailJaExistenteStrategy implements Strategy{

	@Override
	public void mostrarErro() {
		JOptionPane.showMessageDialog(null, "Já existe um cliente com esse email\nPor favor informe outro email.");
		
	}

}
