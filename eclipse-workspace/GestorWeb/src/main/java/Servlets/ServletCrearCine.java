package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.Conexion;

import java.io.IOException;
import java.sql.SQLException;

public class ServletCrearCine extends HttpServlet {

	private Conexion con;

	private static final long serialVersionUID = 1L;

	public ServletCrearCine() {
		super();

	}

	@Override
	public void init() throws ServletException {
		super.init();

		con = new Conexion();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String nombre = request.getParameter("nombreCine");
			String direccion = request.getParameter("direccionCine");

			con.crearCines(con.getConexion(), nombre, direccion);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
