package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dto.FuncionarioDTO;

public class DetalharFuncionario {

	private FuncionarioDTO funcionario;
	private CadastroFuncionario telaCadFuncionario;
	
	
	public DetalharFuncionario(FuncionarioDTO funcionario) {
		this.funcionario = funcionario;
		
		
		telaCadFuncionario = new CadastroFuncionario();
		
		telaCadFuncionario.getCadastrarFuncionário().setText("Detalhar Funcionário");
		
		
		telaCadFuncionario.getButtonSalvar().removeActionListener(telaCadFuncionario.getOuvinteSalvar());
		telaCadFuncionario.getButtonSalvar().setVisible(false);
		
		telaCadFuncionario.getButtonVoltar().removeActionListener(telaCadFuncionario.getOuvinteVoltar());
		telaCadFuncionario.getButtonVoltar().setLocation(460, 501);
		
		
		telaCadFuncionario.getCampoNome().setText(funcionario.getNome());
		telaCadFuncionario.getCampoNome().disable();
		
		telaCadFuncionario.getCampoTelefone().setText(funcionario.getTelefone());
		telaCadFuncionario.getCampoTelefone().disable();
		
		telaCadFuncionario.getCampoEmail().setText(funcionario.getEmail());
		telaCadFuncionario.getCampoEmail().disable();
		
		telaCadFuncionario.getCampoCPF().setText(funcionario.getCpf());
		telaCadFuncionario.getCampoCPF().disable();
		
		telaCadFuncionario.getButtonVoltar().addActionListener(new OuvinteBotaoVoltar(telaCadFuncionario));
		
	}
	
	
	private class OuvinteBotaoVoltar implements ActionListener {

		private CadastroFuncionario janela;

		public OuvinteBotaoVoltar(CadastroFuncionario cadastro) {
			this.janela = cadastro;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			this.janela.dispose();
			new ListagemClienteFuncionario();
		}

	}
}