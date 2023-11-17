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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ClienteController;
import dto.ClienteDTO;
import email.Mensageiro;
import iterator.ConcretIterator;
import iterator.Iterator;
import relatorio.Relatorio;
import relatorio.RelatorioFactory;
import util.ButtonEditor;
import util.ButtonRenderer;
import util.Constantes;
import util.LimparTabela;

public class ListagemCliente extends JanelaPadrao {

	private DefaultTableModel modelo;
	private JTable table;

	private JButton novo;
	private JButton voltar;

	private JRadioButton todos;
	private JRadioButton cliente;
	private JRadioButton funcionarios;

	public ListagemCliente() {
		criarJLabel();
		criarTabela();
		criarJBUtton();
		setVisible(true);

	}

	public void criarJLabel() {
		JLabel lblNewLabel = new JLabel("Clientes");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(371, 33, 155, 89);
		getContentPane().add(lblNewLabel);
	}

	public void criarTabela() {

		modelo = new DefaultTableModel();
		modelo.addColumn("Nome");
		modelo.addColumn("Telefone");
		modelo.addColumn("Email");
		modelo.addColumn("Editar");
		modelo.addColumn("Detalhar");
		modelo.addColumn("Gerar Relatorio");
		modelo.addColumn("Enviar Email");
		modelo.addColumn("Excluir");

		table = new JTable(modelo);

		table.getColumn("Editar").setCellRenderer(new ButtonRenderer());
		table.getColumn("Editar").setCellEditor(new ButtonEditor(new JCheckBox()));

		table.getColumn("Detalhar").setCellRenderer(new ButtonRenderer());
		table.getColumn("Detalhar").setCellEditor(new ButtonEditor(new JCheckBox()));

		table.getColumn("Gerar Relatorio").setCellRenderer(new ButtonRenderer());
		table.getColumn("Gerar Relatorio").setCellEditor(new ButtonEditor(new JCheckBox()));
		
		table.getColumn("Enviar Email").setCellRenderer(new ButtonRenderer());
		table.getColumn("Enviar Email").setCellEditor(new ButtonEditor(new JCheckBox()));

		table.getColumn("Excluir").setCellRenderer(new ButtonRenderer());
		table.getColumn("Excluir").setCellEditor(new ButtonEditor(new JCheckBox()));

		ArrayList<ClienteDTO> clientes = ClienteController.getInstance().recuperarTodosClientes();

		JScrollPane painelTabela = new JScrollPane(table);

		painelTabela.setBounds(36, 165, 825, 350);
		getContentPane().add(painelTabela);

		preencherTabela(clientes);

	}

	public void preencherTabela(ArrayList<ClienteDTO> array) {
		LimparTabela.limparTabela(modelo, table);

		Iterator<ClienteDTO> clientes = new ConcretIterator(array);

		while (clientes.hasNext()) {
			ClienteDTO cliente = clientes.next();

			Object[] linha = new Object[8];

			linha[0] = cliente.getNome();
			linha[1] = cliente.getTelefone();
			linha[2] = cliente.getEmail();

			JButton btEditar = new JButton("Editar");
			btEditar.setBackground(new Color(39, 228, 86));
			btEditar.addActionListener(new OuvinteBotaoEditar(this, cliente));
			linha[3] = btEditar;

			JButton btDetalhar = new JButton("Detalhar");
			btDetalhar.setBackground(new Color(39, 228, 86));
			btDetalhar.addActionListener(new OuvinteBotaoDetalhar(this, cliente));
			linha[4] = btDetalhar;

			JButton btRelatorio = new JButton("Relatorio");
			btRelatorio.setBackground(new Color(39, 200, 86));
			btRelatorio.addActionListener(new OuvinteBotaoRelatorio(this, cliente));
			linha[5] = btRelatorio;

			JButton btEmail = new JButton("Email");
			btEmail.setBackground(new Color(39, 200, 86));
			btEmail.addActionListener(new OuvinteBotaoEmail(this, cliente));
			linha[6] = btEmail;
			
			JButton btExcluir = new JButton("Excluir");
			btExcluir.setBackground(Color.red);
			btExcluir.addActionListener(new OuvinteBotaoExcluir(this, cliente));
			linha[7] = btExcluir;

			modelo.addRow(linha);
		}
	}

