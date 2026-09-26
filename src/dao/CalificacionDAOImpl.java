package dao;

import interfaces.CalificacionDAO;
import modelo.Calificacion;
import db.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CalificacionDAOImpl extends Conexion implements CalificacionDAO {

    @Override
    public void registrar (Calificacion calificacion) throws Exception {
        String sql = "INSERT INTO calificacion (estudiante_id, asignatura_id, profesor_id, nota) VALUES (?, ?, ?, ?)";

        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);

            ps.setInt(1, calificacion.getEstudianteId());
            ps.setInt(2, calificacion.getAsignaturaId());
            ps.setInt(3, calificacion.getProfesorId());
            ps.setDouble(4, calificacion.getNota());

            ps.executeUpdate();
            ps.close();

            System.out.println("¡Calificación registrada con éxito!");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Error en el catch de CalificacionesDAOimpl");
        
        } finally {
            
            this.cerrar();
        }
    }

    @Override
    public void modificar(Calificacion calificacion) throws Exception {
        String sql = "UPDATE calificacion SET estudiante_id=?, asignatura_id=?, profesor_id=?, nota=? WHERE id=?";

        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);

            ps.setInt(1, calificacion.getEstudianteId());
            ps.setInt(2, calificacion.getAsignaturaId());
            ps.setInt(3, calificacion.getProfesorId());
            ps.setDouble(4, calificacion.getNota());
            ps.setInt(5, calificacion.getId());

            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrar();
        
        }
    }
    

    @Override
    public void eliminar(int calificacionId) throws Exception {
        String sql = "DELETE FROM calificacion WHERE id=?";
        // Esta línea limpia el contador autoincrementable de SQLite al borrar, tal como hace el original
        String sql2 = "UPDATE sqlite_sequence SET seq=0 WHERE name ='calificacion'";

        try {
            this.conectar(); // 1. Despierta la conexión heredada
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            PreparedStatement ps2 = this.conexion.prepareStatement(sql2);
            
            ps.setInt(1, calificacionId);
            ps.executeUpdate();
            ps.close(); // 2. Cierra el statement manualmente
            
            ps2.executeUpdate();
            ps2.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrar(); // 3. Cierra el canal de datos pase lo que pase
        }
    }

    @Override
    public List<Calificacion> listar() throws Exception {
        List<Calificacion> lista = new ArrayList<>();

        String sql = "SELECT * FROM calificacion";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Calificacion c = new Calificacion();

                c.setId(rs.getInt("id"));
                c.setEstudianteId(rs.getInt("estudiante_id"));
                c.setAsignaturaId(rs.getInt("asignatura_id"));
                c.setProfesorId(rs.getInt("profesor_id"));
                c.setNota(rs.getDouble("nota"));

                lista.add(c);
            }
        }

        return lista;
    }

    @Override
    public Calificacion obtenerCalificacionPorId(int calificacionId) throws Exception {
        String sql = "SELECT * FROM calificacion WHERE id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, calificacionId);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    Calificacion c = new Calificacion();

                    c.setId(rs.getInt("id"));
                    c.setEstudianteId(rs.getInt("estudiante_id"));
                    c.setAsignaturaId(rs.getInt("asignatura_id"));
                    c.setProfesorId(rs.getInt("profesor_id"));
                    c.setNota(rs.getDouble("nota"));

                    return c;
                }
            }
        }

        return null;
    }
}