package dao;

import db.Conexion;
import interfaces.DesempeñoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Desempeño;

public class DesempeñoDAOimpl extends Conexion implements DesempeñoDAO {

    @Override
    public void registrarDesempeño(Desempeño desempeño) throws Exception {
        String sql = "INSERT INTO desempeño (descripcion,superior,alto,basico,bajo,grupo_id,asignatura_id,periodo_id) "
                + "VALUES(?,?,?,?,?,?,?,?)";
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ps.setString(1, desempeño.getDescripcion());
            ps.setString(2, desempeño.getSuperior());
            ps.setString(3, desempeño.getAlto());
            ps.setString(4, desempeño.getBasico());
            ps.setString(5, desempeño.getBajo());
            ps.setInt(6, desempeño.getGrupo_id());
            ps.setInt(7, desempeño.getAsignatura_id());
            ps.setInt(8, desempeño.getPeriodo_id());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar \n"
                    + e.getMessage());
        }

    }

    @Override
    public void modificarDesempeño(Desempeño desempeño) throws Exception {
        String sql = "UPDATE desempeño SET descripcion=?,superior=?,alto=?,basico=?,"
                + "bajo=?,grupo_id=?,asignatura_id=?,periodo_id=? WHERE id=?";
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ps.setString(1, desempeño.getDescripcion());
            ps.setString(2, desempeño.getSuperior());
            ps.setString(3, desempeño.getAlto());
            ps.setString(4, desempeño.getBasico());
            ps.setString(5, desempeño.getBajo());
            ps.setInt(6, desempeño.getGrupo_id());
            ps.setInt(7, desempeño.getAsignatura_id());
            ps.setInt(8, desempeño.getPeriodo_id());
            ps.setInt(9, desempeño.getId());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar \n"
                    + e.getMessage());
        }

    }

    @Override
    public void eliminar(int desempeñoId) throws Exception {
        String sql = "DELETE FROM desempeño WHERE id=?";
        String sql2 = "DELETE FROM sqlite_sequence WHERE name = 'desempeño'";
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            PreparedStatement ps2 = this.conexion.prepareStatement(sql2);
            ps.setInt(1, desempeñoId);
            ps.executeUpdate();
            ps2.executeUpdate();
            ps.close();
            ps2.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar \n"
                    + e.getMessage());
        }

    }

    @Override
    public List<Desempeño> listar() throws Exception {
        String sql = "SELECT * FROM mostrarDesempeño";
//        String sql = "SELECT desempeño.id,desempeño.descripcion,desempeño.superior,desempeño.alto,desempeño.basico,desempeño.bajo,desempeño.grado_id,desempeño.asignatura_id,desempeño.periodo_id,grado.nombre AS grado,asignatura.nombre AS asignatura,periodo.periodoAcademico "
//                + "FROM desempeño,grado,asignatura,periodo "
//                + "WHERE desempeño.grado_id = grado.id AND desempeño.asignatura_id=asignatura.id AND desempeño.periodo_id= periodo.id "
//                + "GROUP BY (desempeño.id)";
        List<Desempeño> lista = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Desempeño desempeño = new Desempeño();
                desempeño.setId(rs.getInt("id"));
                desempeño.setDescripcion(rs.getString("descripcion"));
                desempeño.setSuperior(rs.getString("superior"));
                desempeño.setAlto(rs.getString("alto"));
                desempeño.setBasico(rs.getString("basico"));
                desempeño.setBajo(rs.getString("bajo"));
                desempeño.setAsignatura_id(rs.getInt("asignatura_id"));
                desempeño.setPeriodo_id(rs.getInt("periodo_id"));
                desempeño.setGrupo_id(rs.getInt("grupo_id"));
                desempeño.setNombreGrado(rs.getString("grado"));
                desempeño.setNombreGrupo(rs.getString("grupo"));
                desempeño.setNombreAsignatura(rs.getString("asignatura"));
                desempeño.setPeriodoAcademico(rs.getString("periodo"));
                lista.add(desempeño);
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar \n"
                    + e.getMessage());
        }
        return lista;

    }

    @Override
    public Desempeño obtenerDesempeñoPorid(int desempeñoId) throws Exception {
        String sql = "SELECT desempeño.id,asignatura.nombre AS asignatura,\n"
                + "grado.nombre AS grado,grupo.nombre AS grupo,periodo.periodoAcademico,periodo.año,\n"
                + "desempeño.descripcion,desempeño.superior,desempeño.alto,desempeño.basico,desempeño.bajo,\n"
                + "desempeño.asignatura_id,desempeño.grupo_id,desempeño.periodo_id\n"
                + "FROM desempeño,asignatura,grupo,periodo,grado\n"
                + "WHERE desempeño.asignatura_id = asignatura.id \n"
                + "AND desempeño.grupo_id = grupo.id\n"
                + "AND desempeño.periodo_id = periodo.id\n"
                + "AND grupo.grado_id = grado.id\n"
                + "AND desempeño.id=?"
                + "GROUP BY(desempeño.id)";
        Desempeño desempeño = new Desempeño();

        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ps.setInt(1, desempeñoId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                desempeño.setId(rs.getInt("id"));
                desempeño.setDescripcion(rs.getString("descripcion"));
                desempeño.setSuperior(rs.getString("superior"));
                desempeño.setAlto(rs.getString("alto"));
                desempeño.setBasico(rs.getString("basico"));
                desempeño.setBajo(rs.getString("bajo"));
                desempeño.setGrupo_id(rs.getInt("grupo_id"));
                desempeño.setAsignatura_id(rs.getInt("asignatura_id"));
                desempeño.setPeriodo_id(rs.getInt("periodo_id"));
                desempeño.setNombreGrado(rs.getString("grado"));
                desempeño.setNombreAsignatura(rs.getString("asignatura"));
                desempeño.setPeriodoAcademico(rs.getString("periodoAcademico"));

            }
            ps.close();
            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar por id \n"
                    + e.getMessage());
        }
        return desempeño;
    }

}
