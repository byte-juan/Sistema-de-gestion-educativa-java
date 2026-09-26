package controlador;

import alertas.MensajeAdvertencia;
import alertas.MensajeError;
import interfaces.AreaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.Area;
import dao.AreaDAOimpl;
import java.awt.Color;
import java.awt.Frame;
import vista.Areas;
import vistassecundarias.ModalOpcionesArea;

public class ControladorArea implements ActionListener, KeyListener {

    private final Areas vista;

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorArea(Areas vista) {
        this.vista = vista;
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.txtBuscar.addKeyListener(this);
        cargarDatos();
    }

    //<editor-fold defaultstate="collapsed" desc="metodo mostrar modal registrar area">
    public void mostrarModalOpcionesArea() {
        ModalOpcionesArea modal = new ModalOpcionesArea((Frame) vista.getTopLevelAncestor(), true);
        modal.setSize(vista.getParent().getParent().getSize());
        modal.setBackground(new Color(0, 0, 0, 75));
        modal.fondo.setBackground(new Color(0, 0, 0, 75));
        modal.setLocationRelativeTo(vista.getParent().getParent());
        modal.setVisible(true);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo mostrar modal editar area">
    public void mostrarModalOpcionesArea(Area area) {
        ModalOpcionesArea modal = new ModalOpcionesArea((Frame) vista.getTopLevelAncestor(), true, area);
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

    // <editor-fold defaultstate="collapsed" desc="Metodo para eliminar un area"> 
    public void eliminarArea() {
        AreaDAOimpl dao = new AreaDAOimpl();
        DefaultTableModel modelo = (DefaultTableModel) vista.myTable1.getModel();

        if (vista.myTable1.getSelectedRows().length < 1) {
            //JOptionPane.showMessageDialog(null, "Debe seleccionar 1 o más areas para eliminar", "Mensaje", JOptionPane.ERROR_MESSAGE);
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

    // <editor-fold defaultstate="collapsed" desc="Metodo para llenar tabla"> 
    private void cargarDatos() {
        AreaDAO dao = new AreaDAOimpl();
        try {
            DefaultTableModel modelo = (DefaultTableModel) vista.myTable1.getModel();
            List<Area> lista_area = dao.listar();
            for (Area g : lista_area) {
                modelo.addRow(new Object[]{g.getId(), g.getNombre()});
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(Areas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodo para filtrar tabla"> 
    public void filtrarTabla() {
        int columnaFiltro = 1; //numero de columna que se desea filtrar 
        TableModel tm = vista.myTable1.getModel(); // Objeto TableModel que sera igual al modelo de la tabla
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tm); // 
        vista.myTable1.setRowSorter(sorter);
        if (vista.txtBuscar == null) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("^(?i)" + vista.txtBuscar.getText(), columnaFiltro));
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodo para obtener fila seleciconada"> 
    public void obtenerFilaSeleccionada() {

        switch (vista.myTable1.getSelectedRowCount()) {
            case 0:
                //JOptionPane.showMessageDialog(null, "Debe seleccionar un area.", "Mensaje", JOptionPane.ERROR_MESSAGE);
                mostrarError("Por favor, seleccione el area que desea editar.");
                break;
            case 1:
                int id = (int) vista.myTable1.getValueAt(vista.myTable1.getSelectedRow(), 0);
                AreaDAOimpl dao = new AreaDAOimpl();
                 {
                    try {
                        //ControladorPrincipal.mostrarPanel(new OpcionesArea(dao.obtenerAreaPorId(id)));
                        mostrarModalOpcionesArea(dao.obtenerAreaPorId(id));
                    } catch (Exception ex) {
                        Logger.getLogger(ControladorArea.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println(ex.getMessage());
                    }
                }
                break;
            default:
                //JOptionPane.showMessageDialog(null, "No se puede editar más de 1 area a la vez.");
                mostrarError("No es posible editar más de 1 area a la vez.");
                break;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo ActionEvent">
    @Override
    public void actionPerformed(ActionEvent e) {
        String opcion = e.getActionCommand();
        switch (opcion) {
            case "Nuevo":
                //ControladorPrincipal.mostrarPanel(new OpcionesArea());
                mostrarModalOpcionesArea();
                break;
            case "Editar": {
                obtenerFilaSeleccionada();
            }
            break;
            case "Eliminar":
                if (vista.myTable1.getSelectedRows().length < 1) {
                    mostrarError("Por favor, seleccione el area que desea eliminar.");
                    //JOptionPane.showMessageDialog(null, "Debe seleccionar un area.", "Mensaje", JOptionPane.ERROR_MESSAGE);
                } else if (vista.myTable1.getSelectedRows().length == 1) {
                    String area = (String) vista.myTable1.getValueAt(vista.myTable1.getSelectedRow(), 1);
                    mostrarAdvertencia("Se eliminará el area de " + area + ".");
                    if (MensajeAdvertencia.ACEPTAR == 1) {
                        eliminarArea();
                    }
                } else {
                    mostrarAdvertencia("Se eliminarán todas las areas seleccionadas.");
                    if (MensajeAdvertencia.ACEPTAR == 1) {
                        eliminarArea();
                    }
                }
                break;
        }

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo para limpiar tabla">
    public void limpiarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) vista.myTable1.getModel();
        for (int i = 0; i <= modelo.getRowCount() - 1; i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodos de keyEvent">   
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

    //</editor-fold>
}
