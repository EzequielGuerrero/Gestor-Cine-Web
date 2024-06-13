package Servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.Conexion;
import tablas.Cines;
import tablas.Peliculas;

import java.io.IOException;
import java.sql.SQLException;

public class ModificarPeliculas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Conexion con;

	public ModificarPeliculas() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {
		super.init();

		con = new Conexion();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			int idPeliMod = Integer.parseInt(request.getParameter("peliId"));
			String nombrePeliMod = request.getParameter("nuevoNombrePeli");

			Peliculas pelisMod = new Peliculas(idPeliMod, nombrePeliMod);

			con.modificarNombrePeli(con.getConexion(), pelisMod);

			response.sendRedirect("PeliculasJSP.jsp");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
