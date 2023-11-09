package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dto.ClienteDTO;


public class DetalharCliente {

	public DetalharCliente(ClienteDTO clienteDTO) {
		detalharCliente(clienteDTO);
	}
	
	public void detalharCliente(ClienteDTO clienteDTO) {
		ClienteDTO cliente = clienteDTO;
		
		CadastroDoCliente telaCadastroCliente = new CadastroDoCliente();
		
		telaCadastroCliente.getCadastrarCliente().setText("Detalhar Cliente");
		
		telaCadastroCliente.getBotaoSalvar().removeActionListener(telaCadastroCliente.getOuvinteSalvar());
		telaCadastroCliente.getBotaoSalvar().setVisible(false);
		
		telaCadastroCliente.getBotaoVoltar().removeActionListener(telaCadastroCliente.getOuvinteVoltar());
		telaCadastroCliente.getBotaoVoltar().setBounds(452, 550, 166, 41);
		
		
		telaCadastroCliente.getCampoNome().setText(cliente.getNome());
		telaCadastroCliente.getCampoNome().setEnabled(false);
		
		telaCadastroCliente.getCampoTelefone().setText(cliente.getTelefone());
		telaCadastroCliente.getCampoTelefone().setEnabled(false);
		
		telaCadastroCliente.getCampoEmail().setText(cliente.getEmail());
		telaCadastroCliente.getCampoEmail().setEnabled(false);
		
		telaCadastroCliente.getCampoCPF().setText(cliente.getCpf());
		telaCadastroCliente.getCampoCPF().setEnabled(false);
		
		if(cliente.isNotificacao()) {
			telaCadastroCliente.getRadioButonSim().setEnabled(false);
			telaCadastroCliente.getRadioButonNao().setVisible(false);
		}else {
			telaCadastroCliente.getRadioButonSim().setVisible(false);
			telaCadastroCliente.getRadioButonNao().setEnabled(false);
			telaCadastroCliente.getRadioButonNao().setBounds(276, 512, 59, 23);
			telaCadastroCliente.getRadioButonNao().setSelected(true);
		}
		
		telaCadastroCliente.getBotaoVoltar().addActionListener(new OuvinteBotaoVoltar(telaCadastroCliente));
		
	}
	
	
	private class OuvinteBotaoVoltar implements ActionListener {

		private CadastroDoCliente janela;

		public OuvinteBotaoVoltar(CadastroDoCliente cadastro) {
			this.janela = cadastro;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			this.janela.dispose();
			new ListagemClienteFuncionario();
		}

	}
}
