package tablas;

public class Cines {

	private String nombreCine;
	private String dirrecion;
	private int ID;

	public Cines(int ID) {

		this.ID = ID;

	}

	public Cines(int ID, String nombreCine, String dirrecion) {

		this.ID = ID;
		this.setNombreCine(nombreCine);
		this.setDirecion(dirrecion);

	}

	public String getNombreCine() {
		return nombreCine;
	}

	public void setNombreCine(String nombreCine) {
		this.nombreCine = nombreCine;
	}

	public String getDirecion() {
		return dirrecion;
	}

	public void setDirecion(String dirrecion) {
		this.dirrecion = dirrecion;
	}

	public String toString() {
		return "Cines [nombreCine=" + nombreCine + ", dirrecion=" + dirrecion + "]";
	}

	public int getID() {
		return ID;
	}

}
