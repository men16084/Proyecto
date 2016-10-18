/**
 * 
 */

/**
 * @author Max Méndez
 *
 */
public class LibrosDBHandler {
	private String DB_NAME;
	private Libro[] listaLibrosArreglo;
	
	public LibrosDBHandler() {
		public Libro buscarLibro(int Id){
			int IdLibroBuscado= Id;
			Libro LibroBuscado = null;
			for(int i=0;i<5;i++){
				if(listaLibrosArreglo[i].getCarnet().equals(IdLibroBuscado));
					LibroBuscado = newAlumno(listaLibrosArreglo[i].getNombre(), listaLibrosArreglo[i].getId(), listaLibrosArreglo[i].getCarrera(), listaLibrosArreglo[i].getAnio());
			}
			return LibroBuscado;
		}
}
