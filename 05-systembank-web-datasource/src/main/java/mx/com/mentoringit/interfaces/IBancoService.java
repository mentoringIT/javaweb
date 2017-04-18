package mx.com.mentoringit.interfaces;

import java.util.ArrayList;

import mx.com.mentoringit.model.dto.BancoDTO;

public interface IBancoService {

	ArrayList<BancoDTO> listarBancos()throws Exception;
}