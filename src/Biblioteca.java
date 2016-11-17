import java.util.ArrayList;

public class Biblioteca {
	
	private ArrayList<Prestamo> prestamos;
	private Libro[] libros;
	private Alumno[] alumnos;
	
	public Biblioteca(){
		prestamos = new ArrayList<Prestamo>();
		
		libros = new Libro[5];
		alumnos = new Alumno[5];
		llenarLista();
	}
	
	public void llenarLista(){
		libros[0] = new Libro(11111, "Calculo Quantico", "Roberto Rob", "1 Edicion", 2000);
		libros[1] = new Libro(11112, "Fisica Molecular", "Maria Magdalena", "2 Edicion", 2005);
		libros[2] = new Libro(11113, "Quimica Organica", "Stuart Lenon", "1 Edicion", 2010);
		libros[3] = new Libro(11114, "Matematica Espacial", "Ramirez Fuentes", "4 Edicion", 2002);
		libros[4] = new Libro(11115, "Literatura Moderna", "Fernando G.", "1 Edicion", 2016);
		
		alumnos[0] = new Alumno(15111, "Juan Juanito", "Electronica", 4);
		alumnos[1] = new Alumno(15112, "Manuel Manito", "Ingenieria Quimica", 4);
		alumnos[2] = new Alumno(15113, "Luis Gomez", "Industrial", 2);
		alumnos[3] = new Alumno(15114, "Roberta Cifuentes", "Matematica", 3);
		alumnos[4] = new Alumno(15115, "Maria Nopales", "Alimentos", 1);
	}
	
	public Alumno buscarCarne(int carne){
		Alumno alumno = null;
		for(int i=0; i<alumnos.length; i++){
			if(alumnos[i].getCarne() == carne){
				alumno = alumnos[i];
				break;
			}
		}
		return alumno;
	}
	
	public Libro buscarLibro(int codigo){
		Libro libro = null;
		for(int i=0; i<libros.length; i++){
			if(libros[i].getCodigo() == codigo){
				libro = libros[i];
				break;
			}
		}
		return libro;
	}
	
	public boolean isLibroPrestado(int codigo){
		for(int i=0;i<prestamos.size();i++){
			if(prestamos.get(i).getCodigoLibro() == codigo && !prestamos.get(i).isDevuelto()){
				return true;
			}
		}
		return false;
	}

	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}
	
	public void agregarPrestamo(Prestamo prestamo){
		prestamos.add(prestamo);
	}

	public void setPrestamos(ArrayList<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}
	
	
}
