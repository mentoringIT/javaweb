package mx.com.mentoringit.model.interfaces;

import java.util.ArrayList;

import mx.com.mentoringit.model.dto.BancoDTO;

public interface IBanco {

	ArrayList<BancoDTO> listarBanco() throws Exception;

	
}
