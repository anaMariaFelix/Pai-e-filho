package strategy;

import javax.swing.JOptionPane;

public class FuncionarioExistenteStrategy implements Strategy{

	@Override
	public void mostrarErro() {
		JOptionPane.showMessageDialog(null, "Funcionário já existente\nAltere o email e tente novamente");	
	}

}
