/**
 * Created by Max Méndez on 23/10/2016.
 */

import java.sql.*;

public class DBConnection {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    //static final String DB_URL = "jdbc:mysql://localhost/Users/Max Méndez/Documents/U/Segundo ciclo/Programación orientada a objetos/Proyecto/Biblioteca/Base de Datos";
    static final String DB_URL = "jdbc:mysql://localhost/mydb";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";
    private Connection conn;

    public void BDConexion(){
        conn = null;
        Statement stmt = null;
        try{
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //stem.out.println("Creating statement...");
            /*stmt = conn.createStatement();
            String sql;
            /*
            ResultSet rs = stmt.executeQuery(sql);
            rs.close();
            stmt.close();
            conn.close();*/
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            /*try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try*/
        }//end try
        System.out.println("Goodbye!");
    }//end main

    public Connection getConn(){
        if (conn == null)
            BDConexion();
        return conn;
    }
}//end FirstExample
