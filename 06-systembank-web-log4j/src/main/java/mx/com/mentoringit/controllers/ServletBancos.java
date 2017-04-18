package mx.com.mentoringit.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.mentoringit.interfaces.IBancoService;
import mx.com.mentoringit.interfaces.IClienteService;
import mx.com.mentoringit.model.dto.BancoDTO;
import mx.com.mentoringit.model.dto.ClienteDTO;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;



@WebServlet("/bancos")
public class ServletBancos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBancos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		ApplicationContext applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());

		IBancoService bancosService = (IBancoService) applicationContext
				.getBean("bancoService");

		PrintWriter printWriter = response.getWriter();
		try {
			ArrayList<BancoDTO> bancos = bancosService.listarBancos();

			Gson gson = new Gson();
			printWriter.print("{'bancos':" + gson.toJson(bancos) + "}");
			printWriter.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
