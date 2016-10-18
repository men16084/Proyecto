/**
 * 
 */

/**
 * @author Max Méndez
 *
 */
public class AlumnosDBHandler {
	private String DB_NAME;
	private Alumno[] listaAlumnosArreglo;
	
	public AlumnosDBHandler() {
		public Alumno buscarAlumno(int carnet){
			int carnetAlumnoBuscado= carnet;
			Alumno AlumnoBuscado = null;
			for(int i=0;i<5;i++){
				if(listaAlumnosArreglo[i].getCarnet().equals(carnetAlumnoBuscado));
					AlumnoBuscado = newAlumno(listaAlumnosArreglo[i].getNombre(), listaAlumnosArreglo[i].getCarne(), listaAlumnosArreglo[i].getCarrera(), listaAlumnosArreglo[i].getAnio());
			}
			return AlumnoBuscado;
		}
	}
	