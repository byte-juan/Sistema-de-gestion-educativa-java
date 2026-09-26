package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    public Connection conexion;
    private final String JDBC_DRIVER = "org.sqlite.JDBC";
    private final String NOMBRE_DB = "dbsistemaescolar.db";
    private final String DB_URL = "jdbc:sqlite:" + NOMBRE_DB;

    public void conectar() {
        try {
            Class.forName(JDBC_DRIVER);
            conexion = DriverManager.getConnection(DB_URL);
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void cerrar() throws SQLException {
        if (conexion != null) {
            if (!conexion.isClosed()) {
                conexion.close();
            }

        }
    }

}



