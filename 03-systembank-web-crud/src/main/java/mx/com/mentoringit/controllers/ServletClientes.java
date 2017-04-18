package mx.com.mentoringit.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.mentoringit.model.dto.ClienteDTO;
import mx.com.mentoringit.services.ClienteServices;


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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher =null;
	
		try {
			ArrayList<ClienteDTO> clientes = new ClienteServices().listarClientes();
			
			requestDispatcher = request.getRequestDispatcher("clientes.jsp");
			request.setAttribute("clientes", clientes);
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
