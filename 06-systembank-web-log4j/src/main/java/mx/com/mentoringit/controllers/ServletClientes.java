package mx.com.mentoringit.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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

@WebServlet("/clientes")
public class ServletClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletClientes() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = null;

		ApplicationContext applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());

		IClienteService clienteService = (IClienteService) applicationContext
				.getBean("clienteService");

		PrintWriter printWriter = response.getWriter();
		try {
			ArrayList<ClienteDTO> clientes = clienteService.listarClientes();

			Gson gson = new Gson();

			printWriter.print("{'clientes':" + gson.toJson(clientes) + "}");
			printWriter.close();

		} catch (Exception e) {
			e.printStackTrace();
			requestDispatcher = request.getRequestDispatcher("error.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
