package strategy;

import javax.swing.JOptionPane;

public class ServicoExistenteStrategy implements Strategy{

	@Override
	public void mostrarErro() {
		JOptionPane.showMessageDialog(null, "Serviço já existente");
	}
}
