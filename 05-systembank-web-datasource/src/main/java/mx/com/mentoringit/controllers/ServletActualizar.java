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
import mx.com.mentoringit.interfaces.IClienteService;
import mx.com.mentoringit.model.dto.BancoDTO;
import mx.com.mentoringit.model.dto.ClienteDTO;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class ServletActualizar
 */
@WebServlet("/actualizar")
public class ServletActualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletActualizar() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int idcliente = Integer.parseInt(request.getParameter("idCliente"));

//		IClienteService clienteService = new ClienteServices();
		ApplicationContext applicationContext = 
				WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		
		IClienteService clienteService = 
				(IClienteService) applicationContext.getBean("clienteService");
		
		IBancoService bancoService = 
				(IBancoService) applicationContext.getBean("bancoService");

		try {

			ClienteDTO cliente = clienteService.buscarCliente(idcliente);
			ArrayList<BancoDTO> bancos = bancoService.listarBancos();

			request.setAttribute("cliente", cliente);
			request.setAttribute("bancos", bancos);

			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/nuevocliente.jsp");
			requestDispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
			return;
		}

	}
}