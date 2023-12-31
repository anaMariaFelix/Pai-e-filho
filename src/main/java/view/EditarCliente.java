package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ClienteController;
import controller.EmailObserverController;
import dto.ClienteDTO;
import execoesPersonalizadas.EmailJaCadastradoException;
import strategy.CPFInvalido;
import strategy.CamposNaoPreenchidosStrategy;
import strategy.EmailInvalidoStrategy;
import strategy.Erros;
import util.Constantes;
import util.ValidaEmail;
import util.ValidadorCPF;

public class EditarCliente {

	public EditarCliente(ClienteDTO clienteDTO) {
		editarCliente(clienteDTO);
	}
	
	public void editarCliente(ClienteDTO clienteDTO) {
		ClienteDTO cliente = clienteDTO;
		
		CadastroDoCliente telaCadastroCliente = new CadastroDoCliente(Constantes.LISTAGEM);
		
		telaCadastroCliente.getCadastrarCliente().setText("Editar Cliente");
		
		telaCadastroCliente.getBotaoSalvar().removeActionListener(telaCadastroCliente.getOuvinteSalvar());
		telaCadastroCliente.getBotaoVoltar().removeActionListener(telaCadastroCliente.getOuvinteVoltar());
	
		
		telaCadastroCliente.getCampoNome().setText(cliente.getNome());	
		telaCadastroCliente.getCampoTelefone().setText(cliente.getTelefone());
		telaCadastroCliente.getCampoEmail().setText(cliente.getEmail());
		telaCadastroCliente.getCampoCPF().setText(cliente.getCpf());
		
		
		telaCadastroCliente.getRadioButonSim();
		telaCadastroCliente.getRadioButonNao();
		
		telaCadastroCliente.getBotaoVoltar().addActionListener(new OuvinteBotaoVoltar(telaCadastroCliente));
		telaCadastroCliente.getBotaoSalvar().addActionListener(new OuvinteBotaoSalvar(telaCadastroCliente,cliente));
		
	}
	
	
	private class OuvinteBotaoVoltar implements ActionListener {

		private CadastroDoCliente janela;

		public OuvinteBotaoVoltar(CadastroDoCliente cadastro) {
			this.janela = cadastro;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			this.janela.dispose();
			new ListagemCliente();
		}

	}
	
	public String removerMascaraCampoCPF(JTextField cpf) {
		return cpf.getText().replace(".", "").replace("-", "").trim();
	}
	
	protected class OuvinteBotaoSalvar implements ActionListener {
		private CadastroDoCliente janela;
		private ClienteDTO clienteSemEdicao;

		public OuvinteBotaoSalvar(CadastroDoCliente janela,ClienteDTO cliente) {
			this.janela = janela;
			this.clienteSemEdicao = cliente;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			String nome = janela.getCampoNome().getText();
			String telefone = janela.getCampoTelefone().getText().replace("(", "").replace(")", "").replace("-", "").trim();
			String email = janela.getCampoEmail().getText();
			String cpf = removerMascaraCampoCPF(janela.getCampoCPF());
			boolean notificacao = false;

			if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty() || cpf.isEmpty()) {
				Erros.setStrategy(new CamposNaoPreenchidosStrategy());
				Erros.lancarErro();

			} else if (!ValidaEmail.emailValidatorP(email)) {
				Erros.setStrategy(new EmailInvalidoStrategy());
				Erros.lancarErro();

			} else if (!ValidadorCPF.isCPF(cpf)) {
				Erros.setStrategy(new CPFInvalido());
				Erros.lancarErro();

			}else {
				
				if (janela.getRadioButonSim().isSelected()) {
					notificacao = true;
				}
				
				ClienteDTO cliente = new ClienteDTO(nome,telefone,email,cpf,notificacao);

				try {
					EmailObserverController.getInstance().removerNotificado(clienteSemEdicao);
					ClienteController.getInstance().removerCliente(clienteSemEdicao);
					ClienteController.getInstance().salvarCliente(cliente);
					
					JOptionPane.showMessageDialog(null, "Cliente Editado com sucesso.");
					
					janela.dispose();
					new ListagemCliente();

				} catch (EmailJaCadastradoException e1) {
					
				}


			}

		}

	}
}
