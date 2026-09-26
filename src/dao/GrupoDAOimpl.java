package dao;

import db.Conexion;
import interfaces.GrupoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Grupo;

public class GrupoDAOimpl extends Conexion implements GrupoDAO {

    @Override
    public void registrar(Grupo grupo) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("INSERT INTO grupo (nombre,grado_id) VALUES (?,?)");
            ps.setString(1, grupo.getNombre());
            ps.setInt(2, grupo.getIdGrado());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrar();
        }

    }

    @Override
    public void modificar(Grupo grupo) throws Exception {
        String sql = "UPDATE grupo SET nombre = ?, grado_id=? WHERE id=?";
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ps.setString(1, grupo.getNombre());
            ps.setInt(2, grupo.getIdGrado());
            ps.setInt(3, grupo.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.cerrar();
        }

    }

    @Override
    public List<Grupo> listar() throws Exception {
        List<Grupo> lista = null;

        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("SELECT grupo.id,grado.nombre as grado,grupo.nombre as grupo,grado_id "
                    + "FROM grupo,grado "
                    + "WHERE grupo.grado_id = grado.id "
                    + "GROUP BY (grupo.id)");

            lista = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Grupo grupo = new Grupo();
                grupo.setId(rs.getInt("id"));
                grupo.setNombre(rs.getString("grupo"));
                grupo.setIdGrado(rs.getInt("grado_id"));
                grupo.setNombreGrado(rs.getString("grado"));
                lista.add(grupo);

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
    public void eliminar(int grupoId) throws Exception {
        String sql = "DELETE FROM grupo WHERE id=?";
        String sql2 = "DELETE FROM sqlite_sequence WHERE name = 'grupo'";
        String sql3 = "PRAGMA foreign_keys = ON;";
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            PreparedStatement ps2 = this.conexion.prepareStatement(sql2);
            PreparedStatement ps3 = this.conexion.prepareStatement(sql3);
            ps.setInt(1, grupoId);
            ps3.executeUpdate();
            ps.executeUpdate();
            ps2.executeUpdate();
            ps3.close();
            ps2.close();
            ps.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrar();
        }

    }

    @Override
    public Grupo obtenerGrupoPorId(int grupoId) throws Exception {
        Grupo grupo = new Grupo();
        String sql = "SELECT grupo.id,grado.nombre AS grado,grupo.nombre AS grupo,grado_id \n"
                + "FROM grupo,grado\n"
                + "WHERE grupo.grado_id = grado.id\n"
                + "AND grupo.id=?\n"
                + "GROUP BY(grupo.id)";
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ps.setInt(1, grupoId);
            System.out.println(grupoId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                grupo.setId(rs.getInt("id"));
                grupo.setNombre(rs.getString("grupo"));
                grupo.setIdGrado(rs.getInt("grado_id"));
                grupo.setNombreGrado(rs.getString("grado"));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrar();
        }

        return grupo;
    }

}
