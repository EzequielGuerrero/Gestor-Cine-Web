package persistencia;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import tablas.Cines;
import tablas.Peliculas;
import tablas.Salas;

public class Conexion {

	private static final String URL = "jdbc:mysql://localhost:3306/tucine?user=root&password=eze";

	public Connection getConexion() throws SQLException {
		return DriverManager.getConnection(URL);
	}

	public void crearCines(Connection con, Cines cine) throws SQLException {

		PreparedStatement st = null;

		final String CONSULTA = "INSERT INTO cines (nombreCine, direccion) VALUES (?, ?)";

		try {
			con.setAutoCommit(false);
			st = con.prepareStatement(CONSULTA);
			st.setString(1, cine.getNombreCine());
			st.setString(2, cine.getDirecion());
			st.executeUpdate();
			con.commit();

		} catch (SQLException e) {

			e.printStackTrace();

			if (con != null) {
				con.rollback();
			}
		} finally {

			if (st != null) {
				st.close();
			}
		}
	}

	public static void crearPeliculas(Connection con, String titulo, int duracionMinutos, String genero,
			String director, int clasificacionEdad, int precio) throws SQLException {

		String consulta = "INSERT INTO peliculas (titulo, duracionMinutos, genero,director,clasificacionEdad,precio) VALUES ( ?,?, ?,?,?, ?)";

		try (PreparedStatement st = con.prepareStatement(consulta)) {

			con.setAutoCommit(false);

			st.setString(1, titulo);
			st.setInt(2, duracionMinutos);
			st.setString(3, genero);
			st.setString(4, director);
			st.setInt(5, clasificacionEdad);
			st.setInt(6, precio);

			st.executeUpdate();
			con.commit();
			System.out.println("Insert completado");

		} catch (SQLException e) {
			System.err.println("No se ha podido completar la operacion");
			e.printStackTrace();
			con.rollback();
		}

	}

	public static void crearSalas(Connection con, int capacidadPersonas, double superficie) throws SQLException {

		String consulta = "INSERT INTO salas (capacidad, metrosCuadrados) VALUES ( ?, ?)";

		try (PreparedStatement st = con.prepareStatement(consulta)) {

			con.setAutoCommit(false);

			st.setInt(1, capacidadPersonas);
			st.setDouble(2, superficie);

			st.executeUpdate();
			con.commit();
			System.out.println("Insert completado");

		} catch (SQLException e) {
			System.err.println("No se ha podido completar la operacion");
			e.printStackTrace();
			con.rollback();
		}
	}

	public void eliminarCines(Connection con, Cines cine) throws SQLException {

		String consultaEliminada = "Delete from cines where identificador = ?";

		try (PreparedStatement pst = con.prepareStatement(consultaEliminada)) {

			con.setAutoCommit(false);

			pst.setInt(1, cine.getID());

			pst.executeUpdate();
			con.commit();

			System.out.println("El cine ha sido eliminado");

		} catch (SQLException e) {
			System.err.println("No se ha podido completar la operacion");
			e.printStackTrace();
			con.rollback();
		}
	}

	public void modificarNombreCine(Connection con, Cines cine) throws SQLException {

		String consulta_Update = "UPDATE cines SET nombreCine = ? , direccion = ? WHERE identificador = ? ";

		try (PreparedStatement pst = con.prepareStatement(consulta_Update)) {

			con.setAutoCommit(false);

			pst.setString(1, cine.getNombreCine());
			pst.setString(2, cine.getDirecion());
			pst.setInt(3, cine.getID());

			pst.execute();
			con.commit();

			System.out.println("Modificacion realizada");

		} catch (SQLException e) {
			System.err.println("No se ha podido completar la operacion");
			e.printStackTrace();
			con.rollback();
		}
	}

	public List<String> leerCines(Connection con) throws SQLException {

		List<String> listaCines = new ArrayList<>();

		try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM cines")) {

			while (rs.next()) {
				int indice = rs.getInt("identificador");
				String nombre = rs.getString("nombreCine");
				String direccion = rs.getString("direccion");

				String datosCine = indice + "," + nombre + "," + direccion;
				listaCines.add(datosCine);
			}
		}

