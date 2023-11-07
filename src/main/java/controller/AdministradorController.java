package controller;

import dao.AdministradorDAO;
import dto.AdministradorDTO;

public class AdministradorController {

	private static volatile AdministradorController instance;
	
	
	private AdministradorController() {
		
	}
	
	public static AdministradorController getInstance() {
		if(instance == null) {
			synchronized (AdministradorController.class) {
				if(instance == null) {
					instance = new AdministradorController();
				}
				
			}
		}
		return instance;
	}

	public void salvarAdministrador(AdministradorDTO administrador) {
		AdministradorDAO.getInstance().salvarAdministrador(administrador);
	}
	
	public AdministradorDTO recuperarAdministrador() {
		return AdministradorDAO.getInstance().recuperarAdministrador();
	}
}
