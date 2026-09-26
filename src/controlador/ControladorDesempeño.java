package controlador;

import alertas.MensajeAdvertencia;
import alertas.MensajeError;
import dao.DesempeñoDAOimpl;
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
import vista.Desempeño;
import vistassecundarias.OpcionesDesempeño;

public class ControladorDesempeño implements ActionListener, KeyListener {

    private final Desempeño vista;

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorDesempeño(Desempeño vista) {
        this.vista = vista;
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.txtBuscar.addKeyListener(this);
        cargarDatos();
        
    }  
    
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
        DesempeñoDAOimpl dao = new DesempeñoDAOimpl();
        try {
            List<modelo.Desempeño> lista = dao.listar();
            DefaultTableModel modelo = (DefaultTableModel) vista.myTable1.getModel();
            for (modelo.Desempeño d : lista) {
                modelo.addRow(new Object[]{d.getId(),d.getNombreAsignatura(),d.getNombreGrado(),
                    d.getNombreGrupo(),d.getPeriodoAcademico(),d.getDescripcion(),d.getSuperior(),d.getAlto(),
                d.getBasico(),d.getBajo()});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="metodo para filtar la tabla" >
    public void filtrarTabla() {
        //numero de columna que se desea filtrar 
        TableModel tm = vista.myTable1.getModel(); // Objeto TableModel que sera igual al modelo de la tabla
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tm); // 
        vista.myTable1.setRowSorter(sorter);
        if (vista.txtBuscar == null) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("^(?i)" + vista.txtBuscar.getText(), 2));
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo para eliminar desempeño">
    public void eliminarDesempeño() {
        DesempeñoDAOimpl dao = new DesempeñoDAOimpl();
        DefaultTableModel modelo = (DefaultTableModel) vista.myTable1.getModel();

        if (vista.myTable1.getSelectedRows().length < 1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar 1 o más desempeños para eliminar", "Mensaje", JOptionPane.ERROR_MESSAGE);
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

    // <editor-fold defaultstate="collapsed" desc="metodo para obtener la fila seleccionada" >
    public void obtenerFilaSeleccionada() {

        switch (vista.myTable1.getSelectedRowCount()) {
            case 0:

                mostrarError("Debe seleccionar un desempeño.");
                break;
            case 1:
                int id = (int) vista.myTable1.getValueAt(vista.myTable1.getSelectedRow(), 0);
                DesempeñoDAOimpl dao = new DesempeñoDAOimpl();
                try {
                    ControladorPrincipal.mostrarPanel(new OpcionesDesempeño(dao.obtenerDesempeñoPorid(id)));
                    //ControladorPrincipal.mostrarPanel(new Opcionesdesempeño(dao.obtenerdesempeñoPorId(id)));
                } catch (Exception ex) {
                    Logger.getLogger(ControladorGrupo.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            default:
                mostrarError("No es posible editar más de un desempeño a la vez");
                break;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo de ActionEvent">
    @Override
    public void actionPerformed(ActionEvent e) {
        String opcion = e.getActionCommand();
        switch (opcion) {
            case "Nuevo":
                ControladorPrincipal.mostrarPanel(new OpcionesDesempeño());
                break;
            case "Editar":
                obtenerFilaSeleccionada();
                break;
            case "Eliminar":
                if (vista.myTable1.getSelectedRows().length < 1) {
                    mostrarError("Debe seleccionar un descriptor de desempeño.");
                    //JOptionPane.showMessageDialog(null, "Debe seleccionar una desempeño.", "Mensaje", JOptionPane.ERROR_MESSAGE);
                } else if (vista.myTable1.getSelectedRows().length == 1) {
                    int id = (int) vista.myTable1.getValueAt(vista.myTable1.getSelectedRow(), 0);
                    mostrarAdvertencia("Se eliminará el descriptor de desempeño con id " + id + ".");
                    if (MensajeAdvertencia.ACEPTAR == 1) {
                        eliminarDesempeño();
                    }
                } else {
                    mostrarAdvertencia("Se eliminarán todos los descriptores seleccionadas.");
                    if (MensajeAdvertencia.ACEPTAR == 1) {
                        eliminarDesempeño();
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
