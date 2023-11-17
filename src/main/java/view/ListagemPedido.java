package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.PedidoController;
import dto.PedidoDTO;
import iterator.ConcretIterator;
import iterator.Iterator;
import relatorio.Relatorio;
import relatorio.RelatorioFactory;
import util.ButtonEditor;
import util.ButtonRenderer;
import util.Constantes;
import util.LimparTabela;

public class ListagemPedido extends JanelaPadrao {

	private DefaultTableModel modelo; 
	private JTable table; 

	private JButton novo;
	private JButton voltar;

	private JRadioButton todos;
	private JRadioButton finalizado;
	private JRadioButton andamento;

	public ListagemPedido() {
		criarJLabel();
		criarTabela();
		criarJButoon();
		criarRadioButton();
		setVisible(true);

	}

	public void criarJLabel() {
		JLabel lblNewLabel = new JLabel("Pedidos");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(381, 32, 159, 59);
		getContentPane().add(lblNewLabel);
	}

	public void criarTabela() {

		modelo = new DefaultTableModel();
		modelo.addColumn("Nome Cliente");
		modelo.addColumn("Serviço");
		modelo.addColumn("Valor");
		modelo.addColumn("Situação");
		modelo.addColumn("Finalizar");
		modelo.addColumn("Editar");
		modelo.addColumn("Detalhar");
		modelo.addColumn("Gerar Relatorio");
		modelo.addColumn("Excluir");

		table = new JTable(modelo);

		table.getColumn("Finalizar").setCellRenderer(new ButtonRenderer()); 
		table.getColumn("Finalizar").setCellEditor(new ButtonEditor(new JCheckBox()));

		table.getColumn("Editar").setCellRenderer(new ButtonRenderer()); 
		table.getColumn("Editar").setCellEditor(new ButtonEditor(new JCheckBox()));

		table.getColumn("Detalhar").setCellRenderer(new ButtonRenderer());
		table.getColumn("Detalhar").setCellEditor(new ButtonEditor(new JCheckBox()));

		table.getColumn("Gerar Relatorio").setCellRenderer(new ButtonRenderer()); 
		table.getColumn("Gerar Relatorio").setCellEditor(new ButtonEditor(new JCheckBox()));

		table.getColumn("Excluir").setCellRenderer(new ButtonRenderer()); 
		table.getColumn("Excluir").setCellEditor(new ButtonEditor(new JCheckBox()));

		ArrayList<PedidoDTO> pedidos = PedidoController.getInstance().recuperarTodosPedidos();

		JScrollPane painelTabela = new JScrollPane(table);

		painelTabela.setBounds(36, 165, 825, 350);
		getContentPane().add(painelTabela);

		preencherTabela(pedidos);

	}

	public void preencherTabela(ArrayList<PedidoDTO> array) {
		LimparTabela.limparTabela(modelo, table);

		Iterator<PedidoDTO> pedidos = new ConcretIterator(array);

		while (pedidos.hasNext()) {
			PedidoDTO pedido = pedidos.next();

			Object[] linha = new Object[9];

			linha[0] = pedido.getNomeCliente();
			linha[1] = pedido.getServico();
			linha[2] = pedido.getValor();
			linha[3] = pedido.getFinalizado();

			JButton btFinalizar = new JButton("Finalizar");
			btFinalizar.setBackground(new Color(39, 228, 86));
			btFinalizar.addActionListener(new OuvinteBotaoFinalizar(this, pedido));
			linha[4] = btFinalizar;

			JButton btEditar = new JButton("Editar");
			btEditar.setBackground(new Color(39, 228, 86));
			btEditar.addActionListener(new OuvinteBotaoEditar(this, pedido));
			linha[5] = btEditar;

			if (pedido.getFinalizado().equals(Constantes.FINALIZADO)) {
				btFinalizar.setEnabled(false);
				btEditar.setEnabled(false);
			}
			
			JButton btDetalhar = new JButton("Detalhar");
			btDetalhar.setBackground(new Color(39, 228, 86));
			btDetalhar.addActionListener(new OuvinteBotaoDetalhar(this, pedido));
			linha[6] = btDetalhar;

			JButton btRelatorio = new JButton("Relatorio");
			btRelatorio.setBackground(new Color(39, 200, 86));
			btRelatorio.addActionListener(new OuvinteBotaoRelatorio(this, pedido));
			linha[7] = btRelatorio;

			JButton btExcluir = new JButton("Excluir");
			btExcluir.setBackground(Color.red);
			btExcluir.addActionListener(new OuvinteBotaoExcluir(this, pedido));
			linha[8] = btExcluir;

			modelo.addRow(linha);
		}

	}

	public void criarJButoon() {
		novo = new JButton("Novo\r\n");
		novo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		novo.setBounds(695, 536, 166, 41);
		novo.addActionListener(new OuvinteBotaoNovo(this));
		getContentPane().add(novo);

		voltar = new JButton("Voltar");
		voltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		voltar.setBounds(492, 536, 166, 41);
		voltar.addActionListener(new OuvinteBotaoVoltar(this));
		getContentPane().add(voltar);
	}