	public void criarJBUtton() {
		novo = new JButton("Novo");
		novo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		novo.setBounds(695, 534, 166, 41);
		novo.addActionListener(new OuvinteBotaoNovo(this));
		getContentPane().add(novo);

		voltar = new JButton("Voltar");
		voltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		voltar.setBounds(495, 534, 166, 41);
		voltar.addActionListener(new OuvinteBotaoVoltar(this));
		getContentPane().add(voltar);
	}

	private class OuvinteBotaoVoltar implements ActionListener {

		private ListagemCliente janela;

		public OuvinteBotaoVoltar(ListagemCliente janela) {
			this.janela = janela;
		}

		public void actionPerformed(ActionEvent e) {
			janela.dispose();
			new Listagem();

		}

	}

	private class OuvinteBotaoNovo implements ActionListener {

		private ListagemCliente janela;

		public OuvinteBotaoNovo(ListagemCliente janela) {
			this.janela = janela;
		}

		public void actionPerformed(ActionEvent e) {
			janela.dispose();
			new CadastroDoCliente(Constantes.LISTAGEM);

		}

	}

	private class OuvinteBotaoEditar implements ActionListener {

		private ListagemCliente janela;
		private ClienteDTO cliente;

		public OuvinteBotaoEditar(ListagemCliente janela, ClienteDTO cliente) {
			this.janela = janela;
			this.cliente = cliente;
		}

		public void actionPerformed(ActionEvent e) {
			janela.dispose();
			new EditarCliente(cliente);

		}

	}

	private class OuvinteBotaoDetalhar implements ActionListener {

		private ListagemCliente janela;
		private ClienteDTO cliente;

		public OuvinteBotaoDetalhar(ListagemCliente janela, ClienteDTO cliente) {
			this.janela = janela;
			this.cliente = cliente;
		}

		public void actionPerformed(ActionEvent e) {
			janela.dispose();
			new DetalharCliente(cliente);

		}

	}

	private class OuvinteBotaoExcluir implements ActionListener {

		private ListagemCliente janela;
		private ClienteDTO cliente;

		public OuvinteBotaoExcluir(ListagemCliente janela, ClienteDTO cliente) {
			this.janela = janela;
			this.cliente = cliente;
		}

		public void actionPerformed(ActionEvent e) {

			ClienteController.getInstance().removerCliente(cliente);
			JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
			janela.dispose();
			new ListagemCliente();
		}

	}

	private class OuvinteBotaoRelatorio implements ActionListener {

		private ListagemCliente janela;
		private ClienteDTO cliente;

		public OuvinteBotaoRelatorio(ListagemCliente janela, ClienteDTO cliente) {
			this.janela = janela;
			this.cliente = cliente;
		}

		public void actionPerformed(ActionEvent e) {

			Relatorio relatorio = RelatorioFactory.criaRelatorio(Constantes.CLIENTE);
			relatorio.gerarRelatorio(cliente);
			JOptionPane.showMessageDialog(null, "Relatório do cliente criado com sucesso!");

		}

	}

	private class OuvinteBotaoEmail implements ActionListener {

		private ListagemCliente janela;
		private ClienteDTO cliente;

		public OuvinteBotaoEmail(ListagemCliente janela, ClienteDTO cliente) {
			this.janela = janela;
			this.cliente = cliente;
		}

		public void actionPerformed(ActionEvent e) {

			String conteudoEmailString = JOptionPane.showInputDialog("Informe o conteúdo do Email.");
			Mensageiro.getInstance().setEmailCliente(cliente.getEmail());
			Mensageiro.getInstance().setMensagem(conteudoEmailString);
			JOptionPane.showMessageDialog(null, "O email está sendo enviado.");
			Mensageiro.getInstance().start();
			

		}

	}
}
