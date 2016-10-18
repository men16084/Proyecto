import java.util.Date;

public class Prestamo {
	private int idPrestamo;
	private Alumno alumno;
	private Libro libro;
	private Date fecha;
	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	private boolean devuelto;
	/**
	 * @return the idPrestamo
	 */
	public int getIdPrestamo() {
		return idPrestamo;
	}
	/**
	 * @param idPrestamo the idPrestamo to set
	 */
	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}
	/**
	 * @return the alumno
	 */
	public Alumno getAlumno() {
		return alumno;
	}
	/**
	 * @param alumno the alumno to set
	 */
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	/**
	 * @return the libro
	 */
	public Libro getLibro() {
		return libro;
	}
	/**
	 * @param libro the libro to set
	 */
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	/**
	 * @return the fechaVencimiento
	 */
	/**
	 * @return the devuelto
	 */
	public boolean isDevuelto() {
		return devuelto;
	}
	/**
	 * @param devuelto the devuelto to set
	 */
	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}
	/**
	 * @return the lenght
	 */
	public static int getLenght() {
		return lenght;
	}
	/**
	 * @param lenght the lenght to set
	 */
	public static void setLenght(int lenght) {
		Prestamo.lenght = lenght;
	}
	public static int lenght;

}
