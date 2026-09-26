package dao;

import db.Conexion;
import interfaces.AreaDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Area;

public class AreaDAOimpl extends Conexion implements AreaDAO {

    @Override
    public void registrar(Area area) throws Exception {
        String sql = "INSERT INTO area (nombre) VALUES(?)";
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ps.setString(1, area.getNombre());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrar();
        }

    }

    @Override
    public void modificar(Area area) throws Exception {
        String sql = "UPDATE area SET nombre=? WHERE id=?";
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ps.setString(1, area.getNombre());
            ps.setInt(2, area.getId());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            this.cerrar();
        }

    }

    @Override
    public void eliminar(int areaId) throws Exception {
        String sql = "DELETE FROM area WHERE id=?";
        String sql2 = "PRAGMA foreign_keys = ON;";
        String sql3 = "UPDATE sqlite_sequence SET seq = 0 WHERE name='area'";
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            PreparedStatement ps2 = this.conexion.prepareStatement(sql2);
            PreparedStatement ps3 = this.conexion.prepareStatement(sql3);
            ps.setInt(1, areaId);
            ps.executeUpdate();
            ps2.executeUpdate();
            ps3.executeUpdate();
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
    public List<Area> listar() throws Exception {
        List<Area> lista = null;
        String sql = "SELECT * FROM area";
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Area area = new Area();
                area.setId(rs.getInt("id"));
                area.setNombre(rs.getString("nombre"));
                lista.add(area);
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
    public Area obtenerAreaPorId(int areaId) throws Exception {
        Area area = new Area();
        String sql = "SELECT * FROM area WHERE id=?";
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ps.setInt(1, areaId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                area.setId(rs.getInt("id"));
                area.setNombre(rs.getString("nombre"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrar();
        }
        return area;

    }

}
