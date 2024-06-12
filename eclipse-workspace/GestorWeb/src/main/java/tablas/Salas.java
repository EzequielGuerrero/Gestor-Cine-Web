package tablas;

public class Salas {

	private final int identificador;
	private int capacidad;
	private double metrosCuadrados;

	public Salas(int identificador, int capacidad, double metrosCuadrados) {
		
		this.identificador = identificador;
		this.setCapacidad(capacidad);
		this.setMetrosCuadrados(metrosCuadrados);
	}
	
	public Salas(int identificador) {
		
		this.identificador=identificador;
	}

	public int getIdentificador() {
		return identificador;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public double getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public void setMetrosCuadrados(double metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

	public String toString() {
		return "Salas [identificador=" + identificador + ", capacidad=" + capacidad + ", metrosCuadrados="
				+ metrosCuadrados + "]";
	}

}
