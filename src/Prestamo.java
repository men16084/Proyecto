import java.time.LocalDate;

public class Prestamo {
	private int id;
	private int codigoLibro;
	private String nombreLibro;
	private int carne;
	private String nombreAlumno;
	private LocalDate prestado;
	private LocalDate vence;
	private boolean devuelto;

	/**
	 * @param id
	 * @param codigoLibro
	 * @param nombreLibro
	 * @param carne
	 * @param nombreAlumno
	 * @param prestado
	 * @param vence
	 * @param devuelto
	 */

	public Prestamo(){
	}

	public Prestamo(int id, int codigoLibro, String nombreLibro, int carne, String nombreAlumno, LocalDate prestado,
			LocalDate vence, boolean devuelto) {
		super();
		this.id = id;
		this.codigoLibro = codigoLibro;
		this.nombreLibro = nombreLibro;
		this.carne = carne;
		this.nombreAlumno = nombreAlumno;
		this.prestado = prestado;
		this.vence = vence;
		this.devuelto = devuelto;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodigoLibro() {
		return codigoLibro;
	}

	public void setCodigoLibro(int codigoLibro) {
		this.codigoLibro = codigoLibro;
	}

	public String getNombreLibro() {
		return nombreLibro;
	}

	public void setNombreLibro(String nombreLibro) {
		this.nombreLibro = nombreLibro;
	}

	public int getCarne() {
		return carne;
	}

	public void setCarne(int carne) {
		this.carne = carne;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public LocalDate getPrestado() {
		return prestado;
	}

	public void setPrestado(LocalDate prestado) {
		this.prestado = prestado;
	}

	public LocalDate getVence() {
		return vence;
	}

	public void setVence(LocalDate vence) {
		this.vence = vence;
	}

	public boolean isDevuelto() {
		return devuelto;
	}

	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}
	
	

}
