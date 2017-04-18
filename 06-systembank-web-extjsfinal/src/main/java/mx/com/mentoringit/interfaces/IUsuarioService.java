package mx.com.mentoringit.interfaces;

import mx.com.mentoringit.model.dto.UsuarioDTO;

public interface IUsuarioService {

	UsuarioDTO login(UsuarioDTO usuarioDTO) throws Exception;
}