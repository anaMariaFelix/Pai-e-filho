package dao;

import bancoDeDados.BancoDeDados;
import bancoDeDados.Persistencia;
import dto.AdministradorDTO;
import util.Constantes;

public class AdministradorDAO implements AdministradorInterfaceDAO{

	private volatile static AdministradorDAO instance;
	
	private AdministradorDAO() {
		
	}
	
	public static AdministradorDAO getInstance() {
		if (instance == null) {
			synchronized (AdministradorDAO.class) {
				if (instance == null) {
					instance = new AdministradorDAO();
				}
			}
		}
		return instance;
	}


	@Override
	public void salvarAdministrador(AdministradorDTO AdmDTO) {
		BancoDeDados.getInstance().setAdministrador(AdmDTO);
		Persistencia.getInstance().salvarBanco(BancoDeDados.getInstance(), Constantes.NOME_ARQUIVO_XML);
		
	}

	@Override
	public AdministradorDTO recuperarAdministrador() {
		return BancoDeDados.getInstance().getAdministrador();
		
	}
	
}
