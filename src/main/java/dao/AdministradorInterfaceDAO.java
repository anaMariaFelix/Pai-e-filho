package dao;

import dto.AdministradorDTO;

public interface AdministradorInterfaceDAO {

	void salvarAdministrador(AdministradorDTO dto);
	
	AdministradorDTO recuperarAdministrador() throws Exception;
	
}
