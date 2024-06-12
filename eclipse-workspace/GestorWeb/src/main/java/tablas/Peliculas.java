package tablas;

public class Peliculas {

	private final int identificador;
	private String titulo;
	private String duracionMinutos;
	private String genero;
	private String director;
	private String clasificacionEdad;
	private double precio;

	public Peliculas(int identificador, String titulo, String duracionMinutos, String genero, String director,
			String clasificacionEdad, double precio) {

		this.identificador = identificador;
		this.titulo = titulo;
		this.duracionMinutos = duracionMinutos;
		this.genero = genero;
		this.director = director;
		this.clasificacionEdad = clasificacionEdad;
		this.precio = precio;
	}
	
	public Peliculas (int id) {
		
		this.identificador=id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDuracionMinutos() {
		return duracionMinutos;
	}

	public void setDuracionMinutos(String duracionMinutos) {
		this.duracionMinutos = duracionMinutos;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getClasificacionEdad() {
		return clasificacionEdad;
	}

	public void setClasificacionEdad(String clasificacionEdad) {
		this.clasificacionEdad = clasificacionEdad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String toString() {
		return "Peliculas [titulo=" + titulo + ", duracionMinutos=" + duracionMinutos + ", genero=" + genero
				+ ", director=" + director + ", clasificacionEdad=" + clasificacionEdad + ", precio=" + precio + "]";
	}

	public int getID() {
		return identificador;
	}

}
