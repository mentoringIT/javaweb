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

import mx.com.mentoringit.interfaces.IUsuarioService;
import mx.com.mentoringit.model.dto.UsuarioDTO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

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

		final Logger logger = LogManager.getLogger(ServletLogin.class);
		
		logger.info("user logged: " + usuario);
		
		ApplicationContext applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
		IUsuarioService usuarioService = (IUsuarioService) applicationContext.getBean("usuarioService");
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setUsuario(usuario);
		usuarioDTO.setPassword(password);

		RequestDispatcher requestDispatcher;
		PrintWriter printWriter = response.getWriter();
		try {

			Properties properties = new Properties();

			properties.load(getServletContext().getClassLoader()
					.getResourceAsStream("/messages.properties"));
			
			UsuarioDTO userLogged = usuarioService.login(usuarioDTO);
			if (userLogged != null) {
				// regreso la pagina de administracion
				HttpSession session = request.getSession();
				session.setAttribute("user", userLogged.getNombre());
				
				printWriter.print("{'success':true}");
				
			} else {
				// le regreso un msg de que no se autentico correctamente
				printWriter.print("{'success':false}");
			}
		} catch (Exception e) {
			logger.debug("error al autenticar: " + e);
			printWriter.print("{'success':false}");
		}
		printWriter.close();
	}
}
