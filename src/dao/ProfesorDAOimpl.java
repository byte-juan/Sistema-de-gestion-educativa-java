package dao;

import db.Conexion;
import interfaces.ProfesorDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Profesor;

public class ProfesorDAOimpl extends Conexion implements ProfesorDAO {

    @Override
    public void registrar(Profesor profesor) throws Exception {
        String sql = "INSERT INTO profesor (nombre,nombre2,apellido,apellido2,sexo,usuario,contraseña,rol_id) VALUES(?,?,?,?,?,?,?,?)";
        try {

            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ps.setString(1, profesor.getNombre());
            ps.setString(2, profesor.getNombre2());
            ps.setString(3, profesor.getApellido());
            ps.setString(4, profesor.getApellido2());
            ps.setString(5, profesor.getSexo());
            ps.setString(6, profesor.getUsuario());
            ps.setString(7, profesor.getContraseña());
            ps.setInt(8, profesor.getRol_id());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(Profesor profesor) throws Exception {
        String sql = "UPDATE profesor SET nombre=?,nombre2=?,apellido=?,apellido2=?,sexo=?,usuario=?,"
        + " contraseña=?,rol_id=? WHERE id=?";
        try {

            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ps.setString(1, profesor.getNombre());
            ps.setString(2, profesor.getNombre2());
            ps.setString(3, profesor.getApellido());
            ps.setString(4, profesor.getApellido2());
            ps.setString(5, profesor.getSexo());
            ps.setString(6, profesor.getUsuario());
            ps.setString(7, profesor.getContraseña());
            ps.setInt(8, profesor.getRol_id());
            ps.setInt(9, profesor.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrar();
        }

    }

    @Override
    public void eliminar(int profesorId) throws Exception {
        String sql = "DELETE FROM profesor WHERE id=?";
        String sql2 = "DELETE FROM sqlite_sequence WHERE name = 'profesor'";
        String sql3 = "PRAGMA foreign_keys = ON;";

        try {

            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            PreparedStatement ps2 = this.conexion.prepareStatement(sql2);
            PreparedStatement ps3 = this.conexion.prepareStatement(sql3);
            ps.setInt(1, profesorId);
            ps3.executeUpdate();
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
    public List<Profesor> listar() throws Exception {
        List<Profesor> lista = null;
        String sql = "SELECT profesor.id,profesor.nombre,profesor.nombre2,profesor.apellido,profesor.apellido2,profesor.sexo,profesor.usuario,profesor.contraseña,profesor.rol_id,rol.nombre AS rol\n"
                + "FROM profesor\n"
                + "LEFT JOIN rol\n"
                + "ON profesor.rol_id = rol.id";
        try {

            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Profesor profesor = new Profesor();
                profesor.setId(rs.getInt("id"));
                profesor.setNombre(rs.getString("nombre"));
                profesor.setNombre2(rs.getString("nombre2"));
                profesor.setApellido(rs.getString("apellido"));
                profesor.setApellido2(rs.getString("apellido2"));
                profesor.setSexo(rs.getString("sexo"));
                profesor.setUsuario(rs.getString("usuario"));
                profesor.setContraseña(rs.getString("contraseña"));
                profesor.setRol_id(rs.getInt("rol_id"));
                profesor.setNombreRol(rs.getString("rol"));

                lista.add(profesor);

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
    public Profesor obtenerProfesorPorId(int profesorId) throws Exception {
        Profesor profesor = new Profesor();
        String sql = "SELECT profesor.id,profesor.nombre,profesor.nombre2,profesor.apellido,profesor.apellido2,profesor.sexo,profesor.usuario,profesor.contraseña,profesor.rol_id,rol.nombre AS rol\n"
                + "FROM profesor\n"
                + "LEFT JOIN rol\n"
                + "ON profesor.rol_id = rol.id\n"
                + "WHERE profesor.id=?";
        try {

            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ps.setInt(1, profesorId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                profesor.setId(rs.getInt("id"));
                profesor.setNombre(rs.getString("nombre"));
                profesor.setNombre2(rs.getString("nombre2"));
                profesor.setApellido(rs.getString("apellido"));
                profesor.setApellido2(rs.getString("apellido2"));
                profesor.setSexo(rs.getString("sexo"));
                profesor.setUsuario(rs.getString("usuario"));
                profesor.setContraseña(rs.getString("contraseña"));
                profesor.setRol_id(rs.getInt("rol_id"));
            }
            ps.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrar();
        }
        return profesor;
    }

}
