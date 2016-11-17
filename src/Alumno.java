
public class Alumno {
	private int carne;
	private String nombre;
	private String carrera;
	private int anio;
	/**
	 * @param carne
	 * @param nombre
	 * @param carrera
	 * @param anio
	 */
	public Alumno(int carne, String nombre, String carrera, int anio) {
		super();
		this.carne = carne;
		this.nombre = nombre;
		this.carrera = carrera;
		this.anio = anio;
	}
	public int getCarne() {
		return carne;
	}
	public void setCarne(int carne) {
		this.carne = carne;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}

}