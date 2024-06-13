package Servlets;

import jakarta.servlet.ServletConfig;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.Conexion;
import java.io.IOException;
import java.sql.SQLException;

import tablas.Cines;

public class ModificarCines extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Conexion con;

	public ModificarCines() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init();
		con = new Conexion();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			try {
			
			int idCineMod =Integer.parseInt(request.getParameter("cineId"));
			
			
			String nombreCineMod = request.getParameter("nuevoNombreCine");
			String nombreDirrecionMod = request.getParameter("nuevaDireccionCine");

			Cines cineMod = new Cines(idCineMod, nombreCineMod, nombreDirrecionMod);
			con.modificarNombreCine(con.getConexion(), cineMod);

			response.sendRedirect("CinesJSP.jsp");

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