	public void criarRadioButton() {
		OuvinteRadioButton ouvinteRadioButton = new OuvinteRadioButton(this);

		todos = new JRadioButton("Todos");
		todos.doClick();
		todos.setForeground(new Color(255, 255, 255));
		todos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		todos.setBackground(new Color(31, 38, 107));
		todos.setBounds(36, 118, 79, 41);
		todos.addActionListener(ouvinteRadioButton);
		getContentPane().add(todos);

		finalizado = new JRadioButton("Finalizados");
		finalizado.setForeground(Color.WHITE);
		finalizado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		finalizado.setBackground(new Color(31, 38, 107));
		finalizado.setBounds(127, 118, 123, 41);
		finalizado.addActionListener(ouvinteRadioButton);
		getContentPane().add(finalizado);

		andamento = new JRadioButton("Andamento");
		andamento.setForeground(Color.WHITE);
		andamento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		andamento.setBackground(new Color(31, 38, 107));
		andamento.setBounds(263, 118, 127, 41);
		andamento.addActionListener(ouvinteRadioButton);
		getContentPane().add(andamento);

		ButtonGroup bg = new ButtonGroup();
		bg.add(todos);
		bg.add(finalizado);
		bg.add(andamento);
	}

	private class OuvinteBotaoVoltar implements ActionListener {

		private ListagemPedido janela;

		public OuvinteBotaoVoltar(ListagemPedido janela) {
			this.janela = janela;
		}

		public void actionPerformed(ActionEvent e) {
			janela.dispose();
			new Listagem();

		}

	}

	private class OuvinteBotaoNovo implements ActionListener {

		private ListagemPedido janela;

		public OuvinteBotaoNovo(ListagemPedido janela) {
			this.janela = janela;
		}

		public void actionPerformed(ActionEvent e) {
			janela.dispose();
			new CadastrarPedido("listagem");

		}

	}

	private class OuvinteRadioButton implements ActionListener {

		private ListagemPedido janela;

		public OuvinteRadioButton(ListagemPedido janela) {
			this.janela = janela;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			if (todos.isSelected()) {
				preencherTabela(PedidoController.getInstance().recuperarTodosPedidos());

			} else if (finalizado.isSelected()) {
				preencherTabela(PedidoController.getInstance().filtrarPorTipo(Constantes.FINALIZADO));

			} else {
				preencherTabela(PedidoController.getInstance().filtrarPorTipo(Constantes.ANDAMENTO));
			}

		}

	}

	private class OuvinteBotaoFinalizar implements ActionListener {

		private ListagemPedido janela;
		private PedidoDTO pedidoAntigo;

		public OuvinteBotaoFinalizar(ListagemPedido janela, PedidoDTO pedidoAntigo) {
			this.janela = janela;
			this.pedidoAntigo = pedidoAntigo;
		}

		public void actionPerformed(ActionEvent e) {

			PedidoDTO pedidoAtualizado = new PedidoDTO(pedidoAntigo.getNomeCliente(), pedidoAntigo.getEmailCliente(),
					pedidoAntigo.getTelefone(), pedidoAntigo.getServico(), pedidoAntigo.getDescricao(),
					pedidoAntigo.getValor(), Constantes.FINALIZADO);

			PedidoController.getInstance().removerPedido(pedidoAntigo);
			PedidoController.getInstance().salvarPedido(pedidoAtualizado);

			JOptionPane.showMessageDialog(null, "O status do pedido foi atualizado");

			janela.dispose();
			new ListagemPedido();

		}

	}

	private class OuvinteBotaoEditar implements ActionListener {

		private ListagemPedido janela;
		private PedidoDTO pedido;

		public OuvinteBotaoEditar(ListagemPedido janela, PedidoDTO pedido) {
			this.janela = janela;
			this.pedido = pedido;
		}

		public void actionPerformed(ActionEvent e) {
			janela.dispose();
			new EditarPedido(pedido);

		}

	}

	private class OuvinteBotaoDetalhar implements ActionListener {

		private ListagemPedido janela;
		private PedidoDTO pedido;

		public OuvinteBotaoDetalhar(ListagemPedido janela, PedidoDTO pedido) {
			this.janela = janela;
			this.pedido = pedido;
		}

		public void actionPerformed(ActionEvent e) {
			janela.dispose();
			new DetalharPedido(pedido);

		}

	}

	private class OuvinteBotaoExcluir implements ActionListener {

		private ListagemPedido janela;
		private PedidoDTO pedido;

		public OuvinteBotaoExcluir(ListagemPedido janela, PedidoDTO pedido) {
			this.janela = janela;
			this.pedido = pedido;
		}

		public void actionPerformed(ActionEvent e) {

			PedidoController.getInstance().removerPedido(pedido);
			JOptionPane.showMessageDialog(null, "Pedido removido com sucesso!");
			janela.dispose();
			new ListagemPedido();
		}

	}

	private class OuvinteBotaoRelatorio implements ActionListener {

		private ListagemPedido janela;
		private PedidoDTO pedido;

		public OuvinteBotaoRelatorio(ListagemPedido janela, PedidoDTO pedido) {
			this.janela = janela;
			this.pedido = pedido;
		}

		public void actionPerformed(ActionEvent e) {

			Relatorio relatorio = RelatorioFactory.criaRelatorio(Constantes.PEDIDO);
			relatorio.gerarRelatorio(pedido);
			JOptionPane.showMessageDialog(null, "Relatório do pedido criado com sucesso!");

		}

	}

}
