package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.Conexion;
import tablas.Cines;

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

			Cines cineIntroducido = new Cines(nombre, direccion);

			con.crearCines(con.getConexion(), cineIntroducido);

			// Tengo que mirar que no llame a los dos metodos a la vez

			/*String indiceEliminado = request.getParameter("eliminarCineId");
			con.eliminarCines(con.getConexion(), Integer.parseInt(indiceEliminado));*/

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
