package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import controller.EmailObserverController;
import strategy.Erros;
import strategy.SemInformacao;

public class TelaMenu extends JanelaPadrao {
	private static final long serialVersionUID = 1L;

	private JButton botaoCadastros;
	private JButton botaoservicos;
	private JButton botaolistagem;
	private JButton botaoEmails;

	public TelaMenu() {
		criarLabel();
		criarBotao();
		setVisible(true);
	}

	public void criarBotao() {
		OuvinteBotoesDoMenu ouviente = new OuvinteBotoesDoMenu();

		botaoCadastros = new JButton("Cadastros");
		botaoCadastros.setFont(new Font("Tahoma", Font.PLAIN, 25));
		botaoCadastros.setBounds(531, 169, 265, 68);
		botaoCadastros.addActionListener(ouviente);
		getContentPane().add(botaoCadastros);

		botaoservicos = new JButton("Serviços");
		botaoservicos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		botaoservicos.setBounds(531, 272, 265, 68);
		botaoservicos.addActionListener(ouviente);
		getContentPane().add(botaoservicos);

		botaolistagem = new JButton("Listagem");
		botaolistagem.setFont(new Font("Tahoma", Font.PLAIN, 25));
		botaolistagem.setBounds(531, 373, 265, 68);
		botaolistagem.addActionListener(ouviente);
		getContentPane().add(botaolistagem);

		botaoEmails = new JButton("Emails");
		botaoEmails.setToolTipText("Promoções,Notificações e Novidades");
		botaoEmails.setFont(new Font("Tahoma", Font.PLAIN, 25));
		botaoEmails.setBounds(531, 474, 265, 68);
		botaoEmails.addActionListener(ouviente);
		getContentPane().add(botaoEmails);
	}

	public void criarLabel() {

		JLabel img = new JLabel("");
		img.setIcon(new ImageIcon("Imagens/fotoLogin.png"));
		img.setBounds(77, 189, 370, 246);
		getContentPane().add(img);

		JLabel menu = new JLabel("Menu");
		menu.setForeground(Color.WHITE);
		menu.setFont(new Font("Times New Roman", Font.BOLD, 45));
		menu.setBounds(394, 50, 113, 76);
		getContentPane().add(menu);
	}

	private class OuvinteBotoesDoMenu implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == botaoCadastros) {
				dispose();
				new Cadastros();

			} else if (e.getSource() == botaoservicos) {
				dispose();
				new Servicos();

			} else if (e.getSource() == botaolistagem) {
				dispose();
				new Listagem();

			} else if (e.getSource() == botaoEmails) {

				boolean continuar = true;

				do {
					String notificacaoParaCliente = JOptionPane
							.showInputDialog("Qual Notificação você deseja enviar para os clientes");

					if (notificacaoParaCliente == null) {
						continuar = false;
					} else {
						
						if (!notificacaoParaCliente.isEmpty()) {
							EmailObserverController.getInstance().preencherArrayNotificados();
							EmailObserverController.getInstance().setMensagem(notificacaoParaCliente);
							
							JOptionPane.showMessageDialog(null, "Os emails estão sendo enviados");
							
							continuar = false;
						} else {
							Erros.setStrategy(new SemInformacao());
							Erros.lancarErro();
						}

					}
				} while (continuar);
			}
		}

	}
}
