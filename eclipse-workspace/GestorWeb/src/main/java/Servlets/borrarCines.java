package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.Conexion;
import tablas.Cines;

import java.io.IOException;
import java.sql.SQLException;

public class borrarCines extends HttpServlet {

	private Conexion con;

	private static final long serialVersionUID = 1L;

	public borrarCines() {
		super();

	}

	@Override
	public void init() throws ServletException {
		super.init();

		con = new Conexion();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String valorDelete = request.getParameter("cineId");
						
		try {
			con.eliminarCines(con.getConexion(), new Cines(Integer.parseInt(valorDelete)));
			
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
