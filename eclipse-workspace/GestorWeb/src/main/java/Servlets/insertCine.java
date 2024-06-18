package Servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.Conexion;
import tablas.Cines;

import java.io.IOException;
import java.sql.SQLException;

public class insertCine extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Conexion con;

	public insertCine() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {

		con = new Conexion();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String nombreCineNew = request.getParameter("nuevoNombreCineInsert");
			String direccionNew = request.getParameter("nuevaDireccionCine");

			Cines cineCreado = new Cines(nombreCineNew, direccionNew);
			
			con.crearCines(con.getConexion(), cineCreado);
			
			response.sendRedirect("CinesJSP.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