		return listaCines;
	}

	public void eliminarPeliculas(Connection con, Peliculas peli) throws SQLException {

		String consultaEliminada = "Delete from peliculas where identificador = ?";

		try (PreparedStatement pst = con.prepareStatement(consultaEliminada)) {

			con.setAutoCommit(false);

			pst.setInt(1, peli.getID());

			pst.executeUpdate();
			con.commit();

			System.out.println("La pelicula ha sido eliminada");

		} catch (SQLException e) {
			System.err.println("No se ha podido completar la operacion");
			e.printStackTrace();
			con.rollback();
		}
	}

	public void modificarNombrePeli(Connection con, Peliculas pelis) throws SQLException {

		String consulta_Update = "UPDATE peliculas SET titulo = ? WHERE identificador = ? ";

		try (PreparedStatement pst = con.prepareStatement(consulta_Update)) {

			con.setAutoCommit(false);

			pst.setString(1, pelis.getTitulo());
			pst.setInt(2, pelis.getID());

			pst.execute();
			con.commit();

			System.out.println("Modificacion realizada");

		} catch (SQLException e) {
			System.err.println("No se ha podido completar la operacion");
			e.printStackTrace();
			con.rollback();
		}
	}

	public List<String> leerPeliculas(Connection con) {

		List<String> listaPeliculas = new ArrayList<String>();

		try (Statement st = con.createStatement();) {

			ResultSet rs = st.executeQuery("Select * from peliculas");

			while (rs.next()) {

				int indice = rs.getInt(1);
				String nombre = rs.getString(2);
				int duracion = rs.getInt(3);
				String genero = rs.getString(4);
				String director = rs.getString(5);
				int pegi = rs.getInt(6);
				int precio = rs.getInt(7);

				String lista = indice + "," + nombre + "," + duracion + "," + genero + "," + director + "," + pegi + ","
						+ precio;

				listaPeliculas.add(lista);

			}

		} catch (SQLException e) {

			System.err.println("No se a podido leer la tabla");
			e.printStackTrace();
		}
		return listaPeliculas;

	}

	public void eliminarSalas(Connection con, Salas sala) throws SQLException {

		String consultaEliminada = "Delete from salas where identificador = ?";

		try (PreparedStatement pst = con.prepareStatement(consultaEliminada)) {

			con.setAutoCommit(false);

			pst.setInt(1, sala.getIdentificador());

			pst.executeUpdate();
			con.commit();

			System.out.println("La sala ha sido eliminada");

		} catch (SQLException e) {
			System.err.println("No se ha podido completar la operacion");
			e.printStackTrace();
			con.rollback();
		}
	}

	public List<String> leerSalas(Connection con) {

		List<String> listaSalas = new ArrayList<String>();

		try {

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("Select * from salas");

			while (rs.next()) {

				int indice = rs.getInt(1);
				int capacidad = rs.getInt(2);
				int metros = rs.getInt(3);

				String lista = indice + "," + capacidad + "," + metros;

				listaSalas.add(lista);

			}
		} catch (SQLException e) {

			System.err.println("Las salas no se han podido consultar");
			e.printStackTrace();
		}
		return listaSalas;

	}

	public void modificarSalas(Connection con, Salas sala) throws SQLException {

		String consulta = "UPDATE salas SET capacidad = ?, metrosCuadrados = ? WHERE identificador = ?";

		try {
			con.setAutoCommit(false);

			PreparedStatement pst = con.prepareStatement(consulta);

			pst.setInt(1, sala.getCapacidad());
			pst.setDouble(2, sala.getMetrosCuadrados());
			pst.setInt(3, sala.getIdentificador());

			pst.executeUpdate();
			con.commit();

			System.out.println("Actualizacion realizada");

		} catch (SQLException e) {
			System.err.println("La actualizacion no se ha podido realizar");
			con.rollback();
			e.printStackTrace();

		}
	}

}
