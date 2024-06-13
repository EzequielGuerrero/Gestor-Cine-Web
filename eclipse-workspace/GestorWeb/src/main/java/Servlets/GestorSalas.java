package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.Conexion;
import tablas.Salas;

import java.io.IOException;
import java.sql.SQLException;

public class GestorSalas extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Conexion con;

	public GestorSalas() {
		super();
	}

	public void init() throws ServletException {
		super.init();

		con = new Conexion();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idSala = request.getParameter("salaId");

		try {
			con.eliminarSalas(con.getConexion(), new Salas(Integer.parseInt(idSala)));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		response.sendRedirect("SalasJSP.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
