package tablas;

public class Cines {
	
	private String nombreCine;
	private String dirrecion;
	
	public Cines(String nombreCine, String dirrecion) {
		
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

}
