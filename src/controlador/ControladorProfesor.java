package controlador;

import alertas.MensajeAdvertencia; 
import alertas.MensajeError;
import dao.ProfesorDAOimpl;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.Profesor;
import vista.Profesores;
import vistassecundarias.ModalOpcionesProfesor;

public class ControladorProfesor implements ActionListener, KeyListener {

    private final Profesores vista;

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorProfesor(Profesores vista) {
        this.vista = vista;
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.txtBuscar.addKeyListener(this);
        cargarDatos();
    }

    //<editor-fold defaultstate="collapsed" desc="metodo mostrarModalOpcionesProfesor">
    private void mostrarModalOpcionesProfesor() {
        ModalOpcionesProfesor modal = new ModalOpcionesProfesor((Frame) vista.getTopLevelAncestor(), true);
        modal.setSize(vista.getParent().getParent().getSize());
        modal.setBackground(new Color(0, 0, 0, 75));
        modal.fondo.setBackground(new Color(0, 0, 0, 75));
        modal.setLocationRelativeTo(vista.getParent().getParent());
        modal.setVisible(true);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo mostrarModalOpcionesEstudiante(Estudiante estudiante)">
    private void mostrarModalOpionesProfesor(Profesor profesor) {
        ModalOpcionesProfesor modal = new ModalOpcionesProfesor((Frame) vista.getTopLevelAncestor(), true, profesor);
        modal.setSize(vista.getParent().getParent().getSize());
        modal.setBackground(new Color(0, 0, 0, 75));
        modal.fondo.setBackground(new Color(0, 0, 0, 75));
        modal.setLocationRelativeTo(vista.getParent().getParent());
        modal.setVisible(true);
    }
    //</editor-fold>    

    //<editor-fold defaultstate="collapsed" desc="metodo para mostrar mensaje de error" >
    public void mostrarError(String texto) {
        MensajeError mensaje = new MensajeError((Frame) vista.getTopLevelAncestor(), true);
        mensaje.etiquetaMensaje1.setText(texto);
        mensaje.setSize(vista.getParent().getParent().getSize());
        mensaje.setLocationRelativeTo(vista.getParent().getParent());
        mensaje.setBackground(new Color(0, 0, 0, 75));
        mensaje.fondo.setBackground(new Color(0, 0, 0, 75));
        mensaje.setVisible(true);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo para mostrar advertencia" >
    public void mostrarAdvertencia(String texto) {
        MensajeAdvertencia mensaje = new MensajeAdvertencia((Frame) vista.getTopLevelAncestor(), true);
        mensaje.etiquetaMensaje.setText(texto);
        mensaje.setSize(vista.getParent().getParent().getSize());
        mensaje.setLocationRelativeTo(vista.getParent().getParent());
        mensaje.setBackground(new Color(0, 0, 0, 75));
        mensaje.fondo.setBackground(new Color(0, 0, 0, 75));
        //MensajeAdvertencia.
        mensaje.setVisible(true);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo para obtener la fila seleccionada" >
    public void obtenerFilaSeleccionada() {

        switch (vista.myTable1.getSelectedRowCount()) {
            case 0:
                mostrarError("Debe seleccionar un profesor.");
                //JOptionPane.showMessageDialog(null, "Debe seleccionar un profesor de la tabla.", "Mensaje", JOptionPane.ERROR_MESSAGE);
                break;
            case 1:
                try {
                    int id = (int) vista.myTable1.getValueAt(vista.myTable1.getSelectedRow(), 0);
                    ProfesorDAOimpl dao = new ProfesorDAOimpl();
                    mostrarModalOpionesProfesor(dao.obtenerProfesorPorId(id));
                } catch (Exception e) {
                }

                break;
            default:
                //JOptionPane.showMessageDialog(null, "No se puede editar más de 1 profesor a la vez.");
                mostrarError("No es posible editar más de 1 profesor a la vez.");
                break;
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="metodo que llena la tsbla"> 
    private void cargarDatos() {
        ProfesorDAOimpl dao = new ProfesorDAOimpl();
        try {
            DefaultTableModel modelo = (DefaultTableModel) vista.myTable1.getModel();

            List<Profesor> lista = dao.listar();

            for (Profesor p : lista) {
                modelo.addRow(new Object[]{p.getId(), p.getNombre(), p.getNombre2(), p.getApellido(),
                    p.getApellido2(), p.getSexo(), p.getUsuario(), p.getContraseña(), p.getNombreRol()});

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo para filtrar tabla" >
    public void filtrarTabla() {
        int columnaFiltro = 1; //numero de columna que se desea filtrar 
        TableModel tm = vista.myTable1.getModel(); // Objeto TableModel que sera igual al modelo de la tabla
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tm); // 
        vista.myTable1.setRowSorter(sorter);
        if (vista.txtBuscar.getText().isEmpty() || vista.txtBuscar.getText().equals(vista.txtBuscar.getPlaceHolder())) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("^(?i)" + vista.txtBuscar.getText(), columnaFiltro));
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo para eliminar profesor" >
    public void eliminarProfesor() {
        ProfesorDAOimpl dao = new ProfesorDAOimpl();
        DefaultTableModel modelo = (DefaultTableModel) vista.myTable1.getModel();

        if (vista.myTable1.getSelectedRows().length < 1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar 1 o más grupos a eliminar", "Mensaje", JOptionPane.ERROR_MESSAGE);
        } else {
            int filasSeleccionadas[] = vista.myTable1.getSelectedRows();

            for (int i = filasSeleccionadas.length - 1; i >= 0; i--) {
                try {
                    //Obtener el nuevo indice luego de filtrar
                    int fila = vista.myTable1.convertRowIndexToModel(filasSeleccionadas[i]);
                    dao.eliminar((int) vista.myTable1.getValueAt(filasSeleccionadas[i], 0));
                    modelo.removeRow(fila);
                } catch (Exception ex) {
                    Logger.getLogger(ControladorGrupo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    //</editor-fold>

    @Override
    public void actionPerformed(ActionEvent e) {
        String opcion = e.getActionCommand();

        switch (opcion) {
            case "Nuevo":
                mostrarModalOpcionesProfesor();
                //ControladorPrincipal.mostrarPanel(new OpcionesProfesor());
                break;
            case "Editar":
                obtenerFilaSeleccionada();
                break;
            case "Eliminar":
                if (vista.myTable1.getSelectedRows().length < 1) {
                    mostrarError("Debe seleccionar por lo menos un profesor.");
                    //JOptionPane.showMessageDialog(null, "Debe seleccionar 1 o más profesores a eliminar", "Mensaje", JOptionPane.ERROR_MESSAGE);
                } else if (vista.myTable1.getSelectedRows().length == 1) {
                    String nombre = (String) vista.myTable1.getValueAt(vista.myTable1.getSelectedRow(), 1);
                    String apellido = (String) vista.myTable1.getValueAt(vista.myTable1.getSelectedRow(), 3);
                    mostrarAdvertencia("Se eliminará el profesor " + nombre + " " + apellido + ".");
                    if (MensajeAdvertencia.ACEPTAR == 1) {
                        eliminarProfesor();
                    }

                } else {
                    mostrarAdvertencia("Se eliminarán todos los profesores seleccionados.");
                    if (MensajeAdvertencia.ACEPTAR == 1) {
                        eliminarProfesor();
                    }
                }
                break;
        }

    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if (ke.getSource() == vista.txtBuscar) {

            filtrarTabla();
        }

    }

}
