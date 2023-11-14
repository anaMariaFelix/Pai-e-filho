package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ClienteController;
import controller.FuncionarioController;
import dto.FuncionarioDTO;
import iterator.ConcretIterator;
import iterator.Iterator;
import util.ButtonEditor;
import util.ButtonRenderer;
import util.Constantes;
import util.LimparTabela;

public class ListarFuncionario extends JanelaPadrao{
	
	private DefaultTableModel modelo;
	private JTable table;
	
	public ListarFuncionario() {
		criarBotoes();
		criarLabel();
		criarTabela();	
		
		setVisible(true);
	}
	
	
	public void criarBotoes() {
		JButton btnNovo = new JButton("Novo");
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNovo.setBounds(695, 535, 166, 41);
		btnNovo.addActionListener(new OuvinteBotaoNovo(this));
		getContentPane().add(btnNovo);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVoltar.setBounds(494, 535, 166, 41);
		btnVoltar.addActionListener(new OuvinteBotaoVoltar(this));
		getContentPane().add(btnVoltar);
	}
	
	
	public void criarLabel() {
		JLabel labelFuncionario = new JLabel("Funcionários");
		labelFuncionario.setForeground(new Color(255, 255, 255));
		labelFuncionario.setFont(new Font("Times New Roman", Font.BOLD, 45));
		labelFuncionario.setBounds(316, 33, 253, 77);
		getContentPane().add(labelFuncionario);
	}
	
	
	public void criarTabela() {

		modelo = new DefaultTableModel();
		modelo.addColumn("Nome");
		modelo.addColumn("Telefone");
		modelo.addColumn("Email");
		modelo.addColumn("Editar");
		modelo.addColumn("Detalhar");
		modelo.addColumn("Excluir");

		table = new JTable(modelo);

		table.getColumn("Editar").setCellRenderer(new ButtonRenderer());
		table.getColumn("Editar").setCellEditor(new ButtonEditor(new JCheckBox()));

		table.getColumn("Detalhar").setCellRenderer(new ButtonRenderer());
		table.getColumn("Detalhar").setCellEditor(new ButtonEditor(new JCheckBox()));

		table.getColumn("Excluir").setCellRenderer(new ButtonRenderer());
		table.getColumn("Excluir").setCellEditor(new ButtonEditor(new JCheckBox()));

		ArrayList<FuncionarioDTO> funcionarios = FuncionarioController.getInstance().recuperarTodosFuncionarios();

		JScrollPane painelTabela = new JScrollPane(table);

		painelTabela.setBounds(36, 165, 825, 350);
		getContentPane().add(painelTabela);

		preencherTabela(funcionarios);

	}

	public void preencherTabela(ArrayList<FuncionarioDTO> array) {
		LimparTabela.limparTabela(modelo, table);

		Iterator<FuncionarioDTO> funcionarios = new ConcretIterator(array);

		while (funcionarios.hasNext()) {
			FuncionarioDTO funcionario = funcionarios.next();

			Object[] linha = new Object[6];

			linha[0] = funcionario.getNome();
			linha[1] = funcionario.getTelefone();
			linha[2] = funcionario.getEmail();

			JButton btEditar = new JButton("Editar");
			btEditar.setBackground(new Color(39, 228, 86));
			btEditar.addActionListener(new OuvinteBotaoEditar(this, funcionario));
			linha[3] = btEditar;

			JButton btDetalhar = new JButton("Detalhar");
			btDetalhar.setBackground(new Color(39, 228, 86));
			btDetalhar.addActionListener(new OuvinteBotaoDetalhar(this, funcionario));
			linha[4] = btDetalhar;


			JButton btExcluir = new JButton("Excluir");
			btExcluir.setBackground(Color.red);
			btExcluir.addActionListener(new OuvinteBotaoExcluir(this, funcionario));
			linha[5] = btExcluir;

			modelo.addRow(linha);
		}
	}
	
	private class OuvinteBotaoEditar implements ActionListener{

		private ListarFuncionario janela;
		private FuncionarioDTO funcionario;
		
		public OuvinteBotaoEditar(ListarFuncionario janelaAntiga, FuncionarioDTO funcionario) {
			this.janela = janelaAntiga;
			this.funcionario = funcionario;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			janela.dispose();
			new EditarFuncionario(funcionario);
		}
		
	}
	
	private class OuvinteBotaoDetalhar implements ActionListener{
		
		private ListarFuncionario janela;
		private FuncionarioDTO funcionario;
		
		public OuvinteBotaoDetalhar(ListarFuncionario janelaAntiga, FuncionarioDTO funcionario) {
			this.janela = janelaAntiga;
			this.funcionario = funcionario;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			janela.dispose();
			new DetalharFuncionario(funcionario);
		}
		
	}
	
	private class OuvinteBotaoExcluir implements ActionListener{
		
		private ListarFuncionario janela;
		private FuncionarioDTO funcionario;
		
		public OuvinteBotaoExcluir(ListarFuncionario janelaAntiga, FuncionarioDTO funcionario) {
			this.janela = janelaAntiga;
			this.funcionario = funcionario;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			FuncionarioController.getInstance().removerFuncionario(funcionario);
			JOptionPane.showMessageDialog(null, "Funcionário removido com sucesso!");
			
			janela.dispose();
			new ListarFuncionario();
		}	
	}
	private class OuvinteBotaoNovo implements ActionListener{
		
		private ListarFuncionario janela;
		
		public OuvinteBotaoNovo(ListarFuncionario janelaAntiga) {
			this.janela = janelaAntiga;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {	
			janela.dispose();
			new CadastroFuncionario(Constantes.LISTAGEM);
		}	
	}
	
	private class OuvinteBotaoVoltar implements ActionListener{
		
		private ListarFuncionario janela;
		
		public OuvinteBotaoVoltar(ListarFuncionario janelaAntiga) {
			this.janela = janelaAntiga;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			janela.dispose();
			new Listagem();
		}	
	}
	
}
