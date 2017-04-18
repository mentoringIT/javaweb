package mx.com.mentoringit.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.mentoringit.interfaces.IClienteService;
import mx.com.mentoringit.model.dto.ClienteDTO;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;

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

		String cteJSON = request.getReader().readLine();
		System.out.println(cteJSON);

		ApplicationContext applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());

		IClienteService clienteService = (IClienteService) applicationContext
				.getBean("clienteService");

		PrintWriter printWriter = response.getWriter();
		ClienteDTO clienteDTO = new Gson().fromJson(cteJSON, ClienteDTO.class);
		try {
			if (clienteService.eliminarCliente(clienteDTO.getIdCliente())) {
				printWriter.print("{success:true}");
			} else {
				printWriter.print("{failure:true}");
			}
		} catch (Exception e) {
			e.printStackTrace();
			printWriter.print("{failure:true}");
		}

		printWriter.close();

	}
}