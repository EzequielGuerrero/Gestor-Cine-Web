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

public class ModificarSalas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Conexion con;

	public ModificarSalas() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {

		super.init();

		con = new Conexion();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			String salaID=request.getParameter("salasID");
			String capacidadSala = request.getParameter("capacidadNueva");
			String metrosCua = request.getParameter("nuevosMetros");
			
			con.modificarSalas(con.getConexion(),
					new Salas(Integer.parseInt(salaID), Integer.parseInt(capacidadSala), Integer.parseInt(metrosCua)));
			
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
