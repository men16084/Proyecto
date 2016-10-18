import java.util.Date;

public class PrestamoDBHandler {
	private String DB_NAME;
	private String DB_PRESTAMOS_TABLE;
	private String DB_CREATE_TABLES;
	private Alumno alumno;
	private Libro libro;
	private Date fecha;
	private int carnet;
	private Prestamo[] prestamos;
	private int ID;
	
public int ingresarPrestamo (Alumno alumno, Libro libro, Date fecha){
	for (int i=0; )
	return fechaVencimiento;
	}
public Prestamo BuscarPrestamos ( int carnet){
	for( int i=0; i<prestamos.length; i++){
		if (prestamos[i].getLibro().equals(libro) && prestamos[i].getFecha().equals(fecha) && prestamos[i].getAlumno().getCarnet()== carnet)
				{
			return prestamos[i];
				}
	}return null;
}
public Prestamo BuscarPrestamosLibro ( int ID){
	for( int i=0; i<prestamos.length; i++){
		if (prestamos[i].getFecha().equals(fecha) && prestamos[i].getIdPrestamo()&& prestamos[i].getAlumno().getCarnet()== carnet)
				{
			return prestamos[i];
				}
	}return null;
}

