
/**
 * @author Max M�ndez
 *
 */

import java.sql.*;


public class AlumnosDBHandler {
	private boolean existe = false;
	private Statement st;
	private DBConnection con;

	public AlumnosDBHandler(boolean existe, Statement st, DBConnection con) {
		this.existe = existe;
		this.st = st;
		this.con = con;
	}

	public boolean buscaralumno(int carnet) {

		try {
			st = con.getConn().createStatement();
			String sql = "SELECT Carnet values ("+ carnet + ") from Alumnos";
			st.execute(sql);

			if (sql != null) {
				existe = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return existe;
	}

}

