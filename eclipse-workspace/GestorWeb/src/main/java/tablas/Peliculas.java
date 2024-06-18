package tablas;

public class Peliculas {

	private final int identificador;
	private String titulo;
	private int duracionMinutos;
	private String genero;
	private String director;
	private int clasificacionEdad;
	private double precio;
	
	public Peliculas (int id) {
		
		this.identificador=id;
	}
	
	public Peliculas (int id, String nuevoNombre) {
		
		identificador = id;
		titulo=nuevoNombre;
	}

	public Peliculas(int identificador, String titulo, int duracionMinutos, String genero, String director,
			int clasificacionEdad, double precio) {

		this.identificador = identificador;
		this.titulo = titulo;
		this.duracionMinutos = duracionMinutos;
		this.genero = genero;
		this.director = director;
		this.clasificacionEdad = clasificacionEdad;
		this.precio = precio;
	}
	


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDuracionMinutos() {
		return duracionMinutos;
	}

	public void setDuracionMinutos(int duracionMinutos) {
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

	public int getClasificacionEdad() {
		return clasificacionEdad;
	}

	public void setClasificacionEdad(int clasificacionEdad) {
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
