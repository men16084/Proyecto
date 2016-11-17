/**
 * @author Max M�ndez
 *
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.sql.*;
import java.util.Vector;

public class PrestamoDBHandler {
    private String crear;
    private String eliminar;
    private Statement st;
    private DBConnection con;

    public PrestamoDBHandler() {
        this.crear = "";
        this.eliminar = "";
        this.st = null;
        this.con = new DBConnection();
    }


    public ArrayList<Prestamo> buscarprestamos(int carnet, int codigo) {
        String sql, sql2;
        if(codigo==0) {
            sql = "SELECT * FROM Prestamo p " +
                    "INNER JOIN Alumnos a ON p.Carnet = a.CarnetA " +
                    "INNER JOIN Libros l ON p.Codigo = l.CodigoL " +
                    "WHERE p.Carnet = " + carnet;
        }else if(carnet==0){
            sql = "SELECT * FROM Prestamo p " +
                    "INNER JOIN Alumnos a ON p.Carnet = a.CarnetA " +
                    "INNER JOIN Libros l ON p.Codigo = l.CodigoL " +
                    "WHERE p.Codigo = " + codigo;
        }else{
            sql = "SELECT * FROM Prestamo p " +
                    "INNER JOIN Alumnos a ON p.Carnet = a.CarnetA " +
                    "INNER JOIN Libros l ON p.Codigo = l.CodigoL " +
                    "WHERE p.Codigo = " + codigo + " AND p.Carnet = " + carnet;
        }
        ArrayList<Prestamo> listaPrestamos = new ArrayList<Prestamo>();
        try {
            st = con.getConn().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Prestamo tempPrest = new Prestamo();
                tempPrest.setId(rs.getInt("id"));
                tempPrest.setNombreAlumno(rs.getString("NombreA"));
                tempPrest.setCarne(rs.getInt("Carnet"));
                tempPrest.setCodigoLibro(rs.getInt("Codigo"));
                tempPrest.setNombreLibro(rs.getString("NombreL"));


                tempPrest.setDevuelto(rs.getBoolean("Devuelto"));

                final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                tempPrest.setPrestado(LocalDate.parse(rs.getString("PrestadoEn"), dtf));
                tempPrest.setPrestado(LocalDate.parse(rs.getString("DevueltoEn"), dtf));

                //SACAR TODO DE LA BASE DE DATOS
                listaPrestamos.add(tempPrest);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaPrestamos;

    }

    public void insertarPrestamo(int carnet, int codigo, String prestadoen, String devueltoen, int devuelto) {
        try {
            st = con.getConn().createStatement();
            String sql = "Insert into Prestamo (Carnet, Codigo, PrestadoEn, DevueltoEn, Devuelto) values ("+ carnet + "," + codigo + ",\"" + prestadoen + "\",\"" + devueltoen + "\"," + devuelto + ")";
            st.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void borrarTodosLosPrestamos() {
        try {
            st = con.getConn().createStatement();
            String sql = "DELETE FROM Prestamo";
            st.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Prestamo> getAllPrestamo(int tipoBusqueda, int carnet, int codigo) {
        String consulta = "";
        switch (tipoBusqueda) {
            case 0:
                consulta = "SELECT * FROM Prestamo";
                break;
            case 1:
                consulta = "select * from Prestamo where Carnet = " + carnet;
                break;
            case 2:
                consulta = "select * from Prestamo where codigo = " + codigo;
                break;
            case 3:
                consulta = "select * from Prestamo where Carnet = " + carnet + " and Codigo =" + codigo;
                break;
        }
    try{
        st = con.getConn().createStatement();
        ResultSet rs = st.executeQuery(consulta);
    }catch (Exception e){

    }
    return null;
    }




    public static void main(String[] args){
        PrestamoDBHandler dbPrestamo = new PrestamoDBHandler();
        //dbPrestamo.insertarPrestamo(16456, 10013,"25/12/2016","16/12/2016",1);

        System.out.println(dbPrestamo.buscarprestamos(16456,10013).get(0).getNombreLibro());
    }
}