package strategy;

import javax.swing.JOptionPane;

public class CamposNaoPreenchidosStrategy implements Strategy{

	@Override
	public void mostrarErro() {
		JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos");
	}

}
