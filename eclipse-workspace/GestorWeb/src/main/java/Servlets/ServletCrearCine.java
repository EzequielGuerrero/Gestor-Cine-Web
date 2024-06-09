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

		// Propiedades para saber que el boton que se esta pulsando es el de crear cine:

		final String BOTONCREAR = request.getParameter("botonCine");
		final String VALOR_CREAR = "botonCrearCine";

		// Ahora lo mismo pero para eliminar el cine:

		final String BOTON_BORRAR = request.getParameter("botonEliminar");
		final String VALOR_BORRAR = "eliminarCine";

		// Lo mismo pero para saber que se pulsa el modificar:

		final String BOTON_ACTUALIZAR = request.getParameter("actualizarCine");
		final String VALOR_ACTUALIZAR = "actualizador";

		if (VALOR_CREAR.equals(BOTONCREAR) || BOTONCREAR != null) {

			String nombre = request.getParameter("nombreCine");
			String direccion = request.getParameter("direccionCine");

			Cines cineIntroducido = new Cines(nombre, direccion);

			try {
				con.crearCines(con.getConexion(), cineIntroducido);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else if (VALOR_BORRAR.equals(BOTONCREAR) || BOTON_BORRAR != null) {

			String indiceEliminado = request.getParameter("eliminarCineId");
			
			Cines cineEliminado = new Cines(Integer.parseInt(indiceEliminado), null);

			try {
				con.eliminarCines(con.getConexion(), cineEliminado);

			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else if (VALOR_ACTUALIZAR.equals(BOTON_BORRAR) || BOTON_ACTUALIZAR != null) {

			String idCine = request.getParameter("cineId");
			String nuevoNombre = request.getParameter("nuevoNombre");
			
			Cines cinesMod = new Cines(Integer.parseInt(idCine), nuevoNombre);

			try {

				con.modificarNombreCine(con.getConexion(), cinesMod);

			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
