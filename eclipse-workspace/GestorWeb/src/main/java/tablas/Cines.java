package tablas;

public class Cines {

	private String nombreCine;
	private String dirrecion;
	final private int ID;

	public Cines(int ID, String nombreCine) {

		this.ID = ID;
		this.setNombreCine(nombreCine);

	}

	public Cines(String nombreCine, String dirrecion) {

		this.ID = 0;
		this.setNombreCine(nombreCine);
		this.setDirrecion(dirrecion);

	}

	public String getNombreCine() {
		return nombreCine;
	}

	public void setNombreCine(String nombreCine) {
		this.nombreCine = nombreCine;
	}

	public String getDirrecion() {
		return dirrecion;
	}

	public void setDirrecion(String dirrecion) {
		this.dirrecion = dirrecion;
	}

	public String toString() {
		return "Cines [nombreCine=" + nombreCine + ", dirrecion=" + dirrecion + "]";
	}

	public int getID() {
		return ID;
	}

}
