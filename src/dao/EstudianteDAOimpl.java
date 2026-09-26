package dao;

import db.Conexion;
import interfaces.EstudianteDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Estudiante;

public class EstudianteDAOimpl extends Conexion implements EstudianteDAO {

    @Override
    public void registrar(Estudiante estudiante) throws Exception {
        String sql = "INSERT INTO estudiante (nombre,nombre2,apellido,apellido2,sexo,grupo_id) VALUES (?,?,?,?,?,?)";

        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getNombre2());
            ps.setString(3, estudiante.getApellido());
            ps.setString(4, estudiante.getApellido2());
            ps.setString(5, estudiante.getSexo());
            ps.setInt(6, estudiante.getGrupo_id());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("aqui entra?");
        } finally {
            this.cerrar();
        }

    }

    @Override
    public void modificar(Estudiante estudiante) throws Exception {
        String sql = "UPDATE estudiante SET nombre=?,nombre2=?,apellido=?,apellido2=?,sexo=?,grupo_id=? WHERE id=?";
        try {

            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getNombre2());
            ps.setString(3, estudiante.getApellido());
            ps.setString(4, estudiante.getApellido2());
            ps.setString(5, estudiante.getSexo());
            ps.setInt(6, estudiante.getGrupo_id());
            ps.setInt(7, estudiante.getId());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminar(int estudianteId) throws Exception {
        String sql = "DELETE FROM estudiante WHERE id=?";
        String sql2 = "UPDATE sqlite_sequence SET seq=0 WHERE name ='estudiante'";

        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            PreparedStatement ps2 = this.conexion.prepareStatement(sql2);
            ps.setInt(1, estudianteId);
            ps.executeUpdate();
            ps.close();
            ps2.executeUpdate();
            ps2.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrar();
        }

    }

    @Override
    public List<Estudiante> listar() throws Exception {
        List<Estudiante> lista = null;
        //String sql = "SELECT * FROM estudiante";        
        //String sql = "SELECT estudiante.id,estudiante.nombre,estudiante.nombre2,estudiante.apellido,estudiante.apellido2,estudiante.sexo,grado.nombre As grado,estudiante.grupo_id,grupo.nombre As grupo FROM estudiante,grupo,grado WHERE estudiante.grupo_id = grupo.id AND grupo.grado_id = grado.id GROUP BY(estudiante.id)";
        String sql = "SELECT * FROM mostrarEstudiantes";
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            lista = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setId(rs.getInt("id"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setNombre2(rs.getString("nombre2"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setApellido2(rs.getString("apellido2"));
                estudiante.setSexo(rs.getString("sexo"));
                estudiante.setNombreGrado(rs.getString("grado"));
                estudiante.setNombreGrupo(rs.getString("grupo"));
                estudiante.setGrupo_id(rs.getInt("grupo_id"));
                lista.add(estudiante);
            }
            ps.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("entra aca 1" + e.getMessage());
        } finally {
            this.cerrar();
        }
        return lista;

    }

    @Override
    public Estudiante obtenerEstudiantePorId(int estudianteId) throws Exception {
        Estudiante estudiante = new Estudiante();
        String sql = "SELECT estudiante.id, estudiante.nombre, estudiante.nombre2, estudiante.apellido, estudiante.apellido2,\n"
                + "       estudiante.sexo, estudiante.grupo_id, grado.nombre AS grado, grupo.nombre AS grupo, grado.id AS grado_id\n"
                + "FROM estudiante\n"
                + "LEFT JOIN grupo ON estudiante.grupo_id = grupo.id\n"
                + "LEFT JOIN grado ON grupo.grado_id = grado.id\n"
                + "WHERE estudiante.id = ?\n"
                + "GROUP BY estudiante.id";
//        String sql = "SELECT estudiante.id,estudiante.nombre,estudiante.nombre2,estudiante.apellido,\n"
//                + "estudiante.apellido2,estudiante.sexo,grado.nombre AS grado,grupo.nombre AS grupo,estudiante.grupo_id,grado.id AS grado_id\n"
//                + "FROM estudiante,grupo,grado\n"
//                + "WHERE estudiante.grupo_id = grupo.id\n"
//                + "AND grupo.grado_id = grado.id\n"
//                + "AND estudiante.id = ?\n"
//                + "GROUP BY(estudiante.id)";
        //String sql = "SELECT estudiante.id,estudiante.nombre,estudiante.nombre2,estudiante.apellido,estudiante.apellido2,estudiante.sexo,estudiante.grado_id,grado.nombre AS grado,estudiante.grupo_id,grupo.nombre AS grupo FROM estudiante,grupo,grado  WHERE estudiante.grupo_id = grupo.id AND estudiante.grado_id=grado.id AND estudiante.id=? GROUP BY(estudiante.id)";
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            System.out.println(estudianteId);
            ps.setInt(1, estudianteId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                estudiante.setId(rs.getInt("id"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setNombre2(rs.getString("nombre2"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setApellido2(rs.getString("apellido2"));
                estudiante.setSexo(rs.getString("sexo"));
                estudiante.setNombreGrado(rs.getString("grado"));
                estudiante.setNombreGrupo(rs.getString("grupo"));
                estudiante.setGrupo_id(rs.getInt("grupo_id"));
                estudiante.setGrado_id(rs.getInt("grado_id"));
            }
            ps.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrar();
        }
        return estudiante;
    }

}
