package controlador;

import alertas.MensajeAdvertencia;
import alertas.MensajeError;
import interfaces.GrupoDAO;

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

import modelo.Grupo;

import dao.GrupoDAOimpl;
import db.Conexion;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Grado;
import vista.Grupos;
import vistassecundarias.ModalOpcionesGrupo;

public class ControladorGrupo implements ActionListener, KeyListener, ItemListener {

    private final Grupos vista;

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorGrupo(Grupos vista) {
        this.vista = vista;
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnFiltro.addActionListener(this);
        this.vista.comboboxGrado.addItemListener(this);
        this.vista.comboboxGrupo.addItemListener(this);
        cargarComboboxGrado();
        cargarDatos();
    }

    public void mostrarModalOpcionesGrupo() {
        ModalOpcionesGrupo modal = new ModalOpcionesGrupo((Frame) vista.getTopLevelAncestor(), true);
        modal.setSize(vista.getParent().getParent().getSize());
        modal.setBackground(new Color(0, 0, 0, 75));
        modal.fondo.setBackground(new Color(0, 0, 0, 75));
        modal.setLocationRelativeTo(vista.getParent().getParent());
        modal.setVisible(true);
    }

    public void mostrarModalOpcionesGrupo(Grupo grupo) {
        ModalOpcionesGrupo modal = new ModalOpcionesGrupo((Frame) vista.getTopLevelAncestor(), true, grupo);
        modal.setSize(vista.getParent().getParent().getSize());
        modal.setBackground(new Color(0, 0, 0, 75));
        modal.fondo.setBackground(new Color(0, 0, 0, 75));
        modal.setLocationRelativeTo(vista.getParent().getParent());
        modal.setVisible(true);
    }

