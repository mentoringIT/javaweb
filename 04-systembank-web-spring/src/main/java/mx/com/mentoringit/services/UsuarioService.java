package mx.com.mentoringit.services;

import mx.com.mentoringit.interfaces.IUsuarioService;
import mx.com.mentoringit.model.dto.UsuarioDTO;
import mx.com.mentoringit.model.interfaces.IUsuario;

public class UsuarioService implements IUsuarioService {

	private IUsuario usuario;
	private static int contador;
	public UsuarioService() {
		contador++;
		System.out.println("valor de contador: " + contador);
	}
	
	@Override
	public UsuarioDTO login(UsuarioDTO usuarioDTO) throws Exception {

		return usuario.buscar(usuarioDTO);
	
	}

	public IUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(IUsuario usuario) {
		this.usuario = usuario;
	}
}