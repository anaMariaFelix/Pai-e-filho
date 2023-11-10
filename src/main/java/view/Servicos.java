package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ServicoController;
import execoesPersonalizadas.ServicoExistenteException;
import iterator.ConcretIterator;
import iterator.Iterator;
import strategy.Erros;
import strategy.SelecioneLinhaStrategy;
import strategy.SemInformacao;
import strategy.ServicoExistenteStrategy;

public class Servicos extends JanelaPadrao {

	private DefaultTableModel modelo;
	private JTable table;

	public Servicos() {
		criarJLabel();
		criarTabela();
		criarJButton();
		setVisible(true);
	}

	public void criarJLabel() {
		JLabel lblNewLabel = new JLabel("Serviços");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblNewLabel.setBounds(364, 34, 166, 67);
		getContentPane().add(lblNewLabel);
	}

	public void criarJButton() {
		JButton voltar = new JButton("Voltar");
		voltar.setForeground(new Color(0, 0, 0));
		voltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		voltar.setBounds(62, 485, 166, 41);
		voltar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaMenu();
			}
		});
		getContentPane().add(voltar);

		JButton novo = new JButton("Novo");
		novo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		novo.setBounds(652, 485, 166, 41);
		novo.addActionListener(new OuvinteBotaoNovo(this));
		getContentPane().add(novo);

		JButton botaoEditar = new JButton("Editar");
		botaoEditar.setForeground(Color.BLACK);
		botaoEditar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botaoEditar.setBounds(458, 485, 166, 41);
		botaoEditar.addActionListener(new OuvinteBotaoEditar(this));
		getContentPane().add(botaoEditar);

		JButton botaoRemover = new JButton("Remover");
		botaoRemover.setForeground(Color.BLACK);
		botaoRemover.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botaoRemover.setBounds(259, 485, 166, 41);
		botaoRemover.addActionListener(new OuvinteBotaoRemover(this));
		getContentPane().add(botaoRemover);
	}

	public void criarTabela() {

		modelo = new DefaultTableModel();
		modelo.addColumn("Serviços");

		Iterator<String> servicos = new ConcretIterator(ServicoController.getInstance().recuperarServicos());

		while (servicos.hasNext()) {
			String servico = servicos.next();

			Object[] valor = { servico };
			modelo.addRow(valor);
		}

		table = new JTable(modelo);
		JScrollPane painelTabela = new JScrollPane(table);

		painelTabela.setBounds(62, 137, 756, 313);
		getContentPane().add(painelTabela);
	}

	private class OuvinteBotaoRemover implements ActionListener {

		private Servicos janela;

		public OuvinteBotaoRemover(Servicos janelaServico) {
			this.janela = janelaServico;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			int indice = table.getSelectedRow();

			if (indice == -1) {
				Erros.setStrategy(new SelecioneLinhaStrategy());
				Erros.lancarErro();

			} else {
				ServicoController.getInstance().removerServico(indice);
				JOptionPane.showMessageDialog(janela, "Serviço excluido com sucesso!");

				table.repaint();
				janela.dispose();
				new Servicos();
			}

		}

	}

	private class OuvinteBotaoEditar implements ActionListener {

		private Servicos janela;

		public OuvinteBotaoEditar(Servicos janelaServico) {
			this.janela = janelaServico;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			int indice = table.getSelectedRow();

			if (indice == -1) {
				Erros.setStrategy(new SelecioneLinhaStrategy());
				Erros.lancarErro();

			} else {

				String servicoEditado = JOptionPane.showInputDialog(this.janela, "Digite o novo nome para o serviço");

				if (servicoEditado != null) {
					if (!servicoEditado.isEmpty()) {
						ServicoController.getInstance().editarServico(indice, servicoEditado);
						JOptionPane.showMessageDialog(janela, "Serviço Editado com sucesso!");

						table.repaint();
						janela.dispose();
						new Servicos();
					}else {
						Erros.setStrategy(new SemInformacao());
						Erros.lancarErro();
					}

				}

			}

		}

	}

	private class OuvinteBotaoNovo implements ActionListener {

		private Servicos janela;

		public OuvinteBotaoNovo(Servicos janelaServico) {
			this.janela = janelaServico;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			String novoServico = JOptionPane.showInputDialog(this.janela,
					"Digite o nome do serviço que será adicionado");

			System.out.println(novoServico);

			if (novoServico == null || novoServico.isEmpty()) {
				Erros.setStrategy(new SemInformacao());
				Erros.lancarErro();

			} else {

				try {
					ServicoController.getInstance().adicionarServico(novoServico);
					JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso!");
					janela.dispose();
					new Servicos();

				} catch (ServicoExistenteException e1) {
					Erros.setStrategy(new ServicoExistenteStrategy());
					Erros.lancarErro();
				}

			}

		}

	}
}
