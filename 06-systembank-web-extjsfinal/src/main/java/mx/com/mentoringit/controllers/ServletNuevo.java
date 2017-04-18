package mx.com.mentoringit.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.mentoringit.interfaces.IBancoService;
import mx.com.mentoringit.model.dto.BancoDTO;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


@WebServlet("/nuevo")
public class ServletNuevo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletNuevo() {
        super();
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher =null;
	
		ApplicationContext applicationContext = 
				WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		
		IBancoService bancoService = 
				(IBancoService) applicationContext.getBean("bancoService");

		try {
			
			ArrayList<BancoDTO> bancos = bancoService.listarBancos();
			
			requestDispatcher = request.getRequestDispatcher("nuevocliente.jsp");
			request.setAttribute("bancos", bancos);
		} catch (Exception e) {
			e.printStackTrace();
			requestDispatcher = request.getRequestDispatcher("error.jsp");
		}
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
