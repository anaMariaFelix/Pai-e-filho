package main;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import controller.AdministradorController;
import util.Constantes;
import view.CadastrarPedido;
import view.TelaCadastroAdm;
import view.TelaLogin;
import view.TelaMenu;

public class Programa {
	public static void main(String[] args) {
		
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}

		if (AdministradorController.getInstance().recuperarAdministrador() != null) {
			new TelaLogin();

		} else {
			new TelaCadastroAdm();
		}
		
	}
}