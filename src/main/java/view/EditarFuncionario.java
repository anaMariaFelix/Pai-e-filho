package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.FuncionarioController;
import dto.FuncionarioDTO;
import execoesPersonalizadas.FuncionarioExistenteException;
import strategy.CPFInvalido;
import strategy.CamposNaoPreenchidosStrategy;
import strategy.EmailInvalidoStrategy;
import strategy.Erros;
import strategy.FuncionarioExistenteStrategy;
import util.ValidaEmail;
import util.ValidadorCPF;

public class EditarFuncionario{
	
	private FuncionarioDTO funcionarioAntigo;
	private CadastroFuncionario telaCadFuncionario;
	
	
	public EditarFuncionario(FuncionarioDTO funcionario) {
		this.funcionarioAntigo = funcionario;
		
		
		telaCadFuncionario = new CadastroFuncionario();
		
		telaCadFuncionario.getCadastrarFuncionário().setText("Editar Funcionário");
		
		telaCadFuncionario.getButtonSalvar().removeActionListener(telaCadFuncionario.getOuvinteSalvar());
		telaCadFuncionario.getButtonVoltar().removeActionListener(telaCadFuncionario.getOuvinteVoltar());
		
		telaCadFuncionario.getCampoNome().setText(funcionario.getNome());
		telaCadFuncionario.getCampoTelefone().setText(funcionario.getTelefone());
		telaCadFuncionario.getCampoEmail().setText(funcionario.getEmail());
		telaCadFuncionario.getCampoCPF().setText(funcionario.getCpf());
		
		telaCadFuncionario.getButtonVoltar().addActionListener(new OuvinteBotaoVoltar(telaCadFuncionario));
		telaCadFuncionario.getButtonSalvar().addActionListener(new OuvinteBotaoSalvar(telaCadFuncionario));
		
	}
	
	private class OuvinteBotaoSalvar implements ActionListener {

		private CadastroFuncionario janela;
		
		public OuvinteBotaoSalvar(CadastroFuncionario cadastroFuncionario) {
			this.janela = cadastroFuncionario;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			String nome = telaCadFuncionario.getCampoNome().getText();
			String telefone = telaCadFuncionario.getCampoTelefone().getText().replace("(", "").replace(")", "").replace("-", "").trim();
			String email = telaCadFuncionario.getCampoEmail().getText();
			String cpf = telaCadFuncionario.getCampoCPF().getText().replace("-", "").replace(".", "").trim();
			
			
			if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty() || cpf.isEmpty()) {
				Erros.setStrategy(new CamposNaoPreenchidosStrategy());
				Erros.lancarErro();
				
			}else if (!ValidaEmail.emailValidatorP(email)) {
				Erros.setStrategy(new EmailInvalidoStrategy());
				Erros.lancarErro();
				
			}else if (!ValidadorCPF.isCPF(cpf)) {
				Erros.setStrategy(new CPFInvalido());
				Erros.lancarErro();
				
			}else {
				
				FuncionarioDTO funcionarioNovo = new FuncionarioDTO(nome, telefone, email, cpf);
				
				FuncionarioController.getInstance().removerFuncionario(funcionarioAntigo);
				
				try {
					FuncionarioController.getInstance().salvarFuncionario(funcionarioNovo);
					JOptionPane.showMessageDialog(janela, "Funcionário cadastrado com sucesso!");
					
					janela.dispose();
					new ListagemCliente(); 
					
				} catch (FuncionarioExistenteException e1) {
					Erros.setStrategy(new FuncionarioExistenteStrategy());
					Erros.lancarErro();
				}
				
				
				
			}
			

		}

	}
	
	
	private class OuvinteBotaoVoltar implements ActionListener {

		private CadastroFuncionario janela;

		public OuvinteBotaoVoltar(CadastroFuncionario cadastro) {
			this.janela = cadastro;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			this.janela.dispose();
			new ListagemCliente();
		}

	}
	

}