    //<editor-fold defaultstate="collapsed" desc="metodo cargarComboboxGrado">
    private void cargarComboboxGrado() {
        Conexion objConexion = new Conexion();
        String sql = "SELECT * FROM GRADO";
        try {
            objConexion.conectar();
            PreparedStatement ps = objConexion.conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            vista.comboboxGrado.addItem(new Grado(0, "Seleccione el grado escolar"));
            while (rs.next()) {
                vista.comboboxGrado.addItem(new Grado(rs.getInt("id"), rs.getString("nombre")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                objConexion.cerrar();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexion " + ex.getMessage());
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodo para llenar el combobox de grupo"> 
    private void cargarGrupos(int id) {
        String sql = "SELECT * FROM grupo WHERE grado_id=?";
        GrupoDAOimpl dao = new GrupoDAOimpl();
        try {

            dao.conectar();
            PreparedStatement ps = dao.conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            vista.comboboxGrupo.removeAllItems();
            vista.comboboxGrupo.addItem(new Grupo(0, "Todos"));
            while (rs.next()) {
                vista.comboboxGrupo.addItem(new Grupo(rs.getInt("id"), rs.getString("nombre")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                dao.cerrar();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexion " + ex.getMessage());
            }
        }
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

    // <editor-fold defaultstate="collapsed" desc="Metodo para eliminar un grupo"> 
    public void eliminarGrupo() {
        GrupoDAOimpl dao = new GrupoDAOimpl();
        DefaultTableModel modelo = (DefaultTableModel) vista.myTable1.getModel();
        int filasSeleccionadas[] = vista.myTable1.getSelectedRows();

        for (int i = filasSeleccionadas.length - 1; i >= 0; i--) {
            try {
                int fila = vista.myTable1.convertRowIndexToModel(filasSeleccionadas[i]);
                dao.eliminar((int) vista.myTable1.getValueAt(filasSeleccionadas[i], 0));
                modelo.removeRow(fila);

            } catch (Exception ex) {
                Logger.getLogger(ControladorGrupo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodo para llenar tabla"> 
    private void cargarDatos() {
        GrupoDAO dao = new GrupoDAOimpl();
        try {
            DefaultTableModel modelo = (DefaultTableModel) vista.myTable1.getModel();
            List<Grupo> lista_grupo = dao.listar();
            for (Grupo g : lista_grupo) {
                modelo.addRow(new Object[]{g.getId(), g.getNombreGrado(), g.getNombre()});
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(Grupos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodo para filtrar tabla"> 
    public void filtrarTabla() {
        int columnaFiltro = 1; //numero de columna que se desea filtrar 
        TableModel tm = vista.myTable1.getModel(); // Objeto TableModel que sera igual al modelo de la tabla
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tm); // 
        Grado grado = (Grado) vista.comboboxGrado.getSelectedItem();
        Grupo grupo = (Grupo) vista.comboboxGrupo.getSelectedItem();
        vista.myTable1.setRowSorter(sorter);
        List<RowFilter<Object, Object>> filtro = new ArrayList<>();
        if (grado.getId() == 0 && grupo.getId() == 0) {
            sorter.setRowFilter(null);
        } else {
            filtro.add(RowFilter.regexFilter("^(?i)" + grado.getNombre(), 1));
            filtro.add(RowFilter.regexFilter("^(?i)" + grupo.getNombre() == null ? "" : grupo.getNombre().equals("Todos") ? "" : grupo.getNombre(), 2));
            RowFilter<Object, Object> filtroCombinado = RowFilter.andFilter(filtro);
            sorter.setRowFilter(filtroCombinado);
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodo para obtener fila seleciconada"> 
    public void obtenerFilaSeleccionada() {

        switch (vista.myTable1.getSelectedRowCount()) {
            case 0:
                mostrarError("Por favor, seleccione el grupo que desea editar.");
                break;
            case 1:
                int id = (int) vista.myTable1.getValueAt(vista.myTable1.getSelectedRow(), 0);
                GrupoDAO dao = new GrupoDAOimpl();
                 {
                    try {
                        mostrarModalOpcionesGrupo(dao.obtenerGrupoPorId(id));
                    } catch (Exception ex) {
                        Logger.getLogger(ControladorGrupo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            default:
                mostrarError("No se puede editar más de 1 grupo a la vez.");
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
                mostrarModalOpcionesGrupo();
                break;
            case "Editar": {
                obtenerFilaSeleccionada();
            }
            break;
            case "Limpiar filtro":
                vista.comboboxGrado.setSelectedIndex(0);
                vista.comboboxGrupo.setSelectedIndex(0);
                filtrarTabla();
                break;
            case "Eliminar":
                if (vista.myTable1.getSelectedRows().length < 1) {
                    mostrarError("Por favor, seleccione el grupo que desea eliminar.");
                } else if (vista.myTable1.getSelectedRows().length == 1) {
                    String grado = (String) vista.myTable1.getValueAt(vista.myTable1.getSelectedRow(), 1);
                    String grupo = (String) vista.myTable1.getValueAt(vista.myTable1.getSelectedRow(), 2);
                    mostrarAdvertencia("Se eliminará el grupo " + grupo + " del grado " + grado + ".");
                    if (MensajeAdvertencia.ACEPTAR == 1) {
                        eliminarGrupo();
                    }
                } else {
                    mostrarAdvertencia("Se eliminarán todos los grupos seleccionados.");
                    if (MensajeAdvertencia.ACEPTAR == 1) {
                        eliminarGrupo();
                    }
                }
                break;
        }
        if (e.getSource() == vista.btnFiltro) {
            vista.comboboxGrado.setSelectedIndex(0);
            vista.comboboxGrupo.setSelectedIndex(0);
            filtrarTabla();
        }

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodo para limpiar tabla">
    private void limpiarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) vista.myTable1.getModel();
        System.out.println("este es el modelo" + modelo.getRowCount());
        System.out.println("este es la tabla" + (vista.myTable1.getRowCount() - 1));
        for (int i = 0; i <= modelo.getRowCount() - 1; i++) {
            modelo.removeRow(i);
            i = i - 1;

            System.out.println("contador tabla" + i);
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
//        if (ke.getSource() == vista.txtBuscar) {
//            filtrarTabla();
//        }
    }
    //</editor-fold>

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == vista.comboboxGrado) {
            Grado grado = (Grado) vista.comboboxGrado.getSelectedItem();
            cargarGrupos(grado.getId());
            filtrarTabla();
        } else if (e.getStateChange() == ItemEvent.SELECTED) {
            filtrarTabla();
        }
    }

}
