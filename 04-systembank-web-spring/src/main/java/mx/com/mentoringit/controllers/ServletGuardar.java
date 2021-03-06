package mx.com.mentoringit.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import mx.com.mentoringit.interfaces.IClienteService;
import mx.com.mentoringit.model.dto.ClienteDTO;

/**
 * Servlet implementation class ServletGuardar
 */
@WebServlet("/guardar")
public class ServletGuardar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletGuardar() {
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
		
		String nombre = request.getParameter("nombre");
		String apaterno = request.getParameter("apaterno");
		String amaterno = request.getParameter("amaterno");
		int edad = Integer.parseInt(request.getParameter("edad"));
		int idBanco = Integer.parseInt(request.getParameter("idBanco"));
		int idCliente = Integer.parseInt(request.getParameter("idCliente"));
		
		ClienteDTO clienteDTO = new ClienteDTO();
		
		clienteDTO.setAmaterno(amaterno);
		clienteDTO.setApaterno(apaterno);
		clienteDTO.setNombre(nombre);
		clienteDTO.setEdad(edad);
		clienteDTO.setIdCliente(idCliente);
		clienteDTO.setIdBanco(idBanco);
		
		ApplicationContext applicationContext = 
				WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		
		IClienteService clienteService = 
				(IClienteService) applicationContext.getBean("clienteService");
		
		try {
			if(clienteService.guardarCliente(clienteDTO)){
				
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
