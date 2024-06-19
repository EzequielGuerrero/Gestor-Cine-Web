package Servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.Conexion;
import tablas.Salas;

import java.io.IOException;
import java.sql.SQLException;

public class insertSalas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Conexion con;

	public insertSalas() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {

		con = new Conexion();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String capacidadNueva = request.getParameter("capacidad");
			String metrosNuevos = request.getParameter("metrosCuadrados");
			
			Salas salaInsert = new Salas(Integer.parseInt(capacidadNueva), Double.parseDouble(metrosNuevos));
			
			con.crearSalas(con.getConexion(), salaInsert);
			
			response.sendRedirect("SalasJSP.jsp");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
