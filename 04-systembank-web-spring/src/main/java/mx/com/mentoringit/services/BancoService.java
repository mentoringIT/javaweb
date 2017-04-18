package mx.com.mentoringit.services;

import java.util.ArrayList;

import mx.com.mentoringit.interfaces.IBancoService;
import mx.com.mentoringit.model.dto.BancoDTO;
import mx.com.mentoringit.model.interfaces.IBanco;

public class BancoService implements IBancoService {

	private IBanco bancoDAO;
	
	public BancoService() {
		
	}
	
	@Override
	public ArrayList<BancoDTO> listarBancos() throws Exception {
		return bancoDAO.listarBanco();
	}
	public IBanco getBancoDAO() {
		return bancoDAO;
	}
	public void setBancoDAO(IBanco bancoDAO) {
		this.bancoDAO = bancoDAO;
	}
}