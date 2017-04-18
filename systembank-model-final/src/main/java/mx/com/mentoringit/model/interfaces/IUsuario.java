package mx.com.mentoringit.model.interfaces;

import mx.com.mentoringit.model.dto.UsuarioDTO;

public interface IUsuario {

	public UsuarioDTO buscar(UsuarioDTO usuario) throws Exception;
	
}
