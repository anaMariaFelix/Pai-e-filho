package strategy;

import javax.swing.JOptionPane;

public class ClienteNaoExistenteStrategy implements Strategy {

	@Override
	public void mostrarErro() {
		JOptionPane.showMessageDialog(null,
				"Informe um email de um cliente já cadastrado.\nCaso o cliente não esteja cadastrado, não é possivel criar um pedido.");
	}

}
