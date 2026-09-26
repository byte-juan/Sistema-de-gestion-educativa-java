/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import db.Conexion;
import java.sql.Connection;
import dao.CalificacionDAOImpl;
import interfaces.CalificacionDAO;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.Calificacion;
import vista.Calificaciones;
import vistassecundarias.ModalCalificacion;

public class ControladorCalificacion implements ActionListener, KeyListener {

    private final Calificaciones vista;
    private final CalificacionDAO dao;

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorCalificacion(Calificaciones vista) {
        this.vista = vista;
        Connection conn = Conexion.getConexion();
        this.dao = new CalificacionDAOImpl(conn);

        this.vista.btnRegistrar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.txtBuscar.addKeyListener(this);

        cargarDatos();
    }
    private void mostrarModalCalificacion() {
        ModalCalificacion modal = new ModalCalificacion((Frame) vista.getTopLevelAncestor(), true);
        modal.setSize(vista.getParent().getParent().getSize());
        modal.setBackground(new Color(0, 0, 0, 75));
        
        modal.setLocationRelativeTo(vista.getParent().getParent());
        modal.setVisible(true);
    }
     

    // ================= CARGAR =================
    private void cargarDatos() {
        DefaultTableModel modelo = (DefaultTableModel) vista.myTable1.getModel();

        try {
            modelo.setRowCount(0);

            List<Calificacion> lista = dao.listar();

            for (Calificacion c : lista) {
                modelo.addRow(new Object[]{
                    c.getId(),
                    c.getEstudianteId(),
                    c.getAsignaturaId(),
                    c.getProfesorId(),
                    c.getNota()
                });
            }

        } catch (Exception ex) {
            Logger.getLogger(ControladorCalificacion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    // ================= OBTENER SELECCION =================
    private int getFilaSeleccionada() {
        return vista.myTable1.getSelectedRow();
    }

    // ================= ELIMINAR =================
    private void eliminar() {
        DefaultTableModel modelo = (DefaultTableModel) vista.myTable1.getModel();

        int filas[] = vista.myTable1.getSelectedRows();

        for (int i = filas.length - 1; i >= 0; i--) {

            int fila = vista.myTable1.convertRowIndexToModel(filas[i]);
            int id = (int) vista.myTable1.getValueAt(fila, 0);

            try {
                dao.eliminarPorId(id);
                modelo.removeRow(fila);
            } catch (Exception ex) {
                Logger.getLogger(ControladorCalificacion.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
    }

    // ================= EDITAR (TEMPORAL SIN MODAL) =================
    private void editar() {

          if (vista.myTable1.getSelectedRowCount() != 1) {
            System.out.println("Seleccione solo una fila");
             return;
         }

    int fila = vista.myTable1.getSelectedRow();

    int id = (int) vista.myTable1.getValueAt(fila, 0);
    int estudianteId = (int) vista.myTable1.getValueAt(fila, 1);
    int asignaturaId = (int) vista.myTable1.getValueAt(fila, 2);
    int profesorId = (int) vista.myTable1.getValueAt(fila, 3);
    double nota = Double.parseDouble(vista.myTable1.getValueAt(fila, 4).toString());

    System.out.println("EDITANDO:");
    System.out.println(id + " " + estudianteId + " " + asignaturaId + " " + profesorId + " " + nota);
}

    // ================= FILTRAR =================
    private void filtrar() {
        TableModel tm = vista.myTable1.getModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tm);
        vista.myTable1.setRowSorter(sorter);

        String texto = vista.txtBuscar.getText();

        if (texto == null || texto.trim().isEmpty()) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto, 1));
        }
    }

    // ================= EVENTOS =================
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {

            case "Nuevo":
                mostrarModalCalificacion();
            break;

            case "Editar":
                editar();
                break;

            case "Eliminar":
                eliminar();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vista.txtBuscar) {
            filtrar();
        }
    }

    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyPressed(KeyEvent e) {}
}

