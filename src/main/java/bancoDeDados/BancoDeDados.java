package bancoDeDados;

import java.util.ArrayList;
import java.util.Arrays;

import dto.AdministradorDTO;
import dto.ClienteDTO;
import dto.FuncionarioDTO;
import dto.PedidoDTO;
import util.Constantes;

public class BancoDeDados{

	private ArrayList<ClienteDTO> clientes = new ArrayList();
	private ArrayList<FuncionarioDTO> funcionarios = new ArrayList();
	private ArrayList<String> todosServicos = new ArrayList();
	private ArrayList<PedidoDTO> pedidos = new ArrayList();
	private AdministradorDTO administrador;

	private volatile static BancoDeDados instance;
	
	private BancoDeDados() {
		popularTodosServicos();
	}

	public static BancoDeDados getInstance() {
		if (instance == null) {
			synchronized (BancoDeDados.class) {
				BancoDeDados doArquivo = Persistencia.getInstance().recuperarBanco(Constantes.NOME_ARQUIVO_XML);
				if (doArquivo == null) {
					if (instance == null) {
						instance = new BancoDeDados();
					}
				}else {
					instance = doArquivo;
				}
			}
		}
		return instance;
	}
	
	
	public ArrayList<ClienteDTO> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<ClienteDTO> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<FuncionarioDTO> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(ArrayList<FuncionarioDTO> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public ArrayList<String> getTodosServicos() {
		return todosServicos;
	}

	public void setTodosServicos(ArrayList<String> todosServicos) {
		this.todosServicos = todosServicos;
	}

	public ArrayList<PedidoDTO> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<PedidoDTO> pedidos) {
		this.pedidos = pedidos;
	}

	public AdministradorDTO getAdministrador() {
		return administrador;
	}

	public void setAdministrador(AdministradorDTO administrador) {
		this.administrador = administrador;
	}

	private void popularTodosServicos() {
		todosServicos.addAll(Arrays.asList("PVC", "Letras", "Placas", "ACM", "Fachada", "Corrimão", "Alambrado"));
	}

}
