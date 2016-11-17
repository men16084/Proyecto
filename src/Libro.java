
public class Libro {
	private int codigo;
	private String nombre;
	private String autor;
	private String edicion;
	private int anio;
	/**
	 * @param codigo
	 * @param nombre
	 * @param autor
	 * @param edicion
	 * @param anio
	 */
	public Libro(int codigo, String nombre, String autor, String edicion, int anio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.autor = autor;
		this.edicion = edicion;
		this.anio = anio;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEdicion() {
		return edicion;
	}
	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	
}
