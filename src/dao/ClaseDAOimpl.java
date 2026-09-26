package dao;

import db.Conexion;
import interfaces.ClaseDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Clase;

public class ClaseDAOimpl extends Conexion implements ClaseDAO {

    @Override
    public void registrarClase(Clase clase) throws Exception {
        String sql = "INSERT INTO clase (profesor_id,asignatura_id,grupo_id) VALUES(?,?,?)";
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ps.setInt(1, clase.getProfesor_id());
            ps.setInt(2, clase.getAsignatura_id());
            ps.setInt(3, clase.getGrupo_id());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrar();
        }

    }

    @Override
    public void modificarClase(Clase clase) throws Exception {
        String sql = "UPDATE clase SET profesor_id=?,asignatura_id=?,grupo_id=? WHERE id=?";
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ps.setInt(1, clase.getProfesor_id());
            ps.setInt(2, clase.getAsignatura_id());
            ps.setInt(3, clase.getGrupo_id());
            ps.setInt(4, clase.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrar();
        }

    }

    @Override
    public void eliminarClase(int claseId) throws Exception {

        String sql = "DELETE FROM clase WHERE id=?";
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ps.setInt(1, claseId);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrar();
        }

    }

    @Override
    public List<Clase> listar() throws Exception {
        String sql = "SELECT * FROM mostrarClases";
        List<Clase> lista = new ArrayList<>();

        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Clase clase = new Clase();
                clase.setId(rs.getInt("id"));
                clase.setAsignatura_id(rs.getInt("asignatura_id"));
                clase.setProfesor_id(rs.getInt("profesor_id"));
                clase.setGrupo_id(rs.getInt("grupo_id"));
                clase.setNombre(rs.getString("nombre"));
                clase.setApellido(rs.getString("apellido"));
                clase.setAsignatura(rs.getString("asignatura"));
                clase.setGrupo(rs.getString("grupo"));
                clase.setGrado(rs.getString("grado"));
                lista.add(clase);
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrar();
        }
        return lista;
    }

    @Override
    public Clase obtenerClasePorId(int claseId) throws Exception {
        String sql = "SELECT clase.id,profesor.nombre,profesor.apellido,asignatura.nombre AS asignatura,\n"
                + "grado.nombre AS grado,grupo.nombre AS grupo,clase.profesor_id,clase.asignatura_id,clase.grupo_id\n"
                + "FROM clase,grupo,profesor,grado,asignatura\n"
                + "WHERE clase.grupo_id = grupo.id\n"
                + "AND clase.profesor_id = profesor.id\n"
                + "AND clase.asignatura_id = asignatura.id\n"
                + "AND grupo.grado_id = grado.id\n"
                + "AND clase.id = ?\n"
                + "GROUP BY(clase.id)";
        Clase clase = new Clase();
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ps.setInt(1, claseId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                clase.setId(rs.getInt("id"));
                clase.setAsignatura_id(rs.getInt("asignatura_id"));
                clase.setProfesor_id(rs.getInt("profesor_id"));
                clase.setGrupo_id(rs.getInt("grupo_id"));
                clase.setNombre(rs.getString("nombre"));
                clase.setApellido(rs.getString("apellido"));
                clase.setAsignatura(rs.getString("asignatura"));
                clase.setGrupo(rs.getString("grupo"));
                clase.setGrado(rs.getString("grado"));
            }
            ps.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrar();
        }
        return clase;
    }

}
