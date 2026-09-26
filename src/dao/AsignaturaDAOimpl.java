package dao;

import db.Conexion;
import interfaces.AsignaturaDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Asignatura;

public class AsignaturaDAOimpl extends Conexion implements AsignaturaDAO {

    @Override
    public void registrar(Asignatura asignatura) throws Exception {
        String sql = "INSERT INTO asignatura (nombre,peso,area_id) VALUES(?,?,?)";

        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ps.setString(1, asignatura.getNombre());
            ps.setFloat(2, asignatura.getPeso());
            ps.setInt(3, asignatura.getArea_id());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {

            this.cerrar();
        }

    }

    @Override
    public void modificar(Asignatura asignatura) throws Exception {
        String sql = "UPDATE asignatura SET nombre=?,peso=?,area_id=? WHERE id=?";

        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ps.setString(1, asignatura.getNombre());
            ps.setFloat(2, asignatura.getPeso());
            ps.setInt(3, asignatura.getArea_id());
            ps.setInt(4, asignatura.getId());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrar();
        }

    }

    @Override
    public void eliminar(int asignaturaId) throws Exception {
        String sql = "DELETE FROM asignatura WHERE id=?";
        String sql2 = "DELETE FROM sqlite_sequence WHERE name = 'asignatura'";
        String sql3 = "PRAGMA foreign_keys = ON;";
        try {

            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            PreparedStatement ps2 = this.conexion.prepareStatement(sql2);
            PreparedStatement ps3 = this.conexion.prepareStatement(sql3);
            ps3.executeUpdate();
            ps.setInt(1, asignaturaId);
            ps.executeUpdate();
            ps2.executeUpdate();

            ps.close();
            ps2.close();
            ps3.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrar();
        }

    }

    @Override
    public List<Asignatura> listar() throws Exception {
        // String sql = "SELECT asignatura.id,asignatura.nombre AS asignatura, asignatura.area_id, asignatura.profesor_id FROM asignatura";
//        String sql = "SELECT asignatura.id,asignatura.nombre AS asignatura, asignatura.area_id,asignatura.profesor_id,profesor.nombre,profesor.apellido,area.nombre AS area "
//                + "FROM asignatura,area "
//                + "LEFT JOIN profesor "
//                + "ON asignatura.profesor_id = profesor.id "
//                + "WHERE asignatura.area_id = area.id "
//                + "GROUP BY(asignatura.id)";
        String sql = "SELECT * FROM mostrarAsignaturas";
        List<Asignatura> lista = new ArrayList<>();

        try {

            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Asignatura asignatura = new Asignatura();
                asignatura.setId(rs.getInt("id"));
                asignatura.setNombre(rs.getString("asignatura"));
                asignatura.setPeso(rs.getFloat("peso"));
                asignatura.setArea_id(rs.getInt("area_id"));
                asignatura.setNombreArea(rs.getString("area"));
                lista.add(asignatura);
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
    public Asignatura obtenerAsignaturaPorId(int asignaturaId) throws Exception {
//        String sql = "SELECT asignatura.id,asignatura.nombre AS asignatura,asignatura.area_id,area.nombre AS area,asignatura.profesor_id,profesor.nombre,profesor.apellido "
//                + "FROM asignatura,area,profesor "
//                + "WHERE asignatura.area_id=area.id AND asignatura.profesor_id = profesor.id AND asignatura.id=?"
//                + "GROUP BY(asignatura.id)";
        String sql = "SELECT asignatura.id,asignatura.nombre AS asignatura,asignatura.peso,asignatura.area_id,area.nombre AS area "
                + "FROM asignatura,area "
                + "WHERE asignatura.area_id = area.id AND asignatura.id =? ";

        Asignatura asignatura = new Asignatura();

        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ps.setInt(1, asignaturaId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                asignatura.setId(rs.getInt("id"));
                asignatura.setNombre(rs.getString("asignatura"));
                asignatura.setPeso(rs.getFloat("peso"));
                asignatura.setArea_id(rs.getInt("area_id"));
                asignatura.setNombreArea(rs.getString("area"));
            }
            ps.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrar();
        }

        return asignatura;

    }

}
