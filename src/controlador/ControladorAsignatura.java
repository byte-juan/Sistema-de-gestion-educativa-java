package controlador;

import alertas.MensajeAdvertencia;
import alertas.MensajeError;
import dao.AsignaturaDAOimpl;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.Asignatura;
import vista.Asignaturas;
import vistassecundarias.ModalOpcionesAsignatura;

public class ControladorAsignatura implements ActionListener, KeyListener {

    private final Asignaturas vista;

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorAsignatura(Asignaturas vista) {
        this.vista = vista;
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.txtBuscar.addKeyListener(this);
        cargarDatos();
    }

    //<editor-fold defaultstate="collapsed" desc="metodo mostrar modal registrar asignatura">
    public void mostrarModalOpcionesAsignatura() {
        ModalOpcionesAsignatura modal = new ModalOpcionesAsignatura((Frame) vista.getTopLevelAncestor(), true);
        modal.setSize(vista.getParent().getParent().getSize());
        modal.setBackground(new Color(0, 0, 0, 75));
        modal.fondo.setBackground(new Color(0, 0, 0, 75));
        modal.setLocationRelativeTo(vista.getParent().getParent());
        modal.setVisible(true);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo mostrar modal editar asignatura">
    public void mostrarModalOpcionesAsignatura(Asignatura asignatura) {
        ModalOpcionesAsignatura modal = new ModalOpcionesAsignatura((Frame) vista.getTopLevelAncestor(), true, asignatura);
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

    //<editor-fold defaultstate="collapsed" desc="metodo para cargar datos">
    private void cargarDatos() {
        double numero = 75.3;
        //DecimalFormat df = new DecimalFormat("#.##%");
        //String porcentaje = df.format(numero);
        // System.out.println(porcentaje); // Imprime "75%"

        AsignaturaDAOimpl dao = new AsignaturaDAOimpl();
        try {
            List<Asignatura> lista = dao.listar();

            DefaultTableModel modelo = (DefaultTableModel) vista.myTable1.getModel();
            for (Asignatura a : lista) {
                DecimalFormat df = new DecimalFormat("#.##%");
                String numeroPorcentual = df.format(a.getPeso() / 100);

                modelo.addRow(new Object[]{a.getId(), a.getNombre(), numeroPorcentual, a.getNombreArea()});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="metodo para obtener la fila seleccionada" >
    public void obtenerFilaSeleccionada() {

        switch (vista.myTable1.getSelectedRowCount()) {
            case 0:
                //JOptionPane.showMessageDialog(null, "Debe seleccionar una asignatura.", "Mensaje", JOptionPane.ERROR_MESSAGE);
                mostrarError("Debe seleccionar una asignatura.");
                break;
            case 1:
                int id = (int) vista.myTable1.getValueAt(vista.myTable1.getSelectedRow(), 0);
                AsignaturaDAOimpl dao = new AsignaturaDAOimpl();
                try {
                    mostrarModalOpcionesAsignatura(dao.obtenerAsignaturaPorId(id));
                    // ControladorPrincipal.mostrarPanel(new OpcionesAsignatura(dao.obtenerAsignaturaPorId(id)));
                } catch (Exception ex) {
                    Logger.getLogger(ControladorGrupo.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            default:
                mostrarError("No es posible editar más de una asignatura a la vez");
                break;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo para eliminar asignatura">
    public void eliminarAsignatura() {
        AsignaturaDAOimpl dao = new AsignaturaDAOimpl();
        DefaultTableModel modelo = (DefaultTableModel) vista.myTable1.getModel();

        if (vista.myTable1.getSelectedRows().length < 1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar 1 o más asignaturas para eliminar", "Mensaje", JOptionPane.ERROR_MESSAGE);
        } else {
            int filasSeleccionadas[] = vista.myTable1.getSelectedRows();

            for (int i = filasSeleccionadas.length - 1; i >= 0; i--) {
                try {
                    //Obtener el nuevo indice luego de filtrar
                    int fila = vista.myTable1.convertRowIndexToModel(filasSeleccionadas[i]);
                    dao.eliminar((int) vista.myTable1.getValueAt(filasSeleccionadas[i], 0));
                    modelo.removeRow(fila);
                } catch (Exception ex) {
                    Logger.getLogger(ControladorArea.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="metodo para filtar la tabla" >
    public void filtrarTabla() {
        int columnaFiltro = 1; //numero de columna que se desea filtrar 
        TableModel tm = vista.myTable1.getModel(); // Objeto TableModel que sera igual al modelo de la tabla
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tm); // 
        vista.myTable1.setRowSorter(sorter);
        if (vista.txtBuscar == null) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("^(?i)" + vista.txtBuscar.getText(), columnaFiltro, 2));
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo de ActionEvent">
    @Override
    public void actionPerformed(ActionEvent e) {
        String opcion = e.getActionCommand();

        switch (opcion) {
            case "Nuevo":
                //ControladorPrincipal.mostrarPanel(new OpcionesAsignatura());
                mostrarModalOpcionesAsignatura();
                break;
            case "Editar":
                obtenerFilaSeleccionada();
                break;
            case "Eliminar":
                if (vista.myTable1.getSelectedRows().length < 1) {
                    mostrarError("Debe seleccionar una asignatura.");
                    //JOptionPane.showMessageDialog(null, "Debe seleccionar una asignatura.", "Mensaje", JOptionPane.ERROR_MESSAGE);
                } else if (vista.myTable1.getSelectedRows().length == 1) {
                    String asignatura = (String) vista.myTable1.getValueAt(vista.myTable1.getSelectedRow(), 1);
                    mostrarAdvertencia("Se eliminará la asignatura " + asignatura + ".");
                    if (MensajeAdvertencia.ACEPTAR == 1) {
                        eliminarAsignatura();
                    }
                } else {
                    mostrarAdvertencia("Se eliminarán todas las asignaturas seleccionadas.");
                    if (MensajeAdvertencia.ACEPTAR == 1) {
                        eliminarAsignatura();
                    }
                }

                break;
        }

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo de KeyEvent">   
    @Override
    public void keyTyped(KeyEvent ke) {
        if (ke.getSource() == vista.txtBuscar) {
            filtrarTabla();
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }
    //</editor-fold>

}
