/**
 * @author Max M�ndez
 *
 */

import java.sql.*;


public class LibrosDBHandler {
    private boolean existe = false;
    private Statement st;
    private DBConnection con;

    public LibrosDBHandler(boolean existe, Statement st, DBConnection con) {
        this.existe = existe;
        this.st = st;
        this.con = con;
    }

    public boolean buscarlibro(int codigo) {

        try {
            st = con.getConn().createStatement();
            String sql = "SELECT Codigo values ("+ codigo + ") from Libro";
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

