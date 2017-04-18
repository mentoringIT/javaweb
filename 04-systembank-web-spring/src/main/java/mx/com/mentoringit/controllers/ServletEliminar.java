package mx.com.mentoringit.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.mentoringit.interfaces.IClienteService;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class ServletEliminar
 */
@WebServlet("/eliminar")
public class ServletEliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletEliminar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int idCliente = Integer.parseInt(request.getParameter("idCliente"));

		ApplicationContext applicationContext = 
				WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		
		IClienteService clienteService = 
				(IClienteService) applicationContext.getBean("clienteService");
		
		try {
			if(clienteService.eliminarCliente(idCliente)){
				
			}else{
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("error.jsp");
				requestDispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		response.sendRedirect("clientes");
	}
}