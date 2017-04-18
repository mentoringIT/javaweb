package mx.com.mentoringit.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import mx.com.mentoringit.interfaces.IUsuarioService;
import mx.com.mentoringit.model.dto.UsuarioDTO;

/**
 * Servlet implementation class ServletLogin
 */
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogin() {
		super();
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/systembank");
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}

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

		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");

		// IUsuarioService usuarioService = new UsuarioService();

		ApplicationContext applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
		IUsuarioService usuarioService = (IUsuarioService) applicationContext.getBean("usuarioService");
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setUsuario(usuario);
		usuarioDTO.setPassword(password);

		RequestDispatcher requestDispatcher;
		try {

			Properties properties = new Properties();

			properties.load(getServletContext().getClassLoader()
					.getResourceAsStream("/messages.properties"));
			UsuarioDTO userLogged = usuarioService.login(usuarioDTO);
			if (userLogged != null) {
				// regreso la pagina de administracion
				HttpSession session = request.getSession();
				session.setAttribute("user", userLogged.getNombre());
				response.sendRedirect("admin.jsp"); // http://localhost:8080/systembank-web/admin.jsp
			} else {
				// lo regreso al login
				requestDispatcher = getServletContext().getRequestDispatcher(
						"/loginfail.jsp");
				PrintWriter out = response.getWriter();
				out.println("<font color=red> "
						+ properties.getProperty("loginFail") + "</font>");
				requestDispatcher.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}
}
