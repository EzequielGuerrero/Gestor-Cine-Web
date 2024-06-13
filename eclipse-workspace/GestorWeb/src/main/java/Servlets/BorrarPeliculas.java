
package Servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.Conexion;
import tablas.Peliculas;

import java.io.IOException;
import java.sql.SQLException;

public class BorrarPeliculas extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Conexion con;

	public BorrarPeliculas() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {

		con = new Conexion();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String numeroBoton = request.getParameter("peliID");

		try {
			con.eliminarPeliculas(con.getConexion(), new Peliculas(Integer.parseInt(numeroBoton)));

		} catch (NumberFormatException e) {

			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		response.sendRedirect("PeliculasJSP.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
