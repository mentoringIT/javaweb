package mx.com.mentoringit.model.interfaces;

import java.util.ArrayList;

import mx.com.mentoringit.model.dto.BancoDTO;

public interface IBanco {

	public ArrayList<BancoDTO> listarBanco() throws Exception;
}