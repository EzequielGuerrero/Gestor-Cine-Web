package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.Conexion;
import tablas.Peliculas;

import java.io.IOException;
import java.sql.SQLException;

public class insertPeli extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Conexion con;

	public insertPeli() {
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
			String nombre = request.getParameter("nombrePeli");
			String duracion = request.getParameter("duracion");
			String genero = request.getParameter("genero");
			String director = request.getParameter("director");
			String pegi = request.getParameter("pegi");
			String precio = request.getParameter("precio");

			Peliculas peliNueva = new Peliculas(0, nombre, Integer.parseInt(duracion), genero, director,
					Integer.parseInt(pegi), Double.parseDouble(precio));

			con.crearPeliculas(con.getConexion(), peliNueva);
			
			response.sendRedirect("PeliculasJSP.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
