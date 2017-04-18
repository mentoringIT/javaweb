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

import mx.com.mentoringit.interfaces.IBancoService;
import mx.com.mentoringit.interfaces.IClienteService;
import mx.com.mentoringit.model.dto.BancoDTO;
import mx.com.mentoringit.model.dto.ClienteDTO;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;

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

		ApplicationContext applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());

		IClienteService clienteService = (IClienteService) applicationContext
				.getBean("clienteService");

		IBancoService bancoService = (IBancoService) applicationContext
				.getBean("bancoService");

		PrintWriter printWriter = response.getWriter();
		try {

			Gson gson = new Gson();

			ClienteDTO clienteDTO = gson.fromJson(request.getReader()
					.readLine(), ClienteDTO.class);
			boolean cliente = clienteService.guardarCliente(clienteDTO);

			if (cliente) {
				printWriter.print("{success:true}");
			} else {
				printWriter.print("{failure:true}");
			}

		} catch (Exception e) {
			e.printStackTrace();

			return;
		}

	}
}