package controladorsecundario;

import dao.AsignaturaDAOimpl;
import dao.CalificacionDAOImpl;
import dao.EstudianteDAOimpl;
import dao.ProfesorDAOimpl;
import db.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Asignatura;
import modelo.Calificacion;
import modelo.Estudiante;
import modelo.Profesor;
import vistassecundarias.ModalCalificacion;

public class ControladorModalCalificacion implements ActionListener {

    private final ModalCalificacion vista;
    private final CalificacionDAOImpl dao;

    // ================= NUEVO =================
    public ControladorModalCalificacion(ModalCalificacion vista) {

        this.vista = vista;

        Connection conn = Conexion.getConexion();
        dao = new CalificacionDAOImpl(conn);

        this.vista.btnGuardar.addActionListener(this);

        cargarEstudiantes();
        cargarAsignaturas();
        cargarProfesores();
    }

    // ================= EDITAR =================
    public ControladorModalCalificacion(
            ModalCalificacion vista,
            Calificacion calificacion
    ) {

        this.vista = vista;

        Connection conn = Conexion.getConexion();
        dao = new CalificacionDAOImpl(conn);

        this.vista.btnGuardar.addActionListener(this);

        cargarEstudiantes();
        cargarAsignaturas();
        cargarProfesores();

        cargarDatos(calificacion);
    }

    // ================= CARGAR ESTUDIANTES =================
    private void cargarEstudiantes() {

        try {

            EstudianteDAOimpl daoEstudiante = new EstudianteDAOimpl();

            List<Estudiante> lista = daoEstudiante.listar();

            for (Estudiante e : lista) {

                vista.comboEstudiante.addItem(e);

            }

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

    // ================= CARGAR ASIGNATURAS =================
    private void cargarAsignaturas() {

        try {

            AsignaturaDAOimpl daoAsignatura = new AsignaturaDAOimpl();

            List<Asignatura> lista = daoAsignatura.listar();

            for (Asignatura a : lista) {

                vista.comboAsignatura.addItem(a);

            }

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

    // ================= CARGAR PROFESORES =================
    private void cargarProfesores() {

        try {

            ProfesorDAOimpl daoProfesor = new ProfesorDAOimpl();

            List<Profesor> lista = daoProfesor.listar();

            for (Profesor p : lista) {

                vista.comboProfesor.addItem(p);

            }

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

    // ================= CARGAR DATOS =================
    private void cargarDatos(Calificacion c) {

        vista.txtNota.setText(String.valueOf(c.getNota()));

    }

    // ================= GUARDAR =================
    private void guardar() {

        try {

            Estudiante estudiante
                    = (Estudiante) vista.comboEstudiante.getSelectedItem();

            Asignatura asignatura
                    = (Asignatura) vista.comboAsignatura.getSelectedItem();

            Profesor profesor
                    = (Profesor) vista.comboProfesor.getSelectedItem();

            double nota
                    = Double.parseDouble(vista.txtNota.getText());

            Calificacion c = new Calificacion();

            c.setEstudianteId(estudiante.getId());
            c.setAsignaturaId(asignatura.getId());
            c.setProfesorId(profesor.getId());
            c.setNota(nota);

            dao.agregar(c);

            JOptionPane.showMessageDialog(
                    null,
                    "Calificación registrada correctamente"
            );

            vista.dispose();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Error: " + e.getMessage()
            );

        }

    }

    // ================= EVENTOS =================
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnGuardar) {

            guardar();

        }

    }

}