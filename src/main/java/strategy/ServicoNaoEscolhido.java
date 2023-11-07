package strategy;

import javax.swing.JOptionPane;

public class ServicoNaoEscolhido implements Strategy{

	@Override
	public void mostrarErro() {
		JOptionPane.showMessageDialog(null, "Deve-se escolher ao menos um serviço");
	}

}
